package com.rabin.hotelproject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "Customer_tbl")
public class Customer {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "customer_id")
    @Id
    private Long id;
    @Column(name = "customer_name", nullable = false)
    private String name;
    @Column(name = "customer_address", nullable = false)
    private String address;
    @Column(name = "room_bookDate", nullable = false)
    private Date bookDate;
    @Column(name = "room_modifiedDate", nullable = false)
    private Date modifiedDate;
    @Column(name = "customer_dOB", nullable = false)
    private Date dateOfBirth;
    @Column(name = "customer_phoneNumber", nullable = false)
    private int phoneNumber;
    @Column(name = "customer_email", nullable = false)
    private String email;
}
