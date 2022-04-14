package com.lawyersofafrica.lawyersofafrica.payment.model;

import com.lawyersofafrica.lawyersofafrica.payment.dto.ResponseDto;
import com.lawyersofafrica.lawyersofafrica.payment.dto.VerifyResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment {
    @Id
    @GeneratedValue
    private int id;
    private String customerEmail;
    private String customerPhone;
    private double paymentAmount;
    private String paymentCurrency;
    private String paymentMethod;//set after transaction
    private String internalReference;
    private String paymentStatus;
    
    private int result;
    private String resultExplanation;
    private String transToken;
    private String transRef;
    private String notes;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn
    private VerifyResponse verifyResponse;
}
