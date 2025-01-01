package com.example.mcdonaldordersystem.domain;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Table(name = "store_products")
@Builder
public class StoreProduct {
    @Id
    private int StoreProductId;

    @Column
    private int storeId;

    @Column
    private int productId;

    @Column
    private int stockQuantity;

    public void adjustStockQuantity(int buyQuantity) {
        if(stockQuantity < buyQuantity) {
            throw new RuntimeException("在庫よろ多く注文はできません。");
        }
        this.stockQuantity -= buyQuantity;
    }
}
