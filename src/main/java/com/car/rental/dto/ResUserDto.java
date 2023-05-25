package com.car.rental.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class ResUserDto {
	
	private int _id;
	private String fname;
	private String lname;
	private LocalDate dob;
	private String email;
	
}
