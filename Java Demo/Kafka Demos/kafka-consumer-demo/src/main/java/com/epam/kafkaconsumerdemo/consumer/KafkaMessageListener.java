package com.epam.kafkaconsumerdemo.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaMessageListener {


    // make sure to give the topic and group id to the consumer
    // check the datatype in producer application
    @KafkaListener(topics = "MySecondKafkaTopic", groupId = "GroupId-1")
    public void consume1(String message) {
        log.info("Consuming the message from consumer1 : {} ", message);
    }

    // if your producer producing the large message
    // then you have to increase the consumer
    // also we are adding the one extra consumer to make sure that re-balancing  happens
    @KafkaListener(topics = "MySecondKafkaTopic", groupId = "GroupId-1")
    public void consume2(String message) {
        log.info("Consuming the message from consumer2 : {} ", message);
    }

    @KafkaListener(topics = "MySecondKafkaTopic", groupId = "GroupId-1")
    public void consume3(String message) {
        log.info("Consuming the message from consumer3 : {} ", message);
    }

    @KafkaListener(topics = "MySecondKafkaTopic", groupId = "GroupId-1")
    public void consume4(String message) {
        log.info("Consuming the message from consumer4 : {} ", message);
    }

}
