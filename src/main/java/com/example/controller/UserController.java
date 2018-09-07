package com.example.controller;

import com.example.constant.LoginType;
import com.example.model.User;
import com.example.service.annotation.LoginApiInject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by baota on 2017/3/31.
 */
@Controller
public class UserController {

    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    @ResponseBody
    @LoginApiInject(type = LoginType.NOTLOGIN)
    public User test() {
        return User.builder()
                .nickname("baota")
                .account("baota")
                .build();
    }

    @RequestMapping(value = "redis", method = RequestMethod.GET)
    @ResponseBody
    @LoginApiInject(type = LoginType.NOTLOGIN)
    public String testCache() {
        redisTemplate.opsForValue().set("baota", "423412阿斯顿撒多");
        String result = (String) redisTemplate.opsForValue().get("123");
        System.out.println(result);
        return "ok";

    }
}
