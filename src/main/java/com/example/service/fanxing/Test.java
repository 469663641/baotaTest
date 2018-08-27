package com.example.service.fanxing;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by duguangquan on 2018/8/6.
 */
public class Test<T> {


    public List<T> list = new ArrayList<T>();

    public static void main(String[] args) {
        Test<String> test = new Test<String>();
        test.list.add("hello");
        System.out.println(test.list);
    }


}
