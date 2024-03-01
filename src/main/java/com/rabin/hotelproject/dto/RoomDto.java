package com.rabin.hotelproject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RoomDto {
    private Long id;
    private String roomType;
    private int roomNumber;
}
