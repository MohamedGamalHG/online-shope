package com.onlineshop.inventory_serivce.entity.jpa.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class InventoryResponse {
    private String skuCode;
    private boolean isInStock;
}
