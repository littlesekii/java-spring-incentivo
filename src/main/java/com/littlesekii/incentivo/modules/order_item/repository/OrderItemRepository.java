package com.littlesekii.incentivo.modules.order_item.repository;

import com.littlesekii.incentivo.modules.order_item.entity.OrderItem;
import com.littlesekii.incentivo.modules.order_item.entity.id.OrderItemID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemID> {
}
