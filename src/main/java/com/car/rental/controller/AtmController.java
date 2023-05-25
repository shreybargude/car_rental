package com.car.rental.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.car.rental.dto.ReqAtmDto;
import com.car.rental.dto.ResAtmDto;
import com.car.rental.service.TicketService;

@RestController
@CrossOrigin(origins= "http://localhost:3000")
public class AtmController {
	
	@Autowired
	private TicketService ticketService;
	
	@PostMapping("/finalConfirm")
	public ResponseEntity<ResAtmDto> addAtm(@RequestBody ReqAtmDto atmDto) {
		ResAtmDto atm = ticketService.addAtm(atmDto);
		if(atm!=null) {
			return new ResponseEntity<>(atm,HttpStatus.CREATED);
		}else {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
