package com.example.mcdonaldordersystem.service;

import com.example.mcdonaldordersystem.domain.StoreProduct;
import com.example.mcdonaldordersystem.repository.StoreProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StoreService {
    private final StoreProductRepository storeProductRepository;

    public StoreService(StoreProductRepository storeProductRepository) {
        this.storeProductRepository = storeProductRepository;
    }

    public StoreProduct getStoreProduct(int storeId, int productId) {
        Optional<StoreProduct> storeProductOptional = storeProductRepository.findByStoreIdAndProductId(storeId, productId);
        if (storeProductOptional.isEmpty()) {
            throw new RuntimeException("存在しない商品です。");
        }
        return storeProductOptional.get();
    }

    public void saveAll(List<StoreProduct> storeProducts) {
        storeProductRepository.saveAll(storeProducts);
    }
}
