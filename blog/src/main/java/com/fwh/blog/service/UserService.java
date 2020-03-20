package com.fwh.blog.service;

import com.fwh.blog.pojo.User;

public interface UserService {
    // 用户登录查询
    User checkUser(String name, String password);
}
