package com.car.rental.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.car.rental.entity.DriverHotel;

public interface DriverHotelRepository extends JpaRepository<DriverHotel, String>{
	
}
