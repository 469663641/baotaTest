package com.example.service.aop.demo;

import org.springframework.stereotype.Component;

/**
 * Created by baota on 2018/1/14.
 */
@Component
public class ProductService implements Logable{

    //@AdminOnly(role = "common")
    @Log(args = "name")
    public void insert(String name){

        System.err.println("insert product");
    }


}
