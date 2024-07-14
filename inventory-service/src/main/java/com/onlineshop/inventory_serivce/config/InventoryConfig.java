package com.onlineshop.inventory_serivce.config;

import com.onlineshop.inventory_serivce.entity.jpa.JpaInventory;
import com.onlineshop.inventory_serivce.repository.InventoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InventoryConfig {

    @Bean
    public CommandLineRunner loadData(InventoryRepository inventoryRepository)
    {
        return args -> {
            JpaInventory inventory = new JpaInventory();
            inventory.setSkuCode("Iphone_13");
            inventory.setQuantity(100);

            JpaInventory inventory1 = new JpaInventory();
            inventory1.setSkuCode("Iphone_13_red");
            inventory1.setQuantity(10);

            inventoryRepository.save(inventory);
            inventoryRepository.save(inventory1);
        };
    }
}
