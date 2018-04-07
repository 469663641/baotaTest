package com.example.config;

import com.example.service.spring.boot.demo.config.FunctionService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by baota on 2018/4/5.
 */
@Configuration
public class JavaConfig {

    @Bean//用在方法上，返回的是一个Bean
    public FunctionService functionService(){
        return new FunctionService();
    }

}
