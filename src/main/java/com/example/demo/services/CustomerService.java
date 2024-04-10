package com.example.demo.services;

import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Service
@Slf4j

public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @RequestMapping("/customers")
    public Customer createNewCustomer(Customer customer ){
        log.info("Creating customer");
//        Customer customerToSave = new Customer();
//        customerToSave.setFirstName(customer.getFirstName());
//        customerToSave.setLastName(customer.getLastName());
//        customerToSave.setAddress(customer.getAddress());
//        customerToSave.setEmail(customer.getEmail());
//        customerToSave.getCreatedDate(LocalDate.now);

        Customer customerToSave = new Customer(customer.getFirstName(), customer.getLastName(), customer.getAddress(),customer.getEmail(),customer.getPhoneNumber(), customer.getVatNumber(),customer.getTotalGross(),customer.getDateOfBirth());
        return customerRepository.save(customerToSave);
    }


    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

}
