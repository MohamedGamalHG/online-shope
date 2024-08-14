package com.onlineshop.order_service.service;

import com.onlineshop.order_service.entity.dto.InventoryResponse;
import com.onlineshop.order_service.entity.dto.OrderRequest;
import com.onlineshop.order_service.entity.jpa.JpaOrder;
import com.onlineshop.order_service.entity.jpa.JpaOrderLineItem;
import com.onlineshop.order_service.mapping.OrderLineItemMap;
import com.onlineshop.order_service.repository.OrderLineItemRepository;
import com.onlineshop.order_service.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderService {

    private final OrderLineItemMap orderMap;
    private final OrderRepository orderRepository;
    private final OrderLineItemRepository orderLineItemRepository;
    private final WebClient.Builder client;

    public void placeOrder(OrderRequest orderRequest) {
        JpaOrder order = new JpaOrder();
        order.setOrderNumber(UUID.randomUUID().toString());
        List<JpaOrderLineItem> orderLineItems = orderRequest.getOrderLineItems()
                .stream()
                .map(orderLineItem -> orderMap.convertTo(orderLineItem)).toList();
        order.setOrderLineItems(orderLineItems);

        List<String> skuCodes = orderRequest.getOrderLineItems().stream()
                .map(orderLineItem -> orderLineItem.getSkuCode()).toList();

        InventoryResponse[] inventoryResponses = client.build().get()
//                .uri("http://localhost:8082/api/inventory",uriBuilder -> uriBuilder.queryParam("skuCode",skuCodes).build())
                .uri("http://inventory-service/api/inventory",uriBuilder -> uriBuilder.queryParam("skuCode",skuCodes).build())
                .retrieve()
                .bodyToMono(InventoryResponse[].class)
                .block();

        boolean allProductInStock = Arrays.stream(inventoryResponses).allMatch(inventoryResponse -> inventoryResponse.isInStock());
        if(allProductInStock)
            orderRepository.save(order);
        else
            throw new IllegalArgumentException("Product Is Not In Stock");


    }
}
