package com.onlineshop.order_service.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderLineItem {
    private Long id;
    private String skuCode;
    private BigDecimal price;
    private Integer quantity;
}
