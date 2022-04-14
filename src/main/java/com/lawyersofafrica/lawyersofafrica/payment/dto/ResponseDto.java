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
public class ResponseDto {
    @JacksonXmlProperty(localName ="Result")
    private int result;
    @JacksonXmlProperty(localName ="ResultExplanation")
    private String resultExplanation;
    @JacksonXmlProperty(localName ="TransToken")
    private String transToken;
    @JacksonXmlProperty(localName ="TransRef")
    private String transRef;
    @JacksonXmlProperty(localName ="notes")
    private String notes;//notes
    }
