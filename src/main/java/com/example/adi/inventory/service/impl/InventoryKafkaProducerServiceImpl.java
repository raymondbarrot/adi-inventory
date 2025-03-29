package com.example.adi.inventory.service.impl;

import com.example.adi.inventory.config.ConstantsConfig;
import com.example.adi.inventory.model.InventoryRequest;
import com.example.adi.inventory.service.InventoryKafkaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;

public class InventoryKafkaProducerServiceImpl implements InventoryKafkaProducerService {
    @Autowired
    private KafkaTemplate<String, InventoryRequest> kafkaTemplate;
    @Override
    public void publish(InventoryRequest inventoryRequest) {
        this.kafkaTemplate.send(ConstantsConfig.RECOMMENDATION_TOPIC, inventoryRequest);
    }
}
