package com.fwh.blog.dao;

import com.fwh.blog.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    // 查询账号密码
    User findByUsernameAndPassword(String username, String password);
}
