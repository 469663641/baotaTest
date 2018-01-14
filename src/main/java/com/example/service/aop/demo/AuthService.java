package com.example.service.aop.demo;

import org.springframework.stereotype.Component;

/**
 * Created by baota on 2018/1/14.
 */
@Component
public class AuthService {
    public void checkAccess(){
        System.err.println("check security");


    }
}
