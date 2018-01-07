package com.example.service.strategyModelExample.core;

import com.example.service.strategyModelExample.api.Quackable;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
