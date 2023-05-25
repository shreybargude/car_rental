package com.car.rental.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.car.rental.converter.CarConverter;
import com.car.rental.dao.CarRepository;
import com.car.rental.dto.ReqCarDto;
import com.car.rental.dto.ResCarDto;
import com.car.rental.entity.Car;

@Service
public class CarServiceImpl implements CarService{
	
	@Autowired
	private CarRepository carRepository;
	
	@Autowired
	private CarConverter carConverter;
	
	@Override
	public List<ResCarDto> getCars() {
		List<Car> car = carRepository.findAll();
		
		List<ResCarDto> carDto = carConverter.entityToDto(car);
		return carDto;
	}

	@Override
	public ResCarDto getCar(String carId) {
		Car car = carRepository.findById(carId).get();
		return carConverter.entityToDto(car);
	}

	@Override
	public ResCarDto addCar(ReqCarDto carDto) {
		
		Car car = carConverter.dtoToEntity(carDto);
		car = carRepository.save(car);
		
		return carConverter.entityToDto(car);
	}
}


