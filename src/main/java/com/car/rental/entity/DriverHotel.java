package com.car.rental.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="driver_hotel")
public class DriverHotel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int _id;
	private String hotel;
	private String room;
	private int stay;
	private String manageParking;
	private float finalCost;
	
}
