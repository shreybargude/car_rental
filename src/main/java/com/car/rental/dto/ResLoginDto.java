package com.car.rental.dto;

import com.car.rental.entity.User;

import lombok.Data;

@Data
public class ResLoginDto {
	
	private User user;
	private String auth;
	
}
