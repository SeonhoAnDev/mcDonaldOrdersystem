package com.example.mcdonaldordersystem.service;

import com.example.mcdonaldordersystem.domain.CreatOrder;
import com.example.mcdonaldordersystem.domain.Order;
import com.example.mcdonaldordersystem.repository.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    public final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void newOrder(CreatOrder creatOrder) {
        Order entity = Order.newOrder(creatOrder);
        orderRepository.save(entity);
    }
}
