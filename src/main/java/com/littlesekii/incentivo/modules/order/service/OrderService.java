package com.littlesekii.incentivo.modules.order.service;


import com.littlesekii.incentivo.modules.order.entity.Order;
import com.littlesekii.incentivo.modules.order.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class OrderService {

    private final OrderRepository repository;

    public OrderService(OrderRepository repository) {
        this.repository = repository;
    }

    public List<Order> findAll() {
        return repository.findAll();
    }

    public Order findById(Long id) {
        return repository.findById(id).get();
    }
}
