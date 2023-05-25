package com.car.rental.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import lombok.Data;

@Data
public class ResMyBookingsDto {

	private int _id;
	private String email;
	private String fname;
	private String lname;
	private String driverImg;
	private String driverName;
	private String driverMobNo;
	private float charges;
	private String hotel;
	private String room;
	private int stay;
	private String manageParking;
	private float finalCost;
	private String carCompany;
	private String carColor;
	private String carModel;
	private String carType;
	private String carImg;
	private String fuelType;
	private String pickUpLocation;
	private String dropLocation;
	private LocalTime pickUpTime;
	private LocalDate pickUpDate;
	private LocalDate dropDate;
	private int passangerCapacity;
	private int members;
	private int days;
	private String cardNo;
}
	