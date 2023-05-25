package com.car.rental.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.car.rental.dto.ReqUserDto;
import com.car.rental.dto.ResUserDto;
import com.car.rental.entity.User;

@Component
public class UserConverter {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public ResUserDto entityToDto(User user){
		
		ResUserDto userDto = this.modelMapper.map(user, ResUserDto.class);
		
//		ResUserDto userDto = new ResUserDto();
//		
//		userDto.set_id(user.get_id());
//		userDto.setFname(user.getFname());
//		userDto.setLname(user.getLname());
//		userDto.setDob(user.getDob());
//		userDto.setEmail(user.getEmail());
//		
		return userDto;
	}
	
	public List<ResUserDto> entityToDto(List<User> user){
		return user.stream().map(x->entityToDto(x)).collect(Collectors.toList());
	}
	
	public User dtoToEntity(ReqUserDto userDto) {
		
		User user = new User();
		
		user.setFname(userDto.getFname());
		user.setLname(userDto.getLname());
		user.setDob(userDto.getDob());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		
		return user;
	}
	
	public List<User> dtoToEntity(List<ReqUserDto> userDto){
		return userDto.stream().map(x->dtoToEntity(x)).collect(Collectors.toList());
	}
}
