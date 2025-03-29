package com.example.adi.inventory.service.impl;

import com.example.adi.inventory.config.ConstantsConfig;
import com.example.adi.inventory.model.InventoryRequest;
import com.example.adi.inventory.service.InventoryKafkaProducerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class InventoryKafkaProducerServiceImpl implements InventoryKafkaProducerService {
    @Autowired
    private ConstantsConfig constantsConfig;
    @Autowired
    private KafkaTemplate<String, InventoryRequest> kafkaTemplate;
    @Override
    public void publish(InventoryRequest inventoryRequest) {
        log.info("Produced: {}", inventoryRequest);
        this.kafkaTemplate.send(constantsConfig.getRecommendationTopic(), inventoryRequest);
    }
}
