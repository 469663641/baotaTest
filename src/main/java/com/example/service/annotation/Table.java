package com.example.service.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by duguangquan on 2018/8/12.
 */
@Target({ElementType.TYPE})//作用域
@Retention(RetentionPolicy.RUNTIME)//生命周期
public @interface Table {
    String value();

}
