package com.lawyersofafrica.lawyersofafrica.Subscription.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.lawyersofafrica.lawyersofafrica.payment.model.Payment;
import com.lawyersofafrica.lawyersofafrica.profile.model.Profile;
import com.lawyersofafrica.lawyersofafrica.ticket.model.SubEvent;
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
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd", locale = "pt-BR", timezone = "EAT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date subscriptionDate;
    private int ticketNumber;
    @ManyToOne
    @JoinColumn
    private Ticket ticket;
    @ManyToOne
    @JoinColumn
    private Profile profile;
    @ManyToOne
    @JoinColumn
    private Payment payment;
    private int status;//1=pending, 2=paid, 3=downloaded
    @Enumerated(EnumType.STRING)
    private SubEvent subEvent;
}
