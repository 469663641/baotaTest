package com.example.service;

import com.example.BaotaApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

/**
 * Created by baota on 2018/1/30.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = BaotaApplication.class)
public class RedisTest {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void test(){
        redisTemplate.opsForValue().set("5555", "555",10, TimeUnit.DAYS);
        String result = (String) redisTemplate.opsForValue().get("555");
        System.out.println(result);
    }
}
