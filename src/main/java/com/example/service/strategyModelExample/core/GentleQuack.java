package com.example.service.strategyModelExample.core;

import com.example.service.strategyModelExample.api.Quackable;
import org.springframework.stereotype.Component;

/**
 * Created by baota on 2018/1/7.
 */
@Component
public class GentleQuack implements Quackable{
    @Override
    public void quack(){

        System.err.println("gentle quack");

    }
}
