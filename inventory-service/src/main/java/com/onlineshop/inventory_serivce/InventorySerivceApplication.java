package com.onlineshop.inventory_serivce;

import com.onlineshop.inventory_serivce.entity.jpa.JpaInventory;
import com.onlineshop.inventory_serivce.repository.InventoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InventorySerivceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventorySerivceApplication.class, args);
	}

	@Bean
	public CommandLineRunner loadData(InventoryRepository inventoryRepository)
	{
		return args -> {
			JpaInventory inventory = new JpaInventory();
			inventory.setSkuCode("Iphone_13");
			inventory.setQuantity(12);

			JpaInventory inventory1 = new JpaInventory();
			inventory1.setSkuCode("Iphone_14");
			inventory1.setQuantity(15);

			inventoryRepository.save(inventory);
			inventoryRepository.save(inventory1);
		};
	}
}
