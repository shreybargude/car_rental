package com.car.rental.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.car.rental.converter.MyBookingConverter;
import com.car.rental.dao.TicketRepository;
import com.car.rental.dao.UserRepository;
import com.car.rental.dto.ResMyBookingsDto;
import com.car.rental.entity.TicketDetails;
import com.car.rental.entity.User;

@Service
public class MyBookingServiceImpl implements MyBookingService {
	
	@Autowired
	private TicketRepository ticketRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private MyBookingConverter myBookingConverter;

	@Override
	public List<ResMyBookingsDto> getMyBookings(String email) {
		
		User user = userRepository.getUserByUserName(email);
		
		List<TicketDetails> ticketDetails = ticketRepository.findByUser(user);
		
		List<ResMyBookingsDto> myBookingsDto = new ArrayList<ResMyBookingsDto>();
		myBookingsDto = myBookingConverter.entityToDto(ticketDetails);
		
		return myBookingsDto;
	}
}
