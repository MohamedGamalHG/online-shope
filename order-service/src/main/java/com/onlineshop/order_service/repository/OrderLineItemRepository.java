package com.onlineshop.order_service.repository;

import com.onlineshop.order_service.entity.jpa.JpaOrderLineItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderLineItemRepository extends JpaRepository<JpaOrderLineItem,Long> {
}
