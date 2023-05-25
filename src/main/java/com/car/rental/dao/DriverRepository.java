package com.car.rental.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.car.rental.entity.Driver;

public interface DriverRepository extends JpaRepository<Driver, String>{

}
