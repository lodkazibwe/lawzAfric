package com.lawyersofafrica.lawyersofafrica.payment.dao;

import com.lawyersofafrica.lawyersofafrica.payment.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentDao extends JpaRepository<Payment,Integer> {

    List<Payment> findByPaymentStatus(String status);

    List<Payment> findAllByPaymentStatusIn(List<String> statuses);

}
