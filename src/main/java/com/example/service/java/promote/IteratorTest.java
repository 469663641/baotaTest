package com.example.service.java.promote;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Created by duguangquan on 2018/9/9.
 */
public class IteratorTest {

    public static void iterate(){

        List<String> list = Arrays.asList("1", "2");

        Iterator<String> iterator = list.iterator();


        while (iterator.hasNext()){
            String element = iterator.next();
            System.err.println(element);
        }
    }

    public static void main(String[] args) {

        iterate();
    }


}
