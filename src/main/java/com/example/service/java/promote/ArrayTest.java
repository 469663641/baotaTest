package com.example.service.java.promote;


import com.example.service.extend.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by duguangquan on 2018/9/2.
 */
public class ArrayTest {


    /**
     * Arrays工具类的坑
     * 1.public static <T> List<T> asList(T... a)，传入数组，那么长度会是1；
     * 注意这个参数:T...a，这个参数是一个泛型的变长参数，我们知道基本数据类型是不可能泛型化的，
     * 也是就说 8 个基本数据类型是不可作为泛型参数的，但是为什么编译器没有报错呢?这是因为在 Java 中，
     * 数组会当做一个 对象来处理，它是可以泛型的。
     *
     * 2.Arrays.asList()返回的list是arrays的一个内部类，并没有add（），所以不可以改变，并不是java.util.arrayList,
     * 所以综上所述，asList 返回的是一个长度不可变的列表。
     * 数组是多长，转换成的列表是多长，我们是无法通过 add、remove 来增加或者减少其长度的。
     *
     * 3.Arrays.toArray:转换为数组，实现了数组的浅拷贝。
     */
    public  static void arraysTest(){

        int[] datas = new int[]{1,2,3,4,5};
        List list = Arrays.asList(datas);
        System.out.println(list.size());


        List<String> strings = Arrays.asList("1", "2", "3");
        int a = 9;

        List<Integer> integers = Arrays.asList(a);
        System.err.println(integers);
        int size = strings.size();
        strings.set(1,"hh");

        strings.add("9");

    }

    /**
     * 浅拷贝
     */
    public static void lowCopyTest(){

        //List<String> oldList = Arrays.asList("1", "2", "3");
        List<Person> oldList = new ArrayList<>();
        oldList.add(new Person("1"));
        oldList.add(new Person("2"));
        List<Person> newList = new ArrayList<>();
        newList.addAll(oldList);
        newList.get(1).setName("baota");
        System.err.println(oldList);


    }

    public static void main(String[] args) {


        Person baota = new Person("baota");

        Person baota2 = baota;

        baota.setName("haha");
        System.err.println(baota2);



       // lowCopyTest();

        arraysTest();

        int[] array = new int[]{1,2,3,4};


        long time1 = System.currentTimeMillis();
        int[] intArr = new int[1000];
        for (int i=0; i<1000;i++){
            intArr[i]=i;
        }

        int sum =0;
       for (int i=0;i<1000;i++){
           sum =+ intArr[i];
       }

        long time2 = System.currentTimeMillis();
        System.err.println("求和时间：" + (time2 - time1));
    }
}
