package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name = "orderProduct_id")
    private OrderProduct orderProduct;
    private double code;
    private String name;
    private String description;
    private double price;
    private int quantity;

    public Product (OrderProduct orderProduct, double code, String name, double price, int quantity, String description){
        this.orderProduct = orderProduct;
        this.code = code;
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }


}

