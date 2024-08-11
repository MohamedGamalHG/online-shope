package com.onlineshop.inventory_serivce.service;

import com.onlineshop.inventory_serivce.entity.jpa.dto.InventoryResponse;
import com.onlineshop.inventory_serivce.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    @Transactional(readOnly = true)
    public List<InventoryResponse> isInStock(List<String> skuCode)
    {
//        return inventoryRepository.findBySkuCode(skuCode).isPresent();
        return inventoryRepository.findBySkuCodeIn(skuCode).stream()
                .map(inventory -> new InventoryResponse(inventory.getSkuCode(),inventory.getQuantity() > 0) )
                .toList();
    }
}
