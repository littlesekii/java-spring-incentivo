package com.littlesekii.incentivo.modules.order.controller;

import com.littlesekii.incentivo.modules.order.entity.Order;
import com.littlesekii.incentivo.modules.order.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    final
    OrderService service;

    public OrderController(OrderService service) {
        this.service = service;
    }

    @GetMapping("")
    public ResponseEntity<List<Order>> findAll() {
        var res = service.findAll();
        return ResponseEntity.ok().body(res);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> findById(@PathVariable Long id) {
        var res = service.findById(id);
        return ResponseEntity.ok().body(res);
    }
}
