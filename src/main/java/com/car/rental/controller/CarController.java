package com.car.rental.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.car.rental.dto.ReqCarDto;
import com.car.rental.dto.ResCarDto;
import com.car.rental.service.CarService;

import jakarta.servlet.http.HttpSession;

@RestController
@CrossOrigin(origins= "http://localhost:3000")
@SessionAttributes("email")
public class CarController {
	
	@Autowired
	private CarService carService;
	
	@PostMapping("/cars")
	public ResponseEntity<ResCarDto> addCar(@RequestBody ReqCarDto carDto){
		ResCarDto newCar = carService.addCar(carDto);
		
		if(newCar!=null) {
			return new ResponseEntity<>(newCar , HttpStatus.CREATED);
		}else {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/cars")
	public ResponseEntity<List<ResCarDto>> getCars(HttpSession session){
		List<ResCarDto> cars = carService.getCars();

//		String username = (String) session.getAttribute("email");
//		System.out.println("Email :" +username);		

		if(cars!=null && !cars.isEmpty()) {
			return new ResponseEntity<>(cars, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/book-car/{carId}")
	public ResponseEntity<ResCarDto> getCar(@PathVariable String carId,HttpSession session){
		ResCarDto car = carService.getCar(carId);
		
		if(car!=null) {
			return new ResponseEntity<>(car, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
