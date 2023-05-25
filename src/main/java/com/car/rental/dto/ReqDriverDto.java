package com.car.rental.dto;

import lombok.Data;

@Data
public class ReqDriverDto {
	private String _id;
	private String driverImg;
	private String driverName;
	private String drivingExperiance;
	private String driverMobNo;
	private String availability;
	private String food;
	private String smoke;
	private String drink;
	private float charges;
	private float _v;
		
}