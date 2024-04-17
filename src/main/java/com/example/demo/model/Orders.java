package com.example.demo.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor

public class Orders {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name = "customer_id") // This is the foreign key in the 'order' table.private Customer customer;
    private Customer customer;
    @Column(nullable = false, unique = true)
    private String deliveryAddress;
    @Column(nullable = false)
    private double totalAmount;
    private LocalDate CreatedAt;


    public Orders (Customer customer, String deliveryAddress, double totalAmount){
        this.customer = customer;
        this.deliveryAddress = deliveryAddress;
        this.totalAmount = totalAmount;
        this.CreatedAt = LocalDate.now();
    }

}
