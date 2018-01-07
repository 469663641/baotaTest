package com.example.service;

import com.example.service.strategyModelExample.api.Quackable;
import com.example.service.strategyModelExample.core.GentleDuck;
import com.example.service.strategyModelExample.core.GentleQuack;
import com.example.service.strategyModelExample.core.HarshQuack;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeansException;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

/**
 * Created by baota on 2018/1/7.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class StrategyTest implements ApplicationContextAware{

    //获取application上下文
    private ApplicationContext applicationContext;

    //获取application上下文
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }


    @Test
    public void modelTest(){

        GentleQuack gentleQuack = new GentleQuack();
        GentleDuck gentleDuck = new GentleDuck(gentleQuack);
        gentleDuck.quack();

        HarshQuack harshQuack = new HarshQuack();
        gentleDuck.setQuackable(harshQuack);
        gentleDuck.quack();
    }

    @Test
    public void strategyTest(){
        //面向接口，通过Type来判断用哪一个实例对象
        //Quackable quackable = getQuackBytype("gentleQuack");
        Quackable quackable = getBeanBytype("gentleQuack");
        quackable.quack();

    }

    private Quackable getQuackBytype(String type){


        Assert.notNull(type,"type must not been null");
        if ("gentleQuack".equals(type)) {
            return new GentleQuack();
        }else if ("harshQuack".equals(type)){
            return new HarshQuack();
        }
        return null;

    }

    private Quackable getBeanBytype(String type){
        if ("gentleQuack".equals(type)) {
            return applicationContext.getBean(GentleQuack.class);
        } else if ("harshQuack".equals(type)){
            return applicationContext.getBean(HarshQuack.class);
        }
        return null;
    }
}
