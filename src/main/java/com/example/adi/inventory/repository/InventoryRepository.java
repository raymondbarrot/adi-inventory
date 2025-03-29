package com.example.adi.inventory.repository;

import com.example.adi.inventory.entity.InventoryItem;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends JpaRepository<InventoryItem, String> {
    @Modifying
    @Transactional
    @Query(value = "UPDATE inventory_item SET name=:name, available_resources=:availableResources, " +
            "amount=:amount WHERE code=:code", nativeQuery = true)
    void updateInventoryItem(@Param("name") String name,
                             @Param("availableResources") Integer availableResources,
                             @Param("amount") Double amount,
                             @Param("code") String code);

    InventoryItem findByCode(String code);

    @Modifying
    @Transactional
    @Query(value = "UPDATE inventory_item SET available_resources=:availableResources " +
            "WHERE code=:code", nativeQuery = true)
    void updateAvailableResources(@Param("availableResources") Integer availableResources,
                             @Param("code") String code);
}
