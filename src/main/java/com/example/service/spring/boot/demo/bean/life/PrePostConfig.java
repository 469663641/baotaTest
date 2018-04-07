package com.example.service.spring.boot.demo.bean.life;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by baota on 2018/4/5.
 */
@Configuration
public class PrePostConfig {

    @Bean(initMethod = "init",destroyMethod = "destroy")
    public BeanWayService beanWayService(){
        return new BeanWayService();
    }

    @Bean
    public AnnotationBeanWayService annotationBeanWayService(){
        return new AnnotationBeanWayService();
    }
}
