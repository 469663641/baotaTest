package com.example.service.strategy.model.core;

import com.example.service.strategy.model.api.Flyable;

/**
 * Created by baota on 2018/1/7.
 */
public class SlowFly implements Flyable {
    @Override
    public void fly(){
        System.err.println("slow fly");


    }
}
