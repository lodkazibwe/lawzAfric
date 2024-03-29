package com.lawyersofafrica.lawyersofafrica.Subscription.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.lawyersofafrica.lawyersofafrica.Subscription.dto.SubRequest;
import com.lawyersofafrica.lawyersofafrica.Subscription.dto.SubResponse;
import com.lawyersofafrica.lawyersofafrica.Subscription.model.Subscription;
import com.lawyersofafrica.lawyersofafrica.Subscription.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/subscription")
public class SubscriptionController {
    @Autowired SubscriptionService subscriptionService;

    @PostMapping("/getToken")
    public ResponseEntity<SubResponse> processToken(@RequestBody SubRequest subRequest) throws JsonProcessingException {
        return new ResponseEntity<>(subscriptionService.getToken(subRequest.getTicketInfo(), subRequest.getProfiles()), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<List<Subscription>> saveSubscription(@RequestBody SubRequest subRequest){
        return new ResponseEntity<>(subscriptionService.saveSubscription(subRequest.getTicketInfo(), subRequest.getProfiles()), HttpStatus.OK);
    }



}
