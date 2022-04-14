package com.lawyersofafrica.lawyersofafrica.payment.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.google.common.collect.Lists;
import com.lawyersofafrica.lawyersofafrica.exceptions.ResourceNotFoundException;
import com.lawyersofafrica.lawyersofafrica.payment.dto.RequestDto;
import com.lawyersofafrica.lawyersofafrica.payment.dto.ResponseDto;
import com.lawyersofafrica.lawyersofafrica.payment.dto.VerifyRequest;
import com.lawyersofafrica.lawyersofafrica.payment.dto.VerifyResponse;
import com.lawyersofafrica.lawyersofafrica.payment.service.PdoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.xml.bind.JAXB;
import java.io.StringWriter;
import java.nio.charset.Charset;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class PdoServiceImpl implements PdoService {
    @Autowired
    RestTemplate restTemplate ;
    private final Logger logger= LoggerFactory.getLogger(PdoServiceImpl.class);

    @Override
    public ResponseDto createToken(RequestDto requestDt) throws JsonProcessingException {
        logger.info("generating xml... ");
        final String url ="https://secure.3gdirectpay.com/API/v6/";
        HttpHeaders headers =new HttpHeaders();
        headers.add("Content-Type", "application/xml; charset=utf-8");
        XmlMapper xmlMapper =new XmlMapper();
        String file =xmlMapper.writeValueAsString(requestDt);
        String xml ="<?xml version=\"1.0\" encoding=\"utf-8\"?>"+file;
        HttpEntity<String> request = new HttpEntity<>(xml, headers);
        logger.info("connecting to pdo... ");
        ResponseEntity<String> response = restTemplate.postForEntity( url, request , String.class );
             logger.info("status code "+response.getStatusCode());
                   return xmlMapper.readValue(response.getBody(), ResponseDto.class);

            }

    @Override
    public VerifyResponse verifyToken(VerifyRequest requestV) throws JsonProcessingException {
        logger.info("generating xml... ");
        final String url ="https://secure.3gdirectpay.com/API/v6/";
        HttpHeaders headers =new HttpHeaders();
        headers.add("Content-Type", "application/xml; charset=utf-8");
        XmlMapper xmlMapper =new XmlMapper();
        String file =xmlMapper.writeValueAsString(requestV);
        String xml ="<?xml version=\"1.0\" encoding=\"utf-8\"?>"+file;
        HttpEntity<String> request = new HttpEntity<>(xml, headers);
        logger.info("connecting to pdo... ");
        ResponseEntity<String> response = restTemplate.postForEntity( url, request , String.class );
        logger.info("status code "+response.getStatusCode());
        return xmlMapper.readValue(response.getBody(), VerifyResponse.class);

    }
}