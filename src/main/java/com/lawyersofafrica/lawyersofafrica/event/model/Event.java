package com.lawyersofafrica.lawyersofafrica.event.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Event {
    @Id
    @GeneratedValue
    private int id;
    private String eventKey;
    private String title;
    private String description;
    private Date startDate;
    private Date endDate;
    private String theme;
    private String eventStatus;
}
