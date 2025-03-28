package com.example.adi.inventory.service.impl;

import com.example.adi.inventory.entity.InventoryItem;
import com.example.adi.inventory.model.InventoryRequest;
import com.example.adi.inventory.model.InventoryResponse;
import com.example.adi.inventory.repository.InventoryRepository;
import com.example.adi.inventory.service.InventoryService;
import com.example.adi.inventory.util.ObjectCreationUtil;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class InventoryServiceImpl implements InventoryService {
    private final InventoryRepository repository;
    private final KafkaTemplate<String, InventoryRequest> kafkaTemplate;

    public InventoryServiceImpl(InventoryRepository repository, KafkaTemplate<String, InventoryRequest> kafkaTemplate) {
        this.repository = repository;
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public InventoryResponse addInventoryItem(InventoryRequest request) {
        InventoryItem item = ObjectCreationUtil.getInstance().createInventoryItem(request);
        repository.save(item);
        return InventoryResponse.builder()
                .status("Success")
                .reason("Inventory item successfully added.")
                .build();
    }

    @Override
    public InventoryResponse updateInventoryItem(InventoryRequest request) {
        repository.updateInventoryItem(request.getName(), request.getAvailableResources(),
                request.getAmount(), request.getCode());
        return InventoryResponse.builder()
                .status("Success")
                .reason("Inventory item successfully updated.")
                .build();
    }

    private void publishMessage(InventoryRequest request){
        ProducerRecord<String, InventoryRequest> record =
                new ProducerRecord<>("kafka_topic", request);
        kafkaTemplate.send(record);
    }
}
