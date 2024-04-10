package com.example.demo.controller;

import com.example.demo.model.OrderProduct;
import com.example.demo.model.dtos.OrderProductDTO;
import com.example.demo.services.OrderProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/orderproducts")
@Slf4j

public class OrderProductController {

    @Autowired
    private OrderProductService orderProductService;

    @GetMapping
    public List<OrderProduct> getAllOrderProducts(@RequestBody OrderProductDTO orderProduct) {
        log.info("Order products recieved", orderProduct);
        return orderProductService.getAllOrderProducts();
    }

}