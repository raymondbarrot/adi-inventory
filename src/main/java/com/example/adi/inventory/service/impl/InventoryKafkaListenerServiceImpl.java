package com.example.adi.inventory.service.impl;

import com.example.adi.inventory.model.BidOffer;
import com.example.adi.inventory.service.InventoryKafkaListenerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class InventoryKafkaListenerServiceImpl implements InventoryKafkaListenerService {
    @Override
    @KafkaListener(topics = "${kafka.topic.inventory}", groupId = "inventory-group")
    public void consumeMessage(BidOffer bidOffer) {
        log.info("Consumed: {}", bidOffer);
    }
}
