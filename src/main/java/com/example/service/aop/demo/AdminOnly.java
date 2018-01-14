package com.example.service.aop.demo;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by baota on 2018/1/14.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)//方法注解
public @interface AdminOnly {
}
