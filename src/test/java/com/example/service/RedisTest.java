package com.example.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;
import redis.clients.jedis.JedisPool;

/**
 * Created by baota on 2018/1/30.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RedisTest {

    @Autowired
    private TestRestTemplate restTemplate;

    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void test(){
        JedisPool jedisPool = new JedisPool();

        restTemplate.put("test", "1");
    }
}
