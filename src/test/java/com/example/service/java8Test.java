package com.example.service;

import com.example.BaotaApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * Created by baota on 2018/4/2.
 */
//@RunWith(SpringRunner.class)
//@SpringBootTest
//@ContextConfiguration(classes = BaotaApplication.class)
public class java8Test {

    @Test
    public void comparatorTest(){

        List<Integer> integers = Arrays.asList(7, 10, 1, 8, 2);

        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return a < b ? -1 : (a > b) ? 1 : 0;
            }
        };
        /*Comparator<Integer> com = (Integer a, Integer b) -> b.compareTo(a);
        Collections.sort(integers, com);*/
        //等价于下面这个
        Collections.sort(integers, (Integer a, Integer b) -> b.compareTo(a));
        //Collections.sort(integers, comparator.reversed());
        System.err.println(integers);
    }

    @Test
    public void functionTest(){

        List<Integer> integers = Arrays.asList(7, 10, 1, 8, 2);
        List<Integer> result = forEach(integers, (Integer integer) -> integer + 100);
        System.err.println(result);
    }

    public List<Integer> forEach(List<Integer> integerList, Function<Integer, Integer> function){

        ArrayList<Integer> result = new ArrayList<>();
        for (Integer integer : integerList){

            result.add(function.apply(integer));
        }
        return result;
    }
}
