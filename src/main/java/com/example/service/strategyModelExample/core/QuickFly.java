package com.example.service.strategyModelExample.core;

import com.example.service.strategyModelExample.api.Flyable;

/**
 * Created by baota on 2018/1/7.
 */
public class QuickFly implements Flyable{
    @Override
    public void fly(){
        System.err.println("quick fly");

    }
}
