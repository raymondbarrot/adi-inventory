package com.example.adi.inventory.service.impl;

import com.example.adi.inventory.model.BidOffer;
import com.example.adi.inventory.service.InventoryKafkaListenerService;
import org.springframework.kafka.annotation.KafkaListener;

public class InventoryKafkaListenerServiceImpl implements InventoryKafkaListenerService {
    @Override
    @KafkaListener(topics = "${kafka.topic.recommendation}", groupId = "recommendation-group")
    public void consumeMessage(BidOffer bidOffer) {

    }
}
