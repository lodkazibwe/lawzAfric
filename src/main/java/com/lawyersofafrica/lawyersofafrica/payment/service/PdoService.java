package com.lawyersofafrica.lawyersofafrica.payment.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.lawyersofafrica.lawyersofafrica.payment.dto.RequestDto;
import com.lawyersofafrica.lawyersofafrica.payment.dto.ResponseDto;
import com.lawyersofafrica.lawyersofafrica.payment.dto.VerifyRequest;
import com.lawyersofafrica.lawyersofafrica.payment.dto.VerifyResponse;

public interface PdoService {
    ResponseDto createToken(RequestDto request) throws JsonProcessingException;
    VerifyResponse verifyToken(VerifyRequest request) throws JsonProcessingException;

}
