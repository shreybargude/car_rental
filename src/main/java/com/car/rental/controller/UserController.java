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

import com.car.rental.dto.ReqLoginDto;
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
	
//	@Autowired
//	private BCryptPasswordEncoder passwordEncoder;
	
	@PostMapping("/register")
	public ResponseEntity<ResUserDto> addUser(@RequestBody ReqUserDto userDto) {
		
//		user.setPassword(passwordEncoder.encode(user.getPassword()));
		
		ResUserDto newUser = userService.addUser(userDto);
		System.out.println(newUser);
		if(newUser!=null) {
			return new ResponseEntity<>(newUser,HttpStatus.CREATED);
		}else {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
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
	public ResponseEntity<ResLoginDto> authenticateLogin(@RequestBody ReqLoginDto loginDto, HttpSession session) {
		
		ResLoginDto resLogin = userService.authenticateLogin(loginDto);
		
		if(resLogin!=null) {
			session.setAttribute("email", loginDto.getEmail());
			return new ResponseEntity<>(resLogin,HttpStatus.CREATED);
		}else {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
}
