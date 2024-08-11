package com.onlineshop.inventory_serivce.controller;

import com.onlineshop.inventory_serivce.entity.jpa.dto.InventoryResponse;
import com.onlineshop.inventory_serivce.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryService inventoryService;

    /*
     * is method take skuCode and verify this skuCode related to product in stock or not
     */
//    @GetMapping("/{sku-code}")
    @GetMapping
    public List<InventoryResponse> isInStock(@RequestParam List<String> skuCode)
    {
        return inventoryService.isInStock(skuCode);
    }
}
