package com.lawyersofafrica.lawyersofafrica.payment.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JacksonXmlRootElement(localName="API3G")
public class VerifyRequest {
    @JacksonXmlProperty(localName ="CompanyToken")
    private String companyToken;
    @JacksonXmlProperty(localName ="Request")
    private String request;
    @JacksonXmlProperty(localName ="TransactionToken")
    private String transactionToken;
    }
