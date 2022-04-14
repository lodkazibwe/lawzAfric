package com.lawyersofafrica.lawyersofafrica.profile.model;

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
public class Profile {
    @Id
    @GeneratedValue
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String company;
    private String position;
    private String barAssociation;
    private String address;
    private String city;
    private String country;
    private String gender;
    private String language;
}
