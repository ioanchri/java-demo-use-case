package com.example.demo.model.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductDTO {
    private long orderProductId;
    private double code;
    private String name;
    private String description;
    private double price;
    private int quantity;
}
