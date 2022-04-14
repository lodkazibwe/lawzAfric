package com.lawyersofafrica.lawyersofafrica.ticket.dao;

import com.lawyersofafrica.lawyersofafrica.ticket.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketDao extends JpaRepository<Ticket, Integer> {
    Ticket findByName(String name);
}
