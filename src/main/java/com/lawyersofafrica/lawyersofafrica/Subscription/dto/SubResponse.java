package com.lawyersofafrica.lawyersofafrica.Subscription.dto;

import com.lawyersofafrica.lawyersofafrica.payment.model.Payment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubResponse {
    private Payment payment;
    private int ticketId;
    private String transToken;
}
