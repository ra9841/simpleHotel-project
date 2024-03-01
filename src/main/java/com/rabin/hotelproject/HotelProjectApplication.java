package com.rabin.hotelproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class HotelProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelProjectApplication.class, args);
	}

}