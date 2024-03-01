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
public class AdministrationDto {
    private Long id;
    private String name;
    private String role;
    private String username;
    private String password;
    private String dateOfBirth;
    private String email;
    private Date createDate;
    private Date modifiedDate;
}
