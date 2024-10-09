package com.example.ordermanagement.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    @KafkaListener(topics = "ORDER_CREATED", groupId = "your-group-id")
    public void listen(String message) {
        System.out.println("Received message: " + message);
    }
}
