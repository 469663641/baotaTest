package com.example.service;

import com.example.service.proxy.api.PersonDao;
import com.example.service.proxy.core.PersonDaoImpl;
import com.example.service.proxy.core.PersonHandler;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.lang.reflect.Proxy;

/**
 * Created by baota on 2018/1/11.
 */
public class ProxyTest {

    public static void main(String[] args) {
            PersonDao personDao = new PersonDaoImpl();
            PersonHandler personHandler = new PersonHandler(personDao);

            PersonDao proxy = (PersonDao)Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), personDao.getClass().getInterfaces(), personHandler);

            proxy.say();
    }




}
