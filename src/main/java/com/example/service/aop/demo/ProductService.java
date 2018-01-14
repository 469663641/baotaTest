package com.example.service.aop.demo;

import org.springframework.stereotype.Component;

/**
 * Created by baota on 2018/1/14.
 */
@Component
public class ProductService {

    @AdminOnly
    public void insert(){

        System.err.println("insert product");
    }


}
