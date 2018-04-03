package com.example.service.lambda.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by baota on 2018/4/2.
 */
public class Client {
    public static void main(String[] args) {

        List<Apple> appleList = Arrays.asList(new Apple(80, "red")
                , new Apple(130, "green"));

        //比较器复合
        Comparator<Apple> comparator = Comparator.comparing(Apple::getWeight);
        appleList.sort(comparator.reversed().thenComparing(Apple :: getColor));
        System.err.println(appleList);

        //匿名函数，同时声明并实例化一个类，随用随建
        List<Apple> result = filterApples(appleList, new ApplePredicate() {
            @Override
            public boolean test(Apple apple) {
                return "red".equals(apple.getColor());
            }
        });

        //等价于上面的写法
        List<Apple> apples = filterApples(appleList, (apple -> "red".equals(apple.getColor())));

        //lambda函数接口，相当于覆写接口的方法，接收参数 -> 返回结果
        //谓词复合
        Predicate<Apple> redApplePredicate = (Apple apple) -> "red".equals(apple.getColor());
        Predicate<Apple> negateRedPredicate = redApplePredicate.negate();
        List<Apple> result3 = filter(appleList, negateRedPredicate.and(apple -> apple.getWeight() > 100));
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

    private static List<Apple> filter(List<Apple> appleList, Predicate<Apple> p) {
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
