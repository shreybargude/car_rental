package com.car.rental.dto;

import lombok.Data;

@Data
public class ResDriverHotelDto {
	private String _id;
	private String hotel;
	private String room;
	private int stay;
	private String manageParking;
	private float finalCost;
}
