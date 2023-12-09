package com.expam.kafkaproducerdemo.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class KafkaMessagePublisherService {

    private static final Logger log = LogManager.getLogger(KafkaMessagePublisherService.class);
    @Autowired
    private KafkaTemplate<String, Object> template;

    public void sendMessageToTopic(String message) {
        // send the data to first topic
        // this topic is created by using cmd

        for (int i = 0; i < 10000; i++) {
            CompletableFuture<SendResult<String, Object>> future = template.send("MySecondKafkaTopic", message + " " + i);
            future.whenComplete((result, exception) -> {
                if (exception == null) {
                    log.info("Sent message =[{}] with offset =[{}]", message, result.getRecordMetadata().offset());
                } else {
                    log.info("Unable to sent message =[{}] due to {} ", message, exception.getMessage());
                }
            });
        }


        // send the data to second topic as well
        // this topic is created by using the java [KafkaProducerConfig.java]
        /*CompletableFuture<SendResult<String, Object>> future2 = template.send("MySecondKafkaTopic", message);
        future2.whenComplete((result, exception) -> {
            if (exception == null) {
                log.info("Sent message =[{}] with offset =[{}]", message, result.getRecordMetadata().offset());
            } else {
                log.info("Unable to sent message =[{}] due to {} ", message, exception.getMessage());
            }
        });*/
    }

}
