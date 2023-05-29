package com.car.rental.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.car.rental.converter.UserConverter;
import com.car.rental.dao.UserRepository;
import com.car.rental.dto.AuthRequest;
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
	
	@Autowired
	private JwtService jwtService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
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
	public ResLoginDto authenticateAndGetToken(AuthRequest authRequest) {
		
		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getEmail(), authRequest.getPassword()));
        
//		System.out.println(new UsernamePasswordAuthenticationToken(authRequest.getEmail(), authRequest.getPassword()));
//		System.out.println(authentication);
		
		if (authentication.isAuthenticated()) {
			final String token =  jwtService.generateToken(authRequest.getEmail());
            
			User user = userRepository.getUserByUserName(authRequest.getEmail());
            ResLoginDto resLoginDto = new ResLoginDto();
            resLoginDto.setUser(userConverter.entityToDto(user));
            resLoginDto.setAuth(token);
            
            return resLoginDto;
        } else {
            throw new UsernameNotFoundException("invalid user request !");
        }
	}
}
