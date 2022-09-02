package com.lawyersofafrica.lawyersofafrica.ticket.service;

import com.lawyersofafrica.lawyersofafrica.ticket.model.Ticket;

import java.util.List;

public interface TicketService {
    Ticket addTicket(Ticket ticket);
    List<Ticket> addTicket(List<Ticket> tickets);
    Ticket getTicket(int ticketId);
    Ticket getTicket(String name);
    Ticket deleteTicket(int id);
    List<Ticket> getAll();
    Ticket updateTicket(String name);
    void updateTicketSold(int ticketId, int amt);
    void updateTicketNumber(int ticketId, int ticketNo);
    void updatePrices(String ticketName, double price, double price1, double price2);

}
