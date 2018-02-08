package com.example.kafka.basic;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * Created by baota on 2018/2/8.
 */
@Component
public class BasicConsumer {

    @KafkaListener(topics = "${kafka.topic.basictopic}", containerFactory = "basicKafkaListenerContainerFactory")
    public void receive(Basic basic){
        System.err.println(basic.toString());


    }
}
