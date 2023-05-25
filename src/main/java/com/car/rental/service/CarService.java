package com.car.rental.service;

import java.util.List;

import com.car.rental.dto.ReqCarDto;
import com.car.rental.dto.ResCarDto;

public interface CarService {

	public List<ResCarDto> getCars();

	public ResCarDto addCar(ReqCarDto carDto);

	public ResCarDto getCar(String carId);

}
