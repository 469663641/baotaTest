package com.example.service.proxy.core;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by baota on 2018/1/11.
 */
public class PersonHandler implements InvocationHandler{
    private Object object;

    public PersonHandler(Object object){
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object [] args) throws Throwable{

        System.err.println("before invoke");

        Object result = method.invoke(object, args);

        System.err.println("after");

        return result;
    }
}
