package com.example.spring.stockservice.repository;

import com.example.spring.stockservice.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, String> {
}
