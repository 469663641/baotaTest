package com.example.kafka.basic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

/**
 * Created by baota on 2018/2/8.
 */
@Component
public class BasicProducer {
    @Autowired
    @Qualifier("basicKafkaTemplate")
    private KafkaTemplate<String, Basic> kafkaTemplate;

    public void send(String topic, Basic basic){
        kafkaTemplate.send(topic, basic);
    }
}
