package com.lawyersofafrica.lawyersofafrica.ticket.model;

import com.lawyersofafrica.lawyersofafrica.event.model.Event;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ticket {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String detail;
    private String type;
    private int totalTickets;
    private int sold;
    private int currentTicketNumber;
    private String ticketStatus;
    @Column(columnDefinition="Decimal(10,2) default '0.00'")
    private double price;
    @Column(columnDefinition="Decimal(10,2) default '0.00'")
    private double price1;
    @Column(columnDefinition="Decimal(10,2) default '0.00'")
    private double price2;
    @ManyToOne
    private Event event;
}
