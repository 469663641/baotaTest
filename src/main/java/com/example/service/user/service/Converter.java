package com.example.service.user.service;

import com.example.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.cglib.beans.BeanCopier;

/**
 * Created by baota on 2018/2/4.
 */
public class Converter {

    public static UserDTO toDTO(User user){
        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(user, userDTO);
        return userDTO;

    }
}
