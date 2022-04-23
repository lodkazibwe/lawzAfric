package com.lawyersofafrica.lawyersofafrica.Subscription.rest;

import com.lawyersofafrica.lawyersofafrica.Subscription.model.Subscription;
import com.lawyersofafrica.lawyersofafrica.Subscription.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/sub")
public class AdminController {
    @Autowired
    SubscriptionService subscriptionService;

    @GetMapping("/getAll")
    public ResponseEntity<List<Subscription>> getPayments(){
        return new ResponseEntity<>(subscriptionService.getAll(), HttpStatus.OK);
    }
    @GetMapping("/all/{status}")
    public ResponseEntity<List<Subscription>> getPayments(@PathVariable int status){
        return new ResponseEntity<>(subscriptionService.getAll(status), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Subscription>> getAll(){
        List<Integer> statuses = Arrays.asList(3, 2);
        return new ResponseEntity<>(subscriptionService.getAll(statuses), HttpStatus.OK);
    }

    /*@PutMapping("/paid")
    public ResponseEntity<Integer> markAsPaid(@RequestBody List<Integer> subIds){
        return new ResponseEntity<>(subscriptionService.markAsPaid(subIds), HttpStatus.OK);

    }
    @PutMapping("/download")
    public ResponseEntity<Integer> markAsDownloaded(@RequestBody List<Integer> subIds){
        return new ResponseEntity<>(subscriptionService.markAsDownloaded(subIds), HttpStatus.OK);

    }*/
}
