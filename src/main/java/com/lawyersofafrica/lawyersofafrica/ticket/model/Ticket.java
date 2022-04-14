package com.lawyersofafrica.lawyersofafrica.ticket.model;

import com.lawyersofafrica.lawyersofafrica.event.model.Event;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

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
    private double price;
    @ManyToOne
    private Event event;
}
