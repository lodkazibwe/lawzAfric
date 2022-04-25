package com.lawyersofafrica.lawyersofafrica.payment.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.lawyersofafrica.lawyersofafrica.Subscription.dao.SubscriptionDao;
import com.lawyersofafrica.lawyersofafrica.Subscription.model.Subscription;
import com.lawyersofafrica.lawyersofafrica.exceptions.ResourceNotFoundException;
import com.lawyersofafrica.lawyersofafrica.payment.dao.PaymentDao;
import com.lawyersofafrica.lawyersofafrica.payment.dto.VerifyRequest;
import com.lawyersofafrica.lawyersofafrica.payment.dto.VerifyResponse;
import com.lawyersofafrica.lawyersofafrica.payment.model.Payment;
import com.lawyersofafrica.lawyersofafrica.payment.service.PaymentService;
import com.lawyersofafrica.lawyersofafrica.payment.service.PdoService;
import com.lawyersofafrica.lawyersofafrica.ticket.service.TicketService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired PaymentDao paymentDao;
    @Autowired PdoService pdoService;
    @Autowired SubscriptionDao subscriptionDao;
    @Autowired TicketService ticketService;
    private final Logger logger= LoggerFactory.getLogger(PaymentServiceImpl.class);

    @Override
    public Payment savePayment(Payment payment) {
        return paymentDao.save(payment);
    }

    @Override
    public Payment getPayment(int paymentId) {
        return paymentDao.findById(paymentId).orElseThrow(()-> new ResourceNotFoundException("no such payment "+paymentId));
    }

    @Override
    public List<Payment> getByStatus(String status) {
        return paymentDao.findByPaymentStatus(status);
    }

    @Scheduled(cron = "${name-of-the-cron:0 */3 * * * ?}")
     public void verifyPayments() throws JsonProcessingException {
        logger.info("running cron job...");
        List<Payment> pendingPayments =getByStatus("Pending");
        for(Payment payment:pendingPayments){
            VerifyRequest verifyRequest =new VerifyRequest();
            verifyRequest.setCompanyToken("8D3DA73D-9D7F-4E09-96D4-3D44E7A83EA3");
            verifyRequest.setRequest("verifyToken");
            verifyRequest.setTransactionToken(payment.getTransToken());
            VerifyResponse verifyResponse =pdoService.verifyToken(verifyRequest);
            updatePayment(verifyResponse, payment.getId());
        }

    }

    @Transactional
    public void updatePayment(VerifyResponse verifyResponse, int paymentId){
        Payment payment =getPayment(paymentId);
        int result =verifyResponse.getResult();
        logger.info("Result "+result);
        if(result==0){
            logger.info("successful payment...");
            payment.setPaymentStatus("Settled");
            payment.setVerifyResponse(verifyResponse);
            List<Subscription> subscriptions =subscriptionDao.findByPaymentId(paymentId);
            for(Subscription subscription:subscriptions){
                subscription.setStatus(2);
                logger.info("saving subscription...");
                subscriptionDao.save(subscription);
                logger.info("updating  sold tickets");
                ticketService.updateTicketSold(subscription.getTicket().getId(), 1);
            }logger.info("Message "+ verifyResponse.getResultExplanation());
            logger.info("saving payment...");
            savePayment(payment);

        }else if(result==2 || result==7){
            logger.info("partial payment...");
            payment.setPaymentStatus("Review");
            payment.setVerifyResponse(verifyResponse);
            logger.info("Message "+ verifyResponse.getResultExplanation());
            logger.info("saving payment...");
            savePayment(payment);

        }else if(result==1 || result==3 || result==5 || result==900){
            logger.info("pending payment...");
            payment.setPaymentStatus("Pending");
            payment.setVerifyResponse(verifyResponse);
            logger.info("Message "+ verifyResponse.getResultExplanation());
            logger.info("saving payment...");
            savePayment(payment);
        }else{
            logger.info("failed payment...");
            payment.setPaymentStatus("Failed");
            payment.setVerifyResponse(verifyResponse);
            logger.info("Message "+ verifyResponse.getResultExplanation());
            logger.info("saving payment...");
            savePayment(payment);
        }
    }

    @Override
    public List<Payment> getByStatus(List<String> statuses) {
        return paymentDao.findAllByPaymentStatusIn(statuses);
    }
}
