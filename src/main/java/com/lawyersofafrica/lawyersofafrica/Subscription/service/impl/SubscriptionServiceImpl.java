package com.lawyersofafrica.lawyersofafrica.Subscription.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.lawyersofafrica.lawyersofafrica.Subscription.dao.SubscriptionDao;
import com.lawyersofafrica.lawyersofafrica.Subscription.dto.SubResponse;
import com.lawyersofafrica.lawyersofafrica.Subscription.dto.TicketInfo;
import com.lawyersofafrica.lawyersofafrica.Subscription.model.Subscription;
import com.lawyersofafrica.lawyersofafrica.Subscription.service.SubscriptionService;
import com.lawyersofafrica.lawyersofafrica.exceptions.ResourceNotFoundException;
import com.lawyersofafrica.lawyersofafrica.payment.dto.RequestDto;
import com.lawyersofafrica.lawyersofafrica.payment.dto.ResponseDto;
import com.lawyersofafrica.lawyersofafrica.payment.dto.ServiceDto;
import com.lawyersofafrica.lawyersofafrica.payment.dto.TransactionDto;
import com.lawyersofafrica.lawyersofafrica.payment.model.Payment;
import com.lawyersofafrica.lawyersofafrica.payment.service.PaymentService;
import com.lawyersofafrica.lawyersofafrica.payment.service.PdoService;
import com.lawyersofafrica.lawyersofafrica.profile.dao.ProfileDao;
import com.lawyersofafrica.lawyersofafrica.profile.model.Profile;
import com.lawyersofafrica.lawyersofafrica.ticket.model.Ticket;
import com.lawyersofafrica.lawyersofafrica.ticket.service.TicketService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {
    @Autowired TicketService ticketService;
    @Autowired PdoService pdoService;
    @Autowired SubscriptionDao subscriptionDao;
    @Autowired PaymentService paymentService;
    @Autowired ProfileDao profileDao;
    private final Logger logger= LoggerFactory.getLogger(SubscriptionServiceImpl.class);

    @Override
    public Subscription addSubscription(Subscription subscription) {
        return subscriptionDao.save(subscription);
    }

    @Override
    public List<Subscription> addSubscription(List<Subscription> subscription) {
        return subscriptionDao.saveAll(subscription);
    }

    @Transactional
    @Override
    public SubResponse creatPaymentToken(TicketInfo ticketInfo) throws JsonProcessingException {
        logger.info("get total amount and ticket");
        Ticket ticket = ticketService.getTicket(ticketInfo.getTicketName());
        double amount = ticketInfo.getQuantity() * ticket.getPrice();
        RequestDto requestDto = new RequestDto();
        List<ServiceDto> serviceDtos =new ArrayList<>();
        logger.info("generating and setting service");
        ServiceDto serviceDto = new ServiceDto();
        serviceDto.setServiceDate(new Date());
        serviceDto.setServiceDescription(ticket.getDetail());
        serviceDto.setServiceType(5524);
        logger.info("setting service...");
        serviceDtos.add(serviceDto);
        requestDto.setServices(serviceDtos);
        logger.info("generating and setting transaction");
        Random rnd = new Random();
        int number = rnd.nextInt(999999);
        String ref ="PALU"+String.format("%06d", number);
        TransactionDto transactionDto = new TransactionDto();
        transactionDto.setBackURL("https://lawyersofafrica.glueup.com");
        transactionDto.setCompanyRef(ref);
        transactionDto.setCompanyRefUnique(1);
        transactionDto.setCustomerEmail(ticketInfo.getBuyerEmail());
        transactionDto.setCustomerFirstName(ticketInfo.getFirstName());
        transactionDto.setCustomerLastName(ticketInfo.getLastName());
        transactionDto.setCustomerPhone(ticketInfo.getPhone());
        transactionDto.setDefaultPayment("CC");
        transactionDto.setPaymentAmount(amount);
        transactionDto.setPaymentCurrency("USD");
        transactionDto.setRedirectURL("https://lawyersofafrica.glueup.com");
        requestDto.setTransaction(transactionDto);
        logger.info("generating and setting company details");
        requestDto.setCompanyToken("CAAF329A-C8FA-427B-9D34-AE3AF3202E55");
        requestDto.setRequest("createToken");
        ResponseDto responseDto = pdoService.createToken(requestDto);
        if (responseDto.getTransRef() == null & responseDto.getTransToken() == null) {
            logger.info("retrying pdo once");
            responseDto= pdoService.createToken(requestDto);

        }
         if (responseDto.getTransRef() == null & responseDto.getTransToken() == null) {
                        logger.info("retrying failed");
                      throw new ResourceNotFoundException(responseDto.getResultExplanation() + "result "+responseDto.getResult());
                   }
            Payment payment =generatePayment(responseDto, amount, transactionDto.getCustomerEmail()
                    , transactionDto.getCustomerPhone(), transactionDto.getCompanyRef());
            logger.info("saving payment");
        Payment myPayment=paymentService.savePayment(payment);
        SubResponse subResponse =new SubResponse();
        subResponse.setPayment(myPayment);
        subResponse.setTicketId(ticket.getId());
        subResponse.setTransToken(responseDto.getTransToken());
        return subResponse;
    }

    @Transactional
    @Override
    public List<Subscription> subscribe(List<Profile> profiles, int ticketId, Payment payment) {
        Ticket ticket =ticketService.getTicket(ticketId);
        int ticketNo =ticket.getCurrentTicketNumber();
        List<Subscription> subscriptions =new ArrayList<>();
        logger.info("saving subscriptions");
        for(Profile profileDto: profiles){
            Profile profile =generateProfile(profileDto);
            Subscription subscription =new Subscription();
            subscription.setPayment(payment);
            subscription.setProfile(profile);
            subscription.setStatus(1);
            subscription.setSubscriptionDate(new Date());
            subscription.setTicket(ticket);
            subscription.setTicketNumber(ticketNo);
            ticketNo+=1;
            subscriptions.add(subscription);

        }
        logger.info("updating  current ticket number");
        ticketService.updateTicketNumber(ticket.getId(), ticketNo);
        logger.info("saving subscriptions");
        return addSubscription(subscriptions);
    }
    private Profile generateProfile(Profile profileDto){
        return profileDao.save(profileDto);
    }

        @Override
    public void updatePayment() {

    }

    private Payment generatePayment(ResponseDto responseDto, double amount, String email, String phone, String ref){
        logger.info("generate payment");
        Payment payment = new Payment();
        payment.setCustomerEmail(email);
        payment.setCustomerPhone(phone);
        payment.setInternalReference(ref);
        payment.setPaymentAmount(amount);
        payment.setPaymentCurrency("USD");
        payment.setPaymentStatus("Pending");
        payment.setResult(responseDto.getResult());
        payment.setResultExplanation(responseDto.getResultExplanation());
        payment.setTransToken(responseDto.getTransToken());
        payment.setTransRef(responseDto.getTransRef());
        payment.setNotes(responseDto.getNotes());
        return payment;
    }


    @Override
    public SubResponse getToken(TicketInfo ticketInfo, List<Profile> profiles) throws JsonProcessingException {
        logger.info("generate Token");
        SubResponse subResponse =creatPaymentToken(ticketInfo);
        logger.info("save subscriptions");
        subscribe(profiles, subResponse.getTicketId(), subResponse.getPayment());
        return subResponse;
    }

    @Override
    public Subscription getSubscription(int id) {
        return subscriptionDao.findById(id).orElseThrow(()-> new ResourceNotFoundException("no such payment "+id));
    }

    @Override
    public List<Subscription> getAll() {
        return subscriptionDao.findAll();
    }

    @Override
    public List<Subscription> getAll(int status) {
        return subscriptionDao.findByStatus(status);
    }

    @Override
    public List<Subscription> getAll(List<Integer> statuses) {
          return subscriptionDao.findAllByStatusIn(statuses);
    }

    @Override
    public int markAsDownloaded(List<Integer> subIds) {
        for(int id:subIds){
            updateStatus(id, 3);
        }
        return 1;
    }

    @Override
    public int markAsPaid(List<Integer> subIds) {
        for(int id:subIds){
            updateStatus(id, 2);
        }
        return 1;
    }
    private void updateStatus(int subId, int status){
        Subscription subscription = getSubscription(subId);
        subscription.setStatus(status);
        subscriptionDao.save(subscription);
    }

}
