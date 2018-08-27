package com.example.service.java.promote;

import com.example.service.extend.Person;

import java.util.HashMap;


/**
 * Created by duguangquan on 2018/8/25.
 */
public class HashMapTest{

    public static void main(String[] args) {

        new Person("11");
        String str = "all_skin";
        String str2 = "all_subject";

        int hashCode = str.hashCode();
        int hashCode2 = str2.hashCode();


        HashMap<String, Object> map = new HashMap<>();
        map.put(str, 1);
        map.put(str2, 2);

        System.err.println("hhh");


    }
}
