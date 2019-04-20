package com.example.utils;

/**
 * Created by duguangquan on 2018/9/2.
 */
public class CacheKeyUtils {
    public  static String buildKey(String prefix, Object... objects){

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(prefix);
        if (objects != null){
            for (Object object : objects){
                if (object != null){

                    stringBuilder.append("#").append(object);
                }
            }
        }


        return stringBuilder.toString();
    }


    public static void main(String[] args) {
        buildKey(null,null);
        String s = buildKey("ALL_KEYS", "skin", 3);
        System.err.println(s);

    }

}
