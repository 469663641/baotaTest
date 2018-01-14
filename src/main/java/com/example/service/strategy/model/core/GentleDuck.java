package com.example.service.strategy.model.core;

import com.example.service.strategy.model.api.Quackable;
import lombok.Data;

/**
 * Created by baota on 2018/1/7.
 */
@Data
public class GentleDuck {

    private Quackable quackable;

    public GentleDuck(Quackable quackable){
        this.quackable = quackable;
    }

    public void quack(){
        quackable.quack();

    }

}
