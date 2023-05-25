package com.car.rental.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.car.rental.dto.ReqCarDto;
import com.car.rental.dto.ResCarDto;
import com.car.rental.entity.Car;

@Component
public class CarConverter {
	
	public ResCarDto entityToDto(Car car){
		
		ResCarDto carDto = new ResCarDto();
		
		carDto.set_id(car.get_id());
		carDto.setCarCompany(car.getCarCompany());
		carDto.setCarColor(car.getCarColor());
		carDto.setCarModel(car.getCarModel());
		carDto.setCarType(car.getCarType());
		carDto.setCarImg(car.getCarImg());
		carDto.setCar360(car.getCar360());
		carDto.setCarOwner(car.getCarOwner());
		carDto.setNumPlate(car.getNumPlate());
		carDto.setRegDate(car.getRegDate());
		carDto.setInsurance(car.getInsurance());
		carDto.setInsuranceValidity(car.getInsuranceValidity());
		carDto.setPassangerCapacity(car.getPassangerCapacity());
		carDto.setFuelType(car.getFuelType());
		carDto.setFeature(car.getFeature());
		carDto.setTotalRunning(car.getTotalRunning());
		carDto.set_v(car.get_v());
		carDto.setCharge(car.getCharge());
		
		return carDto;
	}
	
	public List<ResCarDto> entityToDto(List<Car> car){
		return car.stream().map(x->entityToDto(x)).collect(Collectors.toList());
	}
	
	public Car dtoToEntity(ReqCarDto carDto) {
		
		Car car = new Car();
		
		car.set_id(carDto.get_id());
		car.setCarCompany(carDto.getCarCompany());
		car.setCarColor(carDto.getCarColor());
		car.setCarModel(carDto.getCarModel());
		car.setCarType(carDto.getCarType());
		car.setCarImg(carDto.getCarImg());
		car.setCar360(carDto.getCar360());
		car.setCarOwner(carDto.getCarOwner());
		car.setNumPlate(carDto.getNumPlate());
		car.setRegDate(carDto.getRegDate());
		car.setInsurance(carDto.getInsurance());
		car.setInsuranceValidity(carDto.getInsuranceValidity());
		car.setPassangerCapacity(carDto.getPassangerCapacity());
		car.setFuelType(carDto.getFuelType());
		car.setFeature(carDto.getFeature());
		car.setTotalRunning(carDto.getTotalRunning());
		car.set_v(carDto.get_v());
		car.setCharge(carDto.getCharge());
		
		return car;
	}
	
	public List<Car> dtoToEntity(List<ReqCarDto> carDto){
		return carDto.stream().map(x->dtoToEntity(x)).collect(Collectors.toList());
	}
}
