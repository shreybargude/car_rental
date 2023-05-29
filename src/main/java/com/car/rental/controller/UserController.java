package com.car.rental.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.car.rental.dto.AuthRequest;
import com.car.rental.dto.ReqUserDto;
import com.car.rental.dto.ResLoginDto;
import com.car.rental.dto.ResUserDto;
import com.car.rental.service.UserService;

import jakarta.servlet.http.HttpSession;

@RestController
@CrossOrigin(origins= "http://localhost:3000")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@PostMapping("/register")
	public ResponseEntity<ResUserDto> addUser(@RequestBody ReqUserDto userDto) {
		userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
		
		ResUserDto newUser = userService.addUser(userDto);

		if(newUser!=null) {
			return new ResponseEntity<>(newUser,HttpStatus.CREATED);
		}else {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//Additional request
	@GetMapping("/register")
	public ResponseEntity<List<ResUserDto>> getUsers(){
		List<ResUserDto> users = userService.getUsers();
		
		if(users!=null && !users.isEmpty()) {
			return new ResponseEntity<>(users,HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/login")
	public ResponseEntity<ResLoginDto> authenticateAndGetToken(@RequestBody AuthRequest authRequest, HttpSession session) {
		
		ResLoginDto resLogin = userService.authenticateAndGetToken(authRequest);
		
		if(resLogin!=null) {
			session.setAttribute("email", authRequest.getEmail());
			return new ResponseEntity<>(resLogin,HttpStatus.CREATED);
		}else {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
}
