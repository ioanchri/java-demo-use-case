package com.example.demo.services;

import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j

public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;



    @RequestMapping("/customers")
    public Customer createNewCustomer(Customer customer) {
        log.info("Creating customer");
        Customer customerToSave = new Customer(customer.getFirstName(), customer.getLastName(), customer.getAddress(), customer.getEmail(), customer.getPhoneNumber(), customer.getVatNumber(), customer.getTotalGross(), customer.getDateOfBirth());
        return customerRepository.save(customerToSave);
    }


    public Customer findById(long id) {
        try {
            long start = System.currentTimeMillis();
            log.info("Simulating slow service");
            //We simulate a slow service
            Thread.sleep(3000);
            long end = System.currentTimeMillis();
            log.info("Simulation ended, time : {}", end - start);
        } catch (InterruptedException e) {
            log.error(e.getMessage());
            Thread.currentThread().interrupt();
        }
        return customerRepository.findById(id).orElseThrow(RuntimeException::new);
    }


    @Cacheable("customers")
    public List<Customer> getAllCustomers() {
        try {
            long start = System.currentTimeMillis();
            log.info("Simulating slow service");
            //We simulate a slow service
            Thread.sleep(3000);
            long end = System.currentTimeMillis();
            log.info("Simulation ended, time : {}", end - start);
        } catch (InterruptedException e) {
            log.error(e.getMessage());
            Thread.currentThread().interrupt();
        }
        return customerRepository.findAll();
    }


//    Delete Customer Service

    public void deleteCustomer(@PathVariable Long id) {
        log.info("Deleting customer with id {}", id);
        customerRepository.deleteById(id);
    }

//    Update Customer Service

    public Customer updateCustomer(@PathVariable Long id, @RequestBody Customer updatedCustomer) {
        log.info("Updating customer with id {}", id);
        Optional<Customer> optionalCustomer = customerRepository.findById(id);
        if (optionalCustomer.isPresent()) {
            Customer existingCustomer = optionalCustomer.get();
            existingCustomer.setFirstName(updatedCustomer.getFirstName());
            existingCustomer.setLastName(updatedCustomer.getLastName());
            existingCustomer.setAddress(updatedCustomer.getAddress());
            existingCustomer.setEmail(updatedCustomer.getEmail());
            existingCustomer.setTotalGross(updatedCustomer.getTotalGross());
            existingCustomer.setPhoneNumber(updatedCustomer.getPhoneNumber());
            existingCustomer.setDateOfBirth(updatedCustomer.getDateOfBirth());

            return customerRepository.save(existingCustomer);
        } else {
            // Handle case where customer with given id is not found

            return null;
        }
    }


}






