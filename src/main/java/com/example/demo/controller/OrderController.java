package com.example.demo.controller;

import com.example.demo.model.Orders;
import com.example.demo.model.dtos.OrderDTO;
import com.example.demo.services.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@Slf4j

public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public Orders createOrder(@RequestBody OrderDTO order){
        log.info("New order recieved { }",order);
        return  orderService.createNewOrder(order);
    }

    @GetMapping
    public List<Orders> getAllOrders() {
        return orderService.getAllOrders();
    }
}