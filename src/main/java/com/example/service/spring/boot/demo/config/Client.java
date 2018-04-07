package com.example.service.spring.boot.demo.config;

import com.example.config.JavaConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by baota on 2018/4/5.
 */
public class Client {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                //new AnnotationConfigApplicationContext(DiConfig.class);
                new AnnotationConfigApplicationContext(JavaConfig.class);
        //UseFunctionService useFunctionService = context.getBean(UseFunctionService.class);
        //String str = useFunctionService.sayHello();
        FunctionService functionService = context.getBean(FunctionService.class);
        String str = functionService.sayHello();
        System.err.println(str);
    }
}
