package com.example.service.cjlib.demo;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by baota on 2018/1/22.
 */
public class CjlibObject implements MethodInterceptor{
    @Override
    public Object intercept(Object target, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {

        System.err.println("前置 before");
        Object result = null;
        try {

            result = methodProxy.invokeSuper(target, args);
        } catch (Exception e) {
            System.err.println("异常通知 afterThrowing");
        } finally {
            System.err.println("后置通知 after");
        }

        return result;
    }
}
