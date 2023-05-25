package com.car.rental.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.car.rental.entity.BookNow;

public interface BookNowRepository extends JpaRepository<BookNow, String>{

}
