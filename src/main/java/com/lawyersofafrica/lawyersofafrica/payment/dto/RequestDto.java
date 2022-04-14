package com.lawyersofafrica.lawyersofafrica.payment.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JacksonXmlRootElement(localName="API3G")
public class RequestDto {
    @JacksonXmlProperty(localName ="CompanyToken")
    private String companyToken;
    @JacksonXmlProperty(localName ="Request")
    private String request;
    @JacksonXmlProperty(localName ="Transaction")
    private TransactionDto transaction;
    @JacksonXmlElementWrapper(localName ="Services")
    @JacksonXmlProperty(localName ="Service")
    private List<ServiceDto> services;
}
