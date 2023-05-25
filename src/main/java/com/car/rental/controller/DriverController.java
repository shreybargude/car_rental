package com.car.rental.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.car.rental.dto.ReqDriverDto;
import com.car.rental.dto.ResDriverDto;
import com.car.rental.service.DriverService;

@RestController
@CrossOrigin(origins= "http://localhost:3000")
public class DriverController {
	
	@Autowired
	private DriverService driverService;
	
	@PostMapping("/drivers")
	public ResponseEntity<ResDriverDto> addDriver(@RequestBody ReqDriverDto driverDto){
		ResDriverDto newDriver = driverService.addDriver(driverDto);
		
		if(newDriver!=null) {
			return new ResponseEntity<>(newDriver,HttpStatus.CREATED);
		}else {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/drivers")
	public ResponseEntity<List<ResDriverDto>> getDrivers(){
		List<ResDriverDto> drivers = driverService.getDrivers();
		
		if(drivers!=null && !drivers.isEmpty()) {
			return new ResponseEntity<>(drivers,HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	
}
