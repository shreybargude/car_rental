package com.car.rental.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.car.rental.converter.DriverConverter;
import com.car.rental.dao.DriverRepository;
import com.car.rental.dto.ReqDriverDto;
import com.car.rental.dto.ResDriverDto;
import com.car.rental.entity.Driver;

@Service
public class DriverServiceImpl implements DriverService{

	@Autowired
	private DriverRepository driverRepository;
	
	@Autowired
	private DriverConverter driverConverter;
	
	@Override
	public List<ResDriverDto> getDrivers() {
		List<Driver> driver = driverRepository.findAll();
		
		List<ResDriverDto> driverDto = driverConverter.entityToDto(driver);
		
		return driverDto;
	}

	@Override
	public ResDriverDto addDriver(ReqDriverDto driverDto) {
		
		Driver driver = driverConverter.dtoToEntity(driverDto);
		driver = driverRepository.save(driver);
		
		return driverConverter.entityToDto(driver);
	}
}
