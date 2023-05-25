package com.car.rental.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Data;
@Entity
@Data
public class BookNow {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int _id;
	
	private String pickUpLocation;
	private String dropLocation;
	private LocalDate pickUpDate;
	private LocalTime pickUpTime;
	private LocalDate dropDate;
	private int members;
	private int days;
	private int numBags;
	private float totalPrice;
	
	@ManyToOne
	private Car car;
	
//	@OneToOne
//  @JoinColumn(name = "ticket_details_id")
	@OneToOne(mappedBy = "bookNow", cascade = CascadeType.ALL)
	private TicketDetails ticketDetails;
}