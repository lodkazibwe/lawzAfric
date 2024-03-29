package com.lawyersofafrica.lawyersofafrica.Subscription.dto;

import com.lawyersofafrica.lawyersofafrica.ticket.model.SubEvent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TicketInfo {
    private int ticketId;
    private String ticketName;
    private int quantity;
    private String buyerEmail;
    private String phone;
    private String firstName;
    private String lastName;
    private SubEvent subEvent;
}
