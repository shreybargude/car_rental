package com.car.rental.entity;

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

@Data
@Entity
public class TicketDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int _id;
	
	@ManyToOne
	private User user;
	
//	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "book_now_id")
//	@OneToOne(mappedBy = "ticketDetails", cascade = CascadeType.ALL)

    @OneToOne(cascade = { CascadeType.MERGE, CascadeType.REMOVE })
    @JoinColumn(name = "book_now_id")
	private BookNow bookNow;
	
	@ManyToOne
	private Driver driver;
	
	@OneToOne(cascade = CascadeType.MERGE,fetch = FetchType.LAZY)
	private DriverHotel driverHotel;
	
	@OneToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	private Atm atm;
	
	private String status;
	
}
