package com.example.service.aop.demo;

import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by baota on 2018/1/14.
 */
@Aspect
@Component
public class SecurityAspect {

    @Autowired
    private AuthService authService;


    /**
     * 拦截带有@annotation(AdminOnly)注解的方法
     */
    //@Pointcut("@annotation(AdminOnly)")
    public void adminOnly(){

    }

    //@Around("adminOnly()")
    @Around("@annotation(adminOnly)")
    public void checkAccess(AdminOnly adminOnly){
        String role = adminOnly.role();
        System.err.println(role);
        authService.checkAccess();

    }

}
