package com.example.spring.stockservice.model;

import jakarta.persistence.*;

@Entity
@Table(name="orders")
public class Order {
    @Id
    @GeneratedValue(strategy= GenerationType.UUID)
    private String orderId;
    private String name;
    private int qty;
    private double price;

    public Order(com.example.spring.basedomains.dto.Order order) {
        this.name = order.getName();
        this.orderId = order.getOrderId();
        this.qty = order.getQty();
        this.price = order.getPrice();
    }

    public Order() {

    }
}
