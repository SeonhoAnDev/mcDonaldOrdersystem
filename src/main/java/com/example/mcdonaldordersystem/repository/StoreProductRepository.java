package com.example.mcdonaldordersystem.repository;

import com.example.mcdonaldordersystem.domain.StoreProduct;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface StoreProductRepository extends CrudRepository<StoreProduct, Integer> {
    Optional<StoreProduct> findByStoreIdAndProductId(int storeId, int productId);
}
