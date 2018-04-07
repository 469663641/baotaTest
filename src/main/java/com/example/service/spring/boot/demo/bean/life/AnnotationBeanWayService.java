package com.example.service.spring.boot.demo.bean.life;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Created by baota on 2018/4/5.
 */
public class AnnotationBeanWayService {

    public AnnotationBeanWayService() {
        super();
        System.err.println("annotation construct");
    }

    @PostConstruct
    public void init() {
        System.err.println("annotation init");
    }

    @PreDestroy
    public void destroy(){
        System.err.println("annotation destroy");

    }
}
