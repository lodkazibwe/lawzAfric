package com.lawyersofafrica.lawyersofafrica.sysUser.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SysUser {
    @Id
    private long userId;
    @Column(unique = true)
    private String userName;
    @Column(unique = true)
    private String contact;
    @Column(unique = true)
    private String email;
    private String password;
    private String userStatus;
    @OneToMany
    private Set<Role> roles;
    private String updatedBy;
    private String addedBy;
    private Date dateAdded;
    private Date dateUpdated;
       }
