package com.example.webservices.controller;

import com.example.webservices.domain.model.Order;
import com.example.webservices.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/orders")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }
    @GetMapping
    public ResponseEntity<List<Order>> findAll() {
        return ResponseEntity.ok().body(orderService.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Order> findById(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok().body(orderService.findById(id));
    }
}
