package com.example.service.proxy.core;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by baota on 2018/1/12.
 */
public class DynamicProxy implements InvocationHandler{

    //　这个就是我们要代理的真实对象
    private Object subject;

    //    构造方法，给我们要代理的真实对象赋初值
    public DynamicProxy(Object subject){
        this.subject = subject;
    }

   /* proxy:　　指代我们所代理的那个真实对象
    method:　　指代的是我们所要调用真实对象的某个方法的Method对象
    args:　　指代的是调用真实对象某个方法时接受的参数*/

    @Override
    public Object invoke(Object object, Method method, Object [] args) throws Throwable {

        System.err.println("before");
        System.err.println("Method:"+method);

        //    当代理对象调用真实对象的方法时，其会自动的跳转到代理对象关联的handler对象的invoke方法来进行调用
        Object result = method.invoke(subject, args);
        System.err.println("end");

        return result;
    }




}
