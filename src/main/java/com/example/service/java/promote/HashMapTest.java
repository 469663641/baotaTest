package com.example.service.java.promote;

import com.example.service.extend.Person;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;


/**
 * Created by duguangquan on 2018/8/25.
 */
public class HashMapTest{



    public static void containKeyTest(){

        Map<Integer, Integer> map  = new HashMap<>();

        map.put(1,1);
        map.put(2,2);

        if (map.containsKey(1)){

        }

        map.entrySet().stream().map(entry -> {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            return value;
        }).collect(Collectors.toList());
    }

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
