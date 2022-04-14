package com.lawyersofafrica.lawyersofafrica.Subscription.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubResponse {
    private int paymentId;
    private int ticketId;
    private String transToken;
}
