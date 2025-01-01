package com.example.mcdonaldordersystem.controller;

import com.example.mcdonaldordersystem.domain.CreatOrder;
import com.example.mcdonaldordersystem.service.OrderService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/api/v1/orders")
    public Response<Void> NewOrder(
            @RequestBody NewOrderRequest request
    ){
        orderService.newOrder(CreatOrder.builder()
                .customerId(request.getCustomerId())
                .storeId(request.getStoreId())
                .quantityByProduct(request.getProducts())
                .build());
        return Response.success(null);
    }
}
