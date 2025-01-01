package com.example.mcdonaldordersystem.repository;

import com.example.mcdonaldordersystem.domain.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Integer> {

}
