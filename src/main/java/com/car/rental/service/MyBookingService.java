package com.car.rental.service;

import java.util.List;

import com.car.rental.dto.ResMyBookingsDto;

public interface MyBookingService {

	public List<ResMyBookingsDto> getMyBookings(String email);

}
