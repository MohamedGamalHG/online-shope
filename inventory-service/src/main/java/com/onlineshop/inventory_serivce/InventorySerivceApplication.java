package com.onlineshop.inventory_serivce;

import com.onlineshop.inventory_serivce.entity.jpa.JpaInventory;
import com.onlineshop.inventory_serivce.repository.InventoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class InventorySerivceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventorySerivceApplication.class, args);
	}

}
