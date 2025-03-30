package com.example.adi.inventory.service.impl;

import com.example.adi.inventory.entity.InventoryItem;
import com.example.adi.inventory.model.InventoryRequest;
import com.example.adi.inventory.model.InventoryResponse;
import com.example.adi.inventory.repository.InventoryRepository;
import com.example.adi.inventory.service.InventoryService;
import com.example.adi.inventory.util.ObjectCreationUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class InventoryServiceImpl implements InventoryService {
    private final InventoryRepository repository;
    private final InventoryKafkaProducerServiceImpl inventoryKafkaProducerService;

    public InventoryServiceImpl(InventoryRepository repository, InventoryKafkaProducerServiceImpl inventoryKafkaProducerService) {
        this.repository = repository;
        this.inventoryKafkaProducerService = inventoryKafkaProducerService;
    }

    @Override
    public InventoryResponse addInventoryItem(InventoryRequest request) {
        InventoryItem item = ObjectCreationUtil.getInstance().createInventoryItem(request);
        repository.save(item);
        publishMessage(request);
        return InventoryResponse.builder()
                .status("Success")
                .reason("Inventory item successfully added.")
                .build();
    }

    @Override
    public InventoryResponse updateInventoryItem(InventoryRequest request) {
        repository.updateInventoryItem(request.getName(), request.getAvailableResources(),
                request.getAmount(), request.getCode());
        publishMessage(request);
        return InventoryResponse.builder()
                .status("Success")
                .reason("Inventory item successfully updated.")
                .build();
    }

    private void publishMessage(InventoryRequest request){
        this.inventoryKafkaProducerService.publish(request);
    }
}
