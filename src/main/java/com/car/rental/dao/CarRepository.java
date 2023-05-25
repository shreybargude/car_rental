package com.car.rental.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.car.rental.entity.Car;

public interface CarRepository extends JpaRepository<Car, String>{

}
