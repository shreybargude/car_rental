package com.car.rental.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.car.rental.dto.ReqBookNowDto;
import com.car.rental.dto.ResBookNowDto;
import com.car.rental.service.TicketService;

@RestController
@CrossOrigin(origins= "http://localhost:3000")
public class BookNowController {

	@Autowired
	private TicketService ticketService;
	
	@PostMapping("/book-now")
	public ResponseEntity<ResBookNowDto> bookNow(@RequestBody ReqBookNowDto bookNowDto){
		
		ResBookNowDto bookNow = ticketService.addBookingDetails(bookNowDto);
	
		if(bookNow!=null) {
			return new ResponseEntity<>(bookNow, HttpStatus.CREATED);
		}else {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
