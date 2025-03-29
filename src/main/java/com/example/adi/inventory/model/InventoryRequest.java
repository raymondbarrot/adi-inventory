package com.example.adi.inventory.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class InventoryRequest {
    private String code;
    private String name;
    private Integer availableResources;
    private Double amount;
}
