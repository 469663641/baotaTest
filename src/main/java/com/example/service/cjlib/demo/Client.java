package com.example.service.cjlib.demo;

import com.google.common.base.Stopwatch;
import com.mysql.cj.jdbc.util.TimeUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cglib.proxy.Enhancer;

import java.util.concurrent.TimeUnit;

/**
 * Created by baota on 2018/1/22.
 */
@Slf4j
public class Client {

    public static void main(String[] args) {

        Stopwatch stopwatch = Stopwatch.createStarted();

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

        log.info("dynamicProxy takes [{}] ms", stopwatch.elapsed(TimeUnit.MILLISECONDS));
    }
}
