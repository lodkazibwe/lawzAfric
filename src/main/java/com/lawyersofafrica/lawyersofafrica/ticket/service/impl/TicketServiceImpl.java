package com.lawyersofafrica.lawyersofafrica.ticket.service.impl;

import com.lawyersofafrica.lawyersofafrica.exceptions.ResourceNotFoundException;
import com.lawyersofafrica.lawyersofafrica.ticket.dao.TicketDao;
import com.lawyersofafrica.lawyersofafrica.ticket.model.Ticket;
import com.lawyersofafrica.lawyersofafrica.ticket.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {
    @Autowired TicketDao ticketDao;
    @Override
    public Ticket addTicket(Ticket ticket) {
        return ticketDao.save(ticket);
    }

    @Override
    public Ticket getTicket(String name) {
        Ticket ticket = ticketDao.findByName(name);
        if(ticket==null){
            throw new ResourceNotFoundException("No such ticket With ID: " +name);
        }
        return ticket;
    }

    @Override
    public List<Ticket> addTicket(List<Ticket> tickets) {
        return ticketDao.saveAll(tickets);
    }

    @Override
    public Ticket getTicket(int ticketId) {
        return ticketDao.findById(ticketId)
                .orElseThrow(()->new ResourceNotFoundException("No such ticket With ID: " +ticketId));
    }

    @Override
    public Ticket updateTicket(Ticket ticket) {
        return null;
    }

    @Override
    public void updateTicketNumber(int ticketId, int ticketNo) {
        Ticket ticket= getTicket(ticketId);
        ticket.setCurrentTicketNumber(ticketNo);
        ticket.setSold(ticket.getSold()+1);
        addTicket(ticket);
    }

    @Override
    public List<Ticket> getAll() {
        return ticketDao.findAll();
    }
}
