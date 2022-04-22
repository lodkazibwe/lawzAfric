package com.lawyersofafrica.lawyersofafrica.Subscription.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.lawyersofafrica.lawyersofafrica.Subscription.dto.SubRequest;
import com.lawyersofafrica.lawyersofafrica.Subscription.dto.SubResponse;
import com.lawyersofafrica.lawyersofafrica.Subscription.model.Subscription;
import com.lawyersofafrica.lawyersofafrica.Subscription.service.SubscriptionService;
import com.lawyersofafrica.lawyersofafrica.payment.model.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
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

    @GetMapping("/all/{status}")
    public ResponseEntity<List<Subscription>> getPayments(@PathVariable int status){
        return new ResponseEntity<>(subscriptionService.getAll(status), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Subscription>> getAll(){
        List<Integer> statuses = Arrays.asList(1, 2);
        return new ResponseEntity<>(subscriptionService.getAll(statuses), HttpStatus.OK);
    }

    @PutMapping("/paid")
    public ResponseEntity<Integer> markAsPaid(@RequestBody List<Integer> subIds){
        return new ResponseEntity<>(subscriptionService.markAsPaid(subIds), HttpStatus.OK);

    }
    @PutMapping("/download")
    public ResponseEntity<Integer> markAsDownloaded(@RequestBody List<Integer> subIds){
        return new ResponseEntity<>(subscriptionService.markAsDownloaded(subIds), HttpStatus.OK);

    }

}
