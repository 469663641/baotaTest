package com.example.service.cjlib.demo;

import org.springframework.cglib.proxy.Enhancer;

/**
 * Created by baota on 2018/1/22.
 */
public class Client {

    public static void main(String[] args) {
        //调用
        //创建动态生成代理对象(目标对象的子类)的类Enhancer
        Enhancer enhancer = new Enhancer();

        //设置目标对象(生成的代理类为其子类)
        enhancer.setSuperclass(TargetObject.class);

        //指定一个回调函数，这个函数就和Proxy的 invoke()类似
        enhancer.setCallback(new CjlibObject());

        //生成代理类,向上转型,实际上调用的时代理类(子类)的方法
        TargetObject dynamicProxy = (TargetObject) enhancer.create();

        dynamicProxy.method1("baota");
        dynamicProxy.method2("baota22");
    }
}
