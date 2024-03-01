package com.rabin.hotelproject.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CustomerDto {
    private Long id;
    private String name;
    private String address;
    private Date bookDate;
    private Date modifiedDate;
    private Date dateOfBirth;
    private int phoneNumber;
    private String email;
}
