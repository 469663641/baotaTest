package com.example.service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

/**
 * Created by duguangquan on 2018/8/5.
 */
public class ClientTest {

    public static  <T> T updateWithCache(Supplier<T> supplier){


        T data = supplier.get();

        return data;
    }


    public static String generateStr(){

        return "222";
    }

    public static <T> void printList2(List<T> list) {
        for (T elem : list)
            System.out.println(elem + " ");
        System.out.println();
    }

    //public <T>  List<T> list = new ArrayList<T>();


    public <T> List<T>  batchTest(Supplier<T> supplier){

        ArrayList<T> list = new ArrayList<>();
        T data = supplier.get();
        list.add(data);

        return list;
    }




    public static void main(String[] args) {

        String s = updateWithCache(
                () -> generateStr()
        );
        System.err.println(s);
    }




}
