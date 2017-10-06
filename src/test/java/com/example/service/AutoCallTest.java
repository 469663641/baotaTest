package com.example.service;


import com.example.service.ivrCall.dao.po.AutoCall;
import com.example.service.ivrCall.dao.repository.AutoCallRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by baota on 2017/10/5.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AutoCallTest {
    @Autowired
    private AutoCallRepository autoCallRepository;

    @Test
    public void testAuto(){

        AutoCall autoCall= autoCallRepository.findByBusinessKey("123");

        System.err.println(autoCall);



    }
}
