package com.lawyersofafrica.lawyersofafrica.ticket.rest;

import com.lawyersofafrica.lawyersofafrica.ticket.model.Ticket;
import com.lawyersofafrica.lawyersofafrica.ticket.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/ticket")
public class TicketController {
    @Autowired TicketService ticketService;

    @GetMapping("/all")
    public ResponseEntity<List<Ticket>> getAll(){
        return new ResponseEntity<>(ticketService.getAll(), HttpStatus.OK);
    }
}
