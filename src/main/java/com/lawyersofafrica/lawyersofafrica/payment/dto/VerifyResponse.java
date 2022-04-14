package com.lawyersofafrica.lawyersofafrica.payment.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JacksonXmlRootElement(localName="API3G")
@JsonIgnoreProperties(ignoreUnknown = true)
public class VerifyResponse {
    @Id
    @GeneratedValue
    private int id;
    @JacksonXmlProperty(localName ="Result")
    private int result;
    @JacksonXmlProperty(localName ="ResultExplanation")
    private String resultExplanation;
    @JacksonXmlProperty(localName ="CustomerName")
    private String customerName;
    @JacksonXmlProperty(localName ="CustomerCredit")
    private String customerCredit;
    @JacksonXmlProperty(localName ="TransactionApproval")
    private String transactionApproval;
    @JacksonXmlProperty(localName ="TransactionCurrency")
    private String transactionCurrency;
    @JacksonXmlProperty(localName ="TransactionAmount")
    private double transactionAmount;
    @JacksonXmlProperty(localName ="FraudAlert")
    private int fraudAlert;
    @JacksonXmlProperty(localName ="FraudExplnation")
    private String fraudExplnation;
    @JacksonXmlProperty(localName ="TransactionNetAmount")
    private double transactionNetAmount;
    @JacksonXmlProperty(localName ="CustomerPhone")
    private String customerPhone;
    @JacksonXmlProperty(localName ="CustomerCountry")
    private String customerCountry;
    @JacksonXmlProperty(localName ="CustomerAddress")
    private String customerAddress;
    @JacksonXmlProperty(localName ="CustomerCity")
    private String customerCity;
    @JacksonXmlProperty(localName ="MobilePaymentRequest")
    private String mobilePaymentRequest;
    //CustomerCredit
}
