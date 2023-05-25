package com.car.rental.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.car.rental.dto.ResMyBookingsDto;
import com.car.rental.service.MyBookingService;

@RestController
@CrossOrigin
public class MyBookingController {
	
	@Autowired
	private MyBookingService myBookingService;
	
	@GetMapping("/ticket-details/{email}")
	public ResponseEntity<List<ResMyBookingsDto>> getMyBookings(@PathVariable String email) {

		List<ResMyBookingsDto> myBookings = myBookingService.getMyBookings(email);
		
		if(myBookings!=null && !myBookings.isEmpty()) {
			return new ResponseEntity<>(myBookings,HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
