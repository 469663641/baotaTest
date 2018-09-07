package com.example.service.thread;

/**
 * Created by duguangquan on 2018/8/29.
 */
public class LoginUtils {

    private static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static String getAccount(){
        return threadLocal.get();
    }

    public static void setAccount(String account){

        threadLocal.set(account);
    }


}
