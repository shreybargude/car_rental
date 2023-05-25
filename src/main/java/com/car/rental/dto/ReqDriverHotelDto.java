package com.car.rental.dto;

import lombok.Data;

@Data
public class ReqDriverHotelDto {
	private String hotel;
	private String room;
	private int stay;
	private String manageParking;
	private float finalCost;
}
