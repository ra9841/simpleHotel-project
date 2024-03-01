package com.rabin.hotelproject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "room_tbl")
public class Room {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "room_id")
    private Long id;
    @Column(name = "room_type", nullable = false)
    private String roomType;
    @Column(name = "room_number", nullable = false)
    private int roomNumber;
}
