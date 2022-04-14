package com.lawyersofafrica.lawyersofafrica.payment.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.lawyersofafrica.lawyersofafrica.payment.dto.RequestDto;
import com.lawyersofafrica.lawyersofafrica.payment.dto.ResponseDto;
import com.lawyersofafrica.lawyersofafrica.payment.service.PdoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("/pdo")
public class PdoController {
    @Autowired PdoService pdoService;

    /*@PostMapping("/getString")
    public ResponseEntity<ResponseDto> processString(@Valid @RequestBody RequestDto requestDto) throws JsonProcessingException {
        return new ResponseEntity<>(pdoService.makeRequestTest(requestDto), HttpStatus.OK);
    }

    @PostMapping("/getResponse")
    public ResponseEntity<ResponseDto> process(@Valid @RequestBody RequestDto requestDto) throws JsonProcessingException {
        return new ResponseEntity<>(pdoService.createToken(requestDto), HttpStatus.OK);
    }*/
}
