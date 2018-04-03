package com.example.service;

import com.example.kafka.basic.Basic;
import com.example.kafka.basic.BasicProducer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

/**
 * Created by baota on 2018/2/8.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BasicProducerTest {
    /*@Value("${kafka.topic.basictopic}")
    private String topic;

    @Autowired
    private BasicProducer basicProducer;

    @Test
    public void sendMessage(){
        String messageId = UUID.randomUUID().toString();
        Basic basicMessage = new Basic(messageId, "baota");
        basicProducer.send(topic, basicMessage);
    }*/

}
