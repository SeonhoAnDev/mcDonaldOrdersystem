package com.example.mcdonaldordersystem.repository;

import com.example.mcdonaldordersystem.domain.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {
}
