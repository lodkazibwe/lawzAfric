package com.lawyersofafrica.lawyersofafrica.Subscription.model;

import com.lawyersofafrica.lawyersofafrica.payment.model.Payment;
import com.lawyersofafrica.lawyersofafrica.profile.model.Profile;
import com.lawyersofafrica.lawyersofafrica.ticket.model.Ticket;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Subscription {
    @Id
    @GeneratedValue
    private int id;
    private Date subscriptionDate;
    private int ticketNumber;
    @ManyToOne
    private Ticket ticket;
    @ManyToOne
    private Profile profile;
    @ManyToOne
    private Payment payment;
    private int status;//1=pending, 2=paid
}