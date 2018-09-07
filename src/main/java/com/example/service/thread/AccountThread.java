package com.example.service.thread;

/**
 * Created by duguangquan on 2018/8/29.
 */
public class AccountThread implements Runnable{

    private String account;

    public void setAccount(String account) {
        this.account = account;
    }

    @Override
    public void run() {

        LoginUtils.setAccount(account);
        System.err.println(LoginUtils.getAccount());

        String name = Thread.currentThread().getName();
        System.err.println(account +"#"+name);

    }
}
