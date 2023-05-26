package com.car.rental.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.car.rental.converter.UserConverter;
import com.car.rental.dao.UserRepository;
import com.car.rental.dto.ReqLoginDto;
import com.car.rental.dto.ReqUserDto;
import com.car.rental.dto.ResLoginDto;
import com.car.rental.dto.ResUserDto;
import com.car.rental.entity.User;
import com.car.rental.helper.RandomIdGenerator;

@Service
public class UserServiceImpl implements UserService {
	
	Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserConverter userConverter;

	@Override
	public ResUserDto addUser(ReqUserDto userDto) {
		
//		logger.info("*********************************************************************************");
        
		User user = userConverter.dtoToEntity(userDto);
		user.set_id(RandomIdGenerator.generateRandomId());
		
		user = userRepository.save(user);
		
		return userConverter.entityToDto(user);
	}

	@Override
	public List<ResUserDto> getUsers() {
		List<User> user = userRepository.findAll();
		
		List<ResUserDto> userDto = new ArrayList<ResUserDto>();
		userDto = userConverter.entityToDto(user);
		
		return userDto;
	}

	@Override
	public ResLoginDto authenticateLogin(ReqLoginDto loginDto) {
		
		User user = userRepository.getUserByUserName(loginDto.getEmail());
		
		ResLoginDto loginDto1 = new ResLoginDto();
		if(user!=null) {
			String reqPassword = loginDto.getPassword();
			String dbPassword = user.getPassword();
			
			if(reqPassword.equals(dbPassword)) {
				loginDto1.setUser(user);
				loginDto1.setAuth("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.IiwiX192IjowfSwiaWF0IjoxNjgyODU3NTgwfQ.b4wayYIDhG_qTYRiVAqawT6GTAediC3XU8PrWfejXlQ");
				
//				Journey journey= new Journey();
//				journey.setUser(user);
//				model.addAttribute("data", journey);
//				System.out.println(journey);
				
				return loginDto1;
		
			}else {
				return loginDto1;
			}
		
		}else {
			return loginDto1;
		}
	}
}
