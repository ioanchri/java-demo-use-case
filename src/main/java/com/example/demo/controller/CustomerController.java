package com.example.demo.controller;

import com.example.demo.model.Customer;
import com.example.demo.services.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
@Slf4j

public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping
    public Customer createCustomer(@RequestBody Customer customer){
        log.info("New customer recieved { }", customer);
    return  customerService.createNewCustomer(customer);
    }

    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();

    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable Long id){
        log.info("Deleting customer with id {}", id);
        customerService.deleteCustomer(id);
    }


    @PutMapping("/{id}")
    public Customer updateCustomer(@PathVariable Long id, @RequestBody Customer updatedCustomer) {
        log.info("Updating customer with id {}", id);
        return customerService.updateCustomer(id, updatedCustomer);
    }

}
