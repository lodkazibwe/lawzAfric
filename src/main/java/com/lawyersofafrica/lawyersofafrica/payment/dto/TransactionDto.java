package com.lawyersofafrica.lawyersofafrica.payment.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlElement;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JacksonXmlRootElement(localName="Transaction")
public class TransactionDto {
    @JacksonXmlProperty(localName ="PaymentAmount")
    private double paymentAmount;
    @JacksonXmlProperty(localName ="PaymentCurrency")
    private String paymentCurrency;
    @JacksonXmlProperty(localName ="CompanyRef")
    private String companyRef;
    @JacksonXmlProperty(localName ="RedirectURL")
    private String redirectURL;
    @JacksonXmlProperty(localName ="BackURL")
    private String backURL;
    @JacksonXmlProperty(localName ="CompanyRefUnique")
    private int companyRefUnique;//true
    //@JacksonXmlProperty(localName ="customerCountry")
    //private List<ServiceDto> customerCountry;

    private String customerEmail;
    private String customerFirstName;
    private String customerLastName;
    private String customerPhone;
    @JacksonXmlProperty(localName ="DefaultPayment")
    private String defaultPayment;//CC – Credit card

}
