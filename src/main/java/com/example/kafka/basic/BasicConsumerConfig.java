package com.example.kafka.basic;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by baota on 2018/2/8.
 */
@Configuration
public class BasicConsumerConfig {
    @Value("${kafka.bootstrap-servers}")
    private String bootstrapServers;
    @Value("${kafka.topic.basictopic}")
    private String topic;

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, Basic> basicKafkaListenerContainerFactory(){
        Map<String, Object> configProps = new HashMap<>();
        configProps.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        configProps.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_DOC, StringDeserializer.class);
        configProps.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        configProps.put(ConsumerConfig.GROUP_ID_CONFIG, topic);


        ConcurrentKafkaListenerContainerFactory<String, Basic> factory =
                new ConcurrentKafkaListenerContainerFactory<>();

        ConsumerFactory<String, Basic> basicConsumerFactory =
                new DefaultKafkaConsumerFactory<String, Basic>(configProps,
                        new StringDeserializer(),
                        new JsonDeserializer<>(Basic.class));
        factory.setConsumerFactory(basicConsumerFactory);
        return factory;


    }
}
