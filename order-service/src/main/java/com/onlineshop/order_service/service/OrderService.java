package com.onlineshop.order_service.service;

import com.onlineshop.order_service.entity.dto.OrderLineItem;
import com.onlineshop.order_service.entity.dto.OrderRequest;
import com.onlineshop.order_service.entity.jpa.JpaOrder;
import com.onlineshop.order_service.entity.jpa.JpaOrderLineItem;
import com.onlineshop.order_service.mapping.OrderLineItemMap;
import com.onlineshop.order_service.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderService {

    private final OrderLineItemMap orderMap;
    private final OrderRepository orderRepository;
    public void placeOrder(OrderRequest orderRequest)
    {
        JpaOrder order = new JpaOrder();
        order.setOrderNumber(UUID.randomUUID().toString());
        List<JpaOrderLineItem> orderLineItems = orderRequest.getOrderLineItems()
                .stream()
                .map(orderLineItem -> orderMap.convertTo(orderLineItem)).toList();
        order.setOrderLineItems(orderLineItems);
        orderRepository.save(order);

    }
}
