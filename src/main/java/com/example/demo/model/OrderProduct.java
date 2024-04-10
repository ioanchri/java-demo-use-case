package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class OrderProduct {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;
    @OneToOne
    @JoinColumn (name = "customer_id")
    private Customer customer;
    private int productId;
    @OneToOne
    @JoinColumn (name = "order_id")
    private Orders order;

    public OrderProduct(Customer customer,Orders order){
        this.customer = customer;
        this.order = order;
    }

}
