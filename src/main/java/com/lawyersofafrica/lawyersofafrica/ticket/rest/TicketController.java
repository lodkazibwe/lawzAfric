package com.lawyersofafrica.lawyersofafrica.ticket.rest;

import com.lawyersofafrica.lawyersofafrica.ticket.model.Ticket;
import com.lawyersofafrica.lawyersofafrica.ticket.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @PutMapping("/update")
    public ResponseEntity<Ticket> update(){
        return new ResponseEntity<>(ticketService.updateTicket("VIRTUAL"), HttpStatus.OK);
    }
}
