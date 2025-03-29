package com.example.adi.inventory.service;

import com.example.adi.inventory.model.InventoryRequest;

public interface InventoryKafkaProducerService {
    void publish(InventoryRequest inventoryRequest);
}
