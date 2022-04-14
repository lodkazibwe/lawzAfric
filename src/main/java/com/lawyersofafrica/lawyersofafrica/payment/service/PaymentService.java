package com.lawyersofafrica.lawyersofafrica.payment.service;

import com.lawyersofafrica.lawyersofafrica.payment.model.Payment;

import java.util.List;

public interface PaymentService {
    Payment savePayment(Payment payment);
    Payment getPayment(int paymentId);
    List<Payment> getByStatus(String status);
}
