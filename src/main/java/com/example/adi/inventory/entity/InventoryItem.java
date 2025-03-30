package com.example.adi.inventory.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class InventoryItem {
    @Id
    @Column(unique = true)
    private String itemId;

    @Column(unique = true)
    private String code;

    private String name;
    private Integer availableResources;
    private Double amount;
}
