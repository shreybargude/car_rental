package com.car.rental.dto;

import lombok.Data;

@Data
public class ReqCarDto {
	private String _id;
	private String carCompany;
	private String carColor;
	private String carModel;
	private String carType;
	private String carImg;
	private String car360;
	private String carOwner;
	private String numPlate;
	private String regDate;
	private String insurance;
	private String insuranceValidity;
	private int passangerCapacity;
	private String fuelType;
	private String feature;
	private long totalRunning;
	private String _v;
	private float charge;
}
