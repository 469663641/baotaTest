package com.example.service;


import com.example.service.ivrcall.dao.po.AutoCall;
import com.example.service.ivrcall.dao.repository.AutoCallRepository;
import org.apache.commons.lang3.time.DateUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by baota on 2017/10/5.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AutoCallTest {
    @Autowired
    private AutoCallRepository autoCallRepository;

    @Test
    public void testAuto(){

        AutoCall autoCall= autoCallRepository.findByBusinessKey("123");
        System.err.println(autoCall);
    }

    @Test
    public void queryTest(){

        Date date = DateUtils.truncate(new Date(), Calendar.DATE);
        List<AutoCall> autoCallList = autoCallRepository.findByCreatedTimeAfter(date);
        System.err.println(autoCallList);


    }

}
