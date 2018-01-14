package com.example.config;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Created by baota on 2018/1/14.
 */
@Component
@Aspect
public class AopConfig {
    /**
     * 拦截com.example.service.aop.demo.ProductService下的所有方法
     */
    //@Pointcut("within(com.example.service.aop.demo.ProductService)")//拦截com.example.service.aop.demo.ProductService下的所有方法
    //@Pointcut("bean(productService)")//拦截productService bean下的所有方法
    //@Pointcut("this(com.example.service.aop.demo.Logable)")//拦截实现Logable的方法
    //@Pointcut("args(Long,String,..) && within(com.example.service.aop.demo.ProductService)")//匹配第一个参数和service
    //@Pointcut("@annotation(AdminOnly)") //拦截带有AdminOnly注解的方法

    @Pointcut("execution(public * com.example.service.aop.demo.*Service.*(..))") //拦截返回值任意 以Service结尾的任意方法（任意参数）
    public void matchService(){

    }

    @Before("matchService()")
    public void before(){

        System.err.println("----before");




    }
}
