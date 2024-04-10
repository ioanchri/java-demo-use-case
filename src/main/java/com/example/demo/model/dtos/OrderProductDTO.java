package com.example.demo.model.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderProductDTO {

    private long customerId;
    private long orderId;

}
