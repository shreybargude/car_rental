package com.car.rental.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import lombok.Data;

@Data
public class ResBookNowDto {
	private String carCompany;
	private String carColor;
	private String carModel;
	private String carType;
	private String carOwner;
	private String carImg;
	private String numPlate;
	private String insuranceValidity;
	private String fuelType;
	private String feature;
	private String pickUpLocation;
	private String dropLocation;
	private LocalTime pickUpTime;
	private LocalDate pickUpDate;
	private LocalDate dropDate;
	private int passangerCapacity;
	private int members;
	private int days;
	private int numBags;
	private float totalPrice;	
	private String _id;
	private int _v;
}