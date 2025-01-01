package com.example.mcdonaldordersystem.controller;

import com.example.mcdonaldordersystem.domain.CreatOrder;
import com.example.mcdonaldordersystem.service.OrderService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/api/v1/orders")
    public Response<Void> createNewOrder(){
        HashMap<Integer, Integer> orderMap = new HashMap<>();
        orderMap.put(1, 1);
        orderMap.put(2, 1);
        orderService.newOrder(CreatOrder.builder()
                        .customerId(1)
                        .quantityByProduct(orderMap)
                .build());
        return Response.success(null);
    }
}
