package com.example.mapper;

import com.example.model.User;

/**
 * Created by baota on 2017/4/7.
 */

public interface UserMapper {
    void insert(User user);

    User queryByAccount(String account);

}
