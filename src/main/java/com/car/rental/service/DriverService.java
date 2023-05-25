package com.car.rental.service;

import java.util.List;

import com.car.rental.dto.ReqDriverDto;
import com.car.rental.dto.ResDriverDto;

public interface DriverService {

	public List<ResDriverDto> getDrivers();

	public ResDriverDto addDriver(ReqDriverDto driverDto);

}
