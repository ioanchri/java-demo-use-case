package com.example.demo.repository;
import com.example.demo.model.Customer;
import com.example.demo.model.Orders;
import jakarta.persistence.criteria.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface OrderRepository extends JpaRepository <Orders, Long> {

}
