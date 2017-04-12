package com.example.controller;

import com.example.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by baota on 2017/3/31.
 */
@Controller
public class UserController {
    @RequestMapping(value = "/test",method = RequestMethod.GET)
    @ResponseBody
    public User test(){
        return User.builder()
                .nickname("baota")
                .account("baota")
                .build();
    }
}
