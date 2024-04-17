package com.example.demo.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor

public class Customer implements Serializable {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)

    private int id;
    private String firstName;
    private String lastName;
    private String address;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false, unique = true)
    private String vatNumber;
    private String phoneNumber;
    private Double totalGross;
    private boolean isActive;
    private String dateOfBirth;
    private LocalDate createdDate;

    @OneToMany (mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Orders> orders;


    public Customer (String firstName, String lastName, String address, String email, String phoneNumber, String vatNumber, double totalGross , String dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.vatNumber = vatNumber;
        this.totalGross = totalGross;
        this.isActive = true;
        this.dateOfBirth = dateOfBirth;
        this.createdDate = LocalDate.now();
    }



}
