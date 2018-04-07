package com.example.service.spring.boot.demo.config;

import com.example.service.spring.boot.demo.config.FunctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by baota on 2018/4/5.
 */
@Service
public class UseFunctionService {
    @Autowired
    private FunctionService functionService;

    public String sayHello(){
        return functionService.sayHello();
    }
}
