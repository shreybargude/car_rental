package com.car.rental.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import lombok.Data;

@Data
public class ReqBookNowDto {
	private String carId;
	private String pickUpLocation;
	private String dropLocation;
	private LocalDate pickUpDate;
	private LocalTime pickUpTime;
	private LocalDate dropDate;
	private int passengerCapacity;
	private int members;
	private int days;
	private int numBags;
}