package com.lawyersofafrica.lawyersofafrica.sysUser.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role {
    @Id
    private long roleId;
    private String roleName;

    public Role(String role) {
        this.roleName=role;
    }
}
