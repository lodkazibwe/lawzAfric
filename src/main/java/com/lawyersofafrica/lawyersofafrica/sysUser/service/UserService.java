package com.lawyersofafrica.lawyersofafrica.sysUser.service;

import com.lawyersofafrica.lawyersofafrica.sysUser.model.SysUser;

import java.util.List;

public interface UserService {
    SysUser contactSignUp(String contact);
    SysUser emailSignUp(String email);
    SysUser addAdmin(SysUser sysUser);
    SysUser getUser(long userId);
    SysUser addRole(long userId, String role);
    List<SysUser> getAll();
}
