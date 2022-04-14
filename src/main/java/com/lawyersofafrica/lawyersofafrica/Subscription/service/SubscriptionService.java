package com.lawyersofafrica.lawyersofafrica.Subscription.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.lawyersofafrica.lawyersofafrica.Subscription.dto.SubRequest;
import com.lawyersofafrica.lawyersofafrica.Subscription.dto.SubResponse;
import com.lawyersofafrica.lawyersofafrica.Subscription.dto.TicketInfo;
import com.lawyersofafrica.lawyersofafrica.Subscription.model.Subscription;
import com.lawyersofafrica.lawyersofafrica.profile.model.Profile;

import java.util.List;

public interface SubscriptionService {
    Subscription addSubscription(Subscription subscription);
    List<Subscription> addSubscription(List<Subscription> subscription);
    SubResponse creatPaymentToken(TicketInfo ticketInfo) throws JsonProcessingException;
    List<Subscription> subscribe(List<Profile> profiles, int ticketId, int paymentId) throws JsonProcessingException;
    SubResponse getToken(TicketInfo ticketInfo, List<Profile> profiles) throws JsonProcessingException;
    void updatePayment();
}
