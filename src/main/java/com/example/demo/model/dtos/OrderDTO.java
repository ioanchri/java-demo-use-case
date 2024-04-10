package com.example.demo.model.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderDTO {
    private long customerId;
    private String deliveryAddress;
    private double totalAmount;
}
