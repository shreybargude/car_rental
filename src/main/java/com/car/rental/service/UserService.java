package com.car.rental.service;

import java.util.List;

import com.car.rental.dto.ReqLoginDto;
import com.car.rental.dto.ReqUserDto;
import com.car.rental.dto.ResLoginDto;
import com.car.rental.dto.ResUserDto;

public interface UserService {

	public ResUserDto addUser(ReqUserDto userDto);

	public List<ResUserDto> getUsers();

	public ResLoginDto addLogin(ReqLoginDto loginDto);

}
