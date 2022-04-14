package com.lawyersofafrica.lawyersofafrica.Subscription.dao;

import com.lawyersofafrica.lawyersofafrica.Subscription.model.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubscriptionDao extends JpaRepository<Subscription, Integer> {

    @Query("SELECT new com.lawyersofafrica.lawyersofafrica.Subscription.model.Subscription(" +
            "s.id,s.subscriptionDate,s.ticketNumber,s.ticket,s.profile,s.payment,s.status) " +
            "FROM Subscription s JOIN s.payment p WHERE p.id=?1")
    List<Subscription> findByPaymentId(int id);
}
