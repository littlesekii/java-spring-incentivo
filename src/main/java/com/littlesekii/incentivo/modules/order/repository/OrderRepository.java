package com.littlesekii.incentivo.modules.order.repository;

import com.littlesekii.incentivo.modules.order.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}

