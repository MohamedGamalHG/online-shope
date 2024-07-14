package com.onlineshop.inventory_serivce.repository;

import com.onlineshop.inventory_serivce.entity.jpa.JpaInventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InventoryRepository extends JpaRepository<JpaInventory,Long> {
    Optional<JpaInventory> findBySkuCode(String skuCode);
}
