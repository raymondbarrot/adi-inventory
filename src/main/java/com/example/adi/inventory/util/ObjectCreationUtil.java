package com.example.adi.inventory.util;

import com.example.adi.inventory.entity.InventoryItem;
import com.example.adi.inventory.model.InventoryRequest;

import java.util.UUID;

public class ObjectCreationUtil {
    private static ObjectCreationUtil instance;

    public static ObjectCreationUtil getInstance(){
        if(instance == null){
            instance = new ObjectCreationUtil();
        }
        return instance;
    }

    public InventoryItem createInventoryItem(InventoryRequest request){
        return InventoryItem.builder()
                .itemId(UUID.randomUUID().toString())
                .amount(request.getAmount())
                .code(request.getCode())
                .name(request.getName())
                .availableResources(request.getAvailableResources())
                .build();
    }
}
