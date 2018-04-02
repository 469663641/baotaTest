package com.example.service.lambda.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by baota on 2018/4/2.
 */
public class Client {
    public static void main(String[] args) {

        List<Apple> appleList = Arrays.asList(new Apple(80, "green")
                , new Apple(130, "red"));

        //匿名函数，同时声明并实例化一个类，随用随建
        List<Apple> result = filterApples(appleList, new ApplePredicate() {
            @Override
            public boolean test(Apple apple) {
                return "red".equals(apple.getColor());
            }
        });

        //lambda函数接口，相当于覆写接口的方法，接收参数 -> 返回结果
        List<Apple> result2 = filter(appleList, (Apple apple) -> "green".equals(apple.getColor()));

        //run执行的代码块
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.err.println("555");
            }
        };

        System.err.println(result2);
        System.err.println(result);
        r.run();
    }

    private static List<Apple> filter(List<Apple> appleList, ApplePredicate p) {
        ArrayList<Apple> result = new ArrayList<>();
        for (Apple apple : appleList) {
            if (p.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }


    public static List<Apple> filterApples(List<Apple> appleList, ApplePredicate applePredicate) {
        ArrayList<Apple> result = new ArrayList<>();

        for (Apple apple : appleList) {
            if (applePredicate.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }
}
