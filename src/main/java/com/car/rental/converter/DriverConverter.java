package com.car.rental.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.car.rental.dto.ReqDriverDto;
import com.car.rental.dto.ResDriverDto;
import com.car.rental.entity.Driver;

@Component
public class DriverConverter {
	
	public ResDriverDto entityToDto(Driver driver){
		
		ResDriverDto driverDto = new ResDriverDto();
		
		driverDto.set_id(driver.get_id());
		driverDto.setDriverImg(driver.getDriverImg());
		driverDto.setDriverName(driver.getDriverName());
		driverDto.setDrivingExperiance(driver.getDrivingExperiance());
		driverDto.setDriverMobNo(driver.getDriverMobNo());
		driverDto.setAvailability(driver.getAvailability());
		driverDto.setFood(driver.getFood());
		driverDto.setSmoke(driver.getSmoke());
		driverDto.setDrink(driver.getDrink());
		driverDto.setCharges(driver.getCharges());
		driverDto.set_v(driver.get_v());
		
		return driverDto;
	}
	
	public List<ResDriverDto> entityToDto(List<Driver> driver){
		return driver.stream().map(x->entityToDto(x)).collect(Collectors.toList());
	}
	
	public Driver dtoToEntity(ReqDriverDto driverDto) {
		
		Driver driver = new Driver();

		driver.set_id(driverDto.get_id());
		driver.setDriverImg(driverDto.getDriverImg());
		driver.setDriverName(driverDto.getDriverName());
		driver.setDrivingExperiance(driverDto.getDrivingExperiance());
		driver.setDriverMobNo(driverDto.getDriverMobNo());
		driver.setAvailability(driverDto.getAvailability());
		driver.setFood(driverDto.getFood());
		driver.setSmoke(driverDto.getSmoke());
		driver.setDrink(driverDto.getDrink());
		driver.setCharges(driverDto.getCharges());
		driver.set_v(driverDto.get_v());
		
		return driver;
	}
	
	public List<Driver> dtoToEntity(List<ReqDriverDto> driverDto){
		return driverDto.stream().map(x->dtoToEntity(x)).collect(Collectors.toList());
	}
}
