package com.fwh.blog.service.impl;

import com.fwh.blog.dao.UserRepository;
import com.fwh.blog.pojo.User;
import com.fwh.blog.service.UserService;
import com.fwh.blog.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    //用户登录查询
    public User checkUser(String name, String password) {
        //密码采用md5加密
        User user = userRepository.findByUsernameAndPassword(name, MD5Utils.code(password));
        return user;
    }
}
