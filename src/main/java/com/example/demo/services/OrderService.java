package com.example.demo.services;

import com.example.demo.model.Customer;
import com.example.demo.model.Orders;
import com.example.demo.model.dtos.OrderDTO;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j

public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private CustomerRepository customerRepository;

    @RequestMapping("/orders")
    public Orders createNewOrder(@RequestBody OrderDTO order) {
        log.info("Creating new Order");

        Optional<Customer> customer = customerRepository.findById(order.getCustomerId());

        if (customer.isEmpty()) {
            return null;
        }

        Orders orderToSave = new Orders(customer.get(), order.getDeliveryAddress(), order.getTotalAmount());

        return orderRepository.save(orderToSave);
    }


    public List<Orders> getAllOrders() {
        return orderRepository.findAll();
    }

}
