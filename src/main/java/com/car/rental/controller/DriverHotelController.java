package com.car.rental.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.car.rental.dto.ReqDriverHotelDto;
import com.car.rental.dto.ResDriverHotelDto;
import com.car.rental.service.TicketService;

@RestController
@CrossOrigin(origins= "http://localhost:3000")
public class DriverHotelController {
	
	@Autowired
	private TicketService ticketService;
	
	@PostMapping("/driver-hotel")
	public ResponseEntity<ResDriverHotelDto> addDriverHotel(@RequestBody ReqDriverHotelDto driverHotelDto){
		
		ResDriverHotelDto driverHotel = ticketService.addDriverHotel(driverHotelDto);
		
		if(driverHotel!=null) {
			return new ResponseEntity<>(driverHotel, HttpStatus.CREATED);
		}else {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
