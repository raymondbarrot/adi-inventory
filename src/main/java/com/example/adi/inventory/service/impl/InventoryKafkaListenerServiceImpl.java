package com.example.adi.inventory.service.impl;

import com.example.adi.inventory.constant.BidStatus;
import com.example.adi.inventory.entity.InventoryItem;
import com.example.adi.inventory.model.BidOffer;
import com.example.adi.inventory.repository.InventoryRepository;
import com.example.adi.inventory.service.InventoryKafkaListenerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class InventoryKafkaListenerServiceImpl implements InventoryKafkaListenerService {
    private final InventoryRepository repository;

    public InventoryKafkaListenerServiceImpl(InventoryRepository repository) {
        this.repository = repository;
    }

    @Override
    @KafkaListener(topics = "${kafka.topic.inventory}", groupId = "inventory-group")
    public void consumeMessage(BidOffer bidOffer) {
        log.info("Consumed: {}", bidOffer);
        if(bidOffer.getStatus().equals(BidStatus.ACCEPTED.name())){
            log.info("Here");
            InventoryItem item = repository.findByCode(bidOffer.getItemCode());
            if(item!=null) {
                log.info("Item {}", item);
                updateAvailableResources(
                        item.getAvailableResources() - bidOffer.getNumberOfResources(),
                        item.getCode());
            }
        }
    }

    private void updateAvailableResources(Integer availableResource, String code){
        repository.updateAvailableResources(availableResource, code);
    }
}
