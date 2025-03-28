package com.example.adi.inventory.controller;

import com.example.adi.inventory.model.InventoryRequest;
import com.example.adi.inventory.model.InventoryResponse;
import com.example.adi.inventory.service.InventoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/inventory")
public class InventoryController {
    private final InventoryService service;

    public InventoryController(InventoryService service) {
        this.service = service;
    }

    @PostMapping(value = "/add")
    public ResponseEntity<InventoryResponse> addInventoryItem(@RequestBody InventoryRequest request){
        return new ResponseEntity<>(service.addInventoryItem(request), HttpStatus.OK);
    }

    @PutMapping(value = "/update")
    public ResponseEntity<InventoryResponse> updateInventoryItem(@RequestBody InventoryRequest request){
        return new ResponseEntity<>(service.updateInventoryItem(request), HttpStatus.OK);
    }
}
