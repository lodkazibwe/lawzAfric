package com.lawyersofafrica.lawyersofafrica.ticket.service;

import com.lawyersofafrica.lawyersofafrica.ticket.model.Ticket;

import java.util.List;

public interface TicketService {
    Ticket addTicket(Ticket ticket);
    List<Ticket> addTicket(List<Ticket> tickets);
    Ticket getTicket(int ticketId);
    Ticket getTicket(String name);
    List<Ticket> getAll();
    Ticket updateTicket(Ticket ticket);

    void updateTicketNumber(int ticketId, int ticketNo);
}
