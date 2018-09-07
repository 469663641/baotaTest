package com.example.service.annotation;

import com.example.constant.LoginType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by duguangquan on 2018/8/28.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface LoginApiInject {

    String url() default "";

    String method() default "GET";

    LoginType type() default LoginType.NEEDLOGIN;

}
