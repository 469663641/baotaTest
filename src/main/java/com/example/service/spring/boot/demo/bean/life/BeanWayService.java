package com.example.service.spring.boot.demo.bean.life;

/**
 * Created by baota on 2018/4/5.
 */
public class BeanWayService {

    public BeanWayService() {
        super();
        System.err.println("bean construct");
    }

    public void init(){
        System.err.println("bean init");

    }

    public void destroy(){
        System.err.println("bean destroy");
    }
}
