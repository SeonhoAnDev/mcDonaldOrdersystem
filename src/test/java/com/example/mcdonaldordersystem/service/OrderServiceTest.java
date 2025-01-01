package com.example.mcdonaldordersystem.service;

import com.example.mcdonaldordersystem.domain.CreatOrder;
import com.example.mcdonaldordersystem.domain.StoreProduct;
import com.example.mcdonaldordersystem.repository.OrderRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatRuntimeException;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OrderServiceTest {
    @Mock
    OrderRepository orderRepository;

    @Mock
    StoreService storeService;

    @InjectMocks
    OrderService orderService;

    @Test
    @DisplayName("商品の数量が在庫数量より少ないとき、正常注文ができる。")
    public void stockQuantityTest_success() {
        //given
        int buyQuantity = 100;
        int stockQuantity = 10;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(1, buyQuantity);
        CreatOrder creatOrder = CreatOrder.builder()
                .storeId(1)
                .customerId(1)
                .quantityByProduct(map)
                .build();
        StoreProduct stock = StoreProduct.builder()
                .stockQuantity(stockQuantity)
                .build();
        when(storeService.getStoreProduct(1,1)).thenReturn(stock);
        //when & then
        RuntimeException runtimeException = assertThrows(RuntimeException.class, () ->
                orderService.newOrder(creatOrder)
        );
        assertThat(runtimeException.getMessage()).isEqualTo("在庫がありません。");
    }
}