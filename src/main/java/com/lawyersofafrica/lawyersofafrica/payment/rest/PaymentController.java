package com.lawyersofafrica.lawyersofafrica.payment.rest;

import com.lawyersofafrica.lawyersofafrica.payment.model.Payment;
import com.lawyersofafrica.lawyersofafrica.payment.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/pay")
public class PaymentController {
    @Autowired PaymentService paymentService;

    @GetMapping("/all/{status}")
    public ResponseEntity<List<Payment>> getPayments(@PathVariable String status){
        return new ResponseEntity<>(paymentService.getByStatus(status), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Payment>> getAll(){
        List<String> statuses = Arrays.asList("Pending", "Review", "Settled");
        return new ResponseEntity<>(paymentService.getByStatus(statuses), HttpStatus.OK);
    }

}
