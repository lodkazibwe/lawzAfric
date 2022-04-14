package com.lawyersofafrica.lawyersofafrica.sysUser.dao;


import com.lawyersofafrica.lawyersofafrica.sysUser.model.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO extends JpaRepository<SysUser, Long> {

    SysUser findByUserName(String userName);
    //SysUser findByUserNameOrContactOrEmail(String userName, String contact, String email);


}
