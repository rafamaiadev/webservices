package com.example.webservices.service;

import com.example.webservices.domain.model.Order;
import com.example.webservices.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    public Order findById(Long id) {
        Optional<Order> order = Optional.ofNullable(orderRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("id not found")));
        return order.get();
    }
}
