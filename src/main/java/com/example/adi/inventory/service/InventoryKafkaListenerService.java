package com.example.adi.inventory.service;

import com.example.adi.inventory.model.BidOffer;

public interface InventoryKafkaListenerService {
    public void consumeMessage(BidOffer bidOffer);
}
