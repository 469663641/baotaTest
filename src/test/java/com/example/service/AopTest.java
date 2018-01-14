package com.example.service;

import com.example.service.aop.demo.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by baota on 2018/1/14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class AopTest {
    @Autowired
    private ProductService productService;

    @Test
    public void aopTest(){

        productService.insert();




    }
}
