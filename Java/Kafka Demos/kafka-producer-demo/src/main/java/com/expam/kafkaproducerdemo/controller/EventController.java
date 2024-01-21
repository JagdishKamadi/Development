package com.expam.kafkaproducerdemo.controller;

import com.expam.kafkaproducerdemo.service.KafkaMessagePublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/producer-app")
public class EventController {

    @Autowired
    private KafkaMessagePublisherService publisherService;

    @GetMapping("/publish/{message}")
    public ResponseEntity<String> publishMessage(@PathVariable String message) {
        try {
            publisherService.sendMessageToTopic(message);
            return new ResponseEntity<>("Message send successfully", HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
