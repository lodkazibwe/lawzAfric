package com.lawyersofafrica.lawyersofafrica.Subscription.dto;

import com.lawyersofafrica.lawyersofafrica.profile.model.Profile;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubRequest {
    TicketInfo ticketInfo;
    List<Profile> profiles;
}
