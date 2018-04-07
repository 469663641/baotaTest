package com.example.service.spring.boot.demo.bean.life;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by baota on 2018/4/5.
 */
public class Client {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(PrePostConfig.class);

        BeanWayService beanWayService = context.getBean(BeanWayService.class);
        AnnotationBeanWayService annotationBeanWayService = context.getBean(AnnotationBeanWayService.class);

        context.close();

    }
}
