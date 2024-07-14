package com.onlineshop.order_service.mapping;

import com.onlineshop.order_service.entity.dto.OrderLineItem;
import com.onlineshop.order_service.entity.dto.OrderRequest;
import com.onlineshop.order_service.entity.jpa.JpaOrder;
import com.onlineshop.order_service.entity.jpa.JpaOrderLineItem;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderLineItemMap {
    private final ModelMapper modelMapper;

    public OrderLineItem convertTo(JpaOrderLineItem order)
    {
        return modelMapper.map(order,OrderLineItem.class);
    }
    public JpaOrderLineItem convertTo(OrderLineItem order)
    {
        return modelMapper.map(order,JpaOrderLineItem.class);
    }
}
