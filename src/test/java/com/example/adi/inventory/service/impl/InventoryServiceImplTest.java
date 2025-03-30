package com.example.adi.inventory.service.impl;

import com.example.adi.inventory.entity.InventoryItem;
import com.example.adi.inventory.model.InventoryRequest;
import com.example.adi.inventory.repository.InventoryRepository;
import com.example.adi.inventory.util.ObjectCreationUtil;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class InventoryServiceImplTest {
    @InjectMocks
    private InventoryServiceImpl inventoryService;
    @Mock
    private InventoryRepository repository;
    @Mock
    private InventoryKafkaProducerServiceImpl inventoryKafkaProducerService;

    @Before
    public void setup() {
        MockitoAnnotations.openMocks(this);
        inventoryService = new InventoryServiceImpl(repository, inventoryKafkaProducerService);
    }

    @Test
    public void test_addInventoryItem(){
        when(repository.save(any())).thenReturn(new InventoryItem());
        inventoryService.addInventoryItem(createInventoryRequest());
        verify(repository, times(1)).save(any());
    }

    @Test
    public void test_updateInventoryItem(){
        doNothing().when(repository).updateInventoryItem(anyString(), anyInt(), anyDouble(), anyString());
        inventoryService.updateInventoryItem(createInventoryRequest());
        verify(repository, times(1)).updateInventoryItem(anyString(), anyInt(), anyDouble(), anyString());
    }

    private InventoryRequest createInventoryRequest(){
        return InventoryRequest.builder()
                .name("sample")
                .amount(10.0)
                .availableResources(100)
                .code("sample-code")
                .build();
    }

}