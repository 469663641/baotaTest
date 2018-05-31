package com.example.service;

import com.example.service.community.SkinPlanApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by duguangquan on 2018/5/31.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class CommunityTest {
    @Autowired
    private SkinPlanApplication skinPlanApplication;

    @Test
    public void queryTest(){

        skinPlanApplication.querySkinPlan();
    }

}
