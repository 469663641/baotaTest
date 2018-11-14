package com.example.service.user.service;

import com.example.mapper.UserMapper;
import com.example.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by baota on 2017/4/7.
 */
//@Service
public class UserService {
    //@Autowired
    private UserMapper userMapper;

    public void insert(User user) {
        userMapper.insert(user);

    }

    public User queryByAccount(String account){
        return userMapper.queryByAccount(account);

    }


}
