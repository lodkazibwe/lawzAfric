package com.lawyersofafrica.lawyersofafrica.Subscription.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.lawyersofafrica.lawyersofafrica.Subscription.dto.SubResponse;
import com.lawyersofafrica.lawyersofafrica.Subscription.dto.TicketInfo;
import com.lawyersofafrica.lawyersofafrica.Subscription.model.Subscription;
import com.lawyersofafrica.lawyersofafrica.payment.model.Payment;
import com.lawyersofafrica.lawyersofafrica.profile.model.Profile;
import com.lawyersofafrica.lawyersofafrica.ticket.model.SubEvent;

import java.util.List;

public interface SubscriptionService {
    Subscription addSubscription(Subscription subscription);
    List<Subscription> addSubscription(List<Subscription> subscription);
    SubResponse creatPaymentToken(TicketInfo ticketInfo) throws JsonProcessingException;
    List<Subscription> subscribe(List<Profile> profiles, int ticketId, Payment payment, SubEvent subEvent) throws JsonProcessingException;
    SubResponse getToken(TicketInfo ticketInfo, List<Profile> profiles) throws JsonProcessingException;
    void updatePayment();
    Subscription getSubscription(int id);
    List<Subscription> getAll();
    List<Subscription> getAll(int status);
    List<Subscription> getAll(List<Integer> statuses);
    int markAsDownloaded(List<Integer> subIds);
    int markAsPaid(List<Integer> subIds);
    List<Subscription> saveSubscription(TicketInfo ticketInfo, List<Profile> profiles);
}
