package com.lawyersofafrica.lawyersofafrica.payment.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
@JacksonXmlRootElement(localName="Service")
public class ServiceDto {
    @JacksonXmlProperty(localName ="ServiceDescription")
    private String serviceDescription;
    @JacksonXmlProperty(localName ="ServiceType")
    private int serviceType;
    @JacksonXmlProperty(localName ="ServiceDate")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd", locale = "pt-BR", timezone = "EAT")
    @Temporal(TemporalType.DATE)
    private Date serviceDate;//YYYY/MM/DD HH:MM (dateTime)
}
