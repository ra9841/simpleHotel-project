package com.rabin.hotelproject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "administration_tbl")
public class Administration {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "admin_id")
    private Long id;
    @Column(name = "admin_name", nullable = false)
    private String name;
    @Column(name = "admin_role", nullable = false)
    private String role;
    @Column(name = "admin_username", nullable = false)
    private String username;
    @Column(name = "admin_password", nullable = false)
    private String password;
    @Column(name = "admin_dOB", nullable = false)
    private String dateOfBirth;
    @Column(name = "admin_email", nullable = false)
    private String email;
    @Column(name = "admin_createDate", nullable = false)
    private Date createDate;
    @Column(name = "admin_modifiedDate", nullable = false)
    private Date modifiedDate;
}
