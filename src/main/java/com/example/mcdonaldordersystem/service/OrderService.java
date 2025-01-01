package com.example.mcdonaldordersystem.service;

import com.example.mcdonaldordersystem.domain.CreatOrder;
import com.example.mcdonaldordersystem.domain.Order;
import com.example.mcdonaldordersystem.domain.StoreProduct;
import com.example.mcdonaldordersystem.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class OrderService {
    public final OrderRepository orderRepository;
    private final StoreService storeService;

    public OrderService(OrderRepository orderRepository, StoreService storeService) {
        this.orderRepository = orderRepository;
        this.storeService = storeService;
    }

    public void newOrder(CreatOrder creatOrder) {
        List<StoreProduct> storeProducts = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : creatOrder.getQuantityByProduct().entrySet()){
            Integer productId = entry.getKey();
            Integer buyQuantity = entry.getValue();

            StoreProduct storeProduct = storeService.getStoreProduct(
                    creatOrder.getStoreId(),
                    productId);

            int stockQuantity = storeProduct.getStockQuantity();

            if (buyQuantity > stockQuantity) {
                throw new RuntimeException("在庫がありません。");
            }

            storeProduct.adjustStockQuantity(buyQuantity);
            storeProducts.add(storeProduct);
        }
        Order entity = Order.newOrder(creatOrder);
        orderRepository.save(entity);
        storeService.saveAll(storeProducts);
    }
}
