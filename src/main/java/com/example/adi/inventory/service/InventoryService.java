package com.example.adi.inventory.service;

import com.example.adi.inventory.model.InventoryRequest;
import com.example.adi.inventory.model.InventoryResponse;

public interface InventoryService {
    public InventoryResponse addInventoryItem(InventoryRequest request);
    public InventoryResponse updateInventoryItem(InventoryRequest request);
}
