package com.car.rental.service;

import java.util.Optional;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.car.rental.converter.AtmConverter;
import com.car.rental.converter.BookNowConverter;
import com.car.rental.dao.AtmRepository;
import com.car.rental.dao.BookNowRepository;
import com.car.rental.dao.CarRepository;
import com.car.rental.dao.DriverHotelRepository;
import com.car.rental.dao.DriverRepository;
import com.car.rental.dao.TicketRepository;
import com.car.rental.dao.UserRepository;
import com.car.rental.dto.ReqAtmDto;
import com.car.rental.dto.ReqBookNowDto;
import com.car.rental.dto.ReqDriverHotelDto;
import com.car.rental.dto.ResAtmDto;
import com.car.rental.dto.ResBookNowDto;
import com.car.rental.dto.ResDriverHotelDto;
import com.car.rental.entity.Atm;
import com.car.rental.entity.BookNow;
import com.car.rental.entity.Car;
import com.car.rental.entity.Driver;
import com.car.rental.entity.DriverHotel;
import com.car.rental.entity.TicketDetails;
import com.car.rental.entity.User;
import com.car.rental.helper.RandomIdGenerator;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Service
public class TicketServiceImpl implements TicketService {
	
	private TicketDetails ticket = new TicketDetails();
	
	@Autowired private ModelMapper modelMapper;
	
	@Autowired private CarRepository carRepository;
	
	@Autowired private TicketRepository ticketRepository;
	
	@Autowired private UserRepository userRepository;

	@Autowired private BookNowRepository bookNowRepository;
	
	@Autowired private DriverRepository driverRepository;
	
	@Autowired private DriverHotelRepository driverHotelRepository;

	@Autowired private AtmRepository atmRepository;
	
	@Autowired private BookNowConverter bookNowConverter;
	
	@Autowired private AtmConverter atmConverter;
	
	@Override
	public ResBookNowDto addBookingDetails(ReqBookNowDto bookNowDto) {
		
        //Find car by Id
		Optional<Car> optionalCar = carRepository.findById(bookNowDto.getCarId());
		Car car = optionalCar.get();
		
		float totalPrice = car.getCharge() * bookNowDto.getDays();

		BookNow bookNow = this.modelMapper.map(bookNowDto, BookNow.class);
		bookNow.set_id(RandomIdGenerator.generateRandomId());
		bookNow.setTotalPrice(totalPrice);
		bookNow.setCar(car);
		
//		bookNowRepository.save(bookNow);

		ticket.set_id(RandomIdGenerator.generateRandomId());
		ticket.setBookNow(bookNow);
		
		return bookNowConverter.entityToDto(bookNow);
	}


	@Override
	public ResDriverHotelDto addDriverHotel(ReqDriverHotelDto driverHotelDto) {
		
		DriverHotel driverHotel = this.modelMapper.map(driverHotelDto, DriverHotel.class);
		driverHotel.set_id(RandomIdGenerator.generateRandomId());
		
//		driverHotelRepository.save(driverHotel);
		ticket.setDriverHotel(driverHotel);
		
		return this.modelMapper.map(driverHotel, ResDriverHotelDto.class);
	}


	@Override
	public ResAtmDto addAtm(ReqAtmDto atmDto) {
		
		//Find driver by Id
		Optional<Driver> optionalDriver = driverRepository.findById(atmDto.getDriverID());
		Driver driver = optionalDriver.get();
		
		//Retrieve the current request
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
      
		//Retrieve the session from the request
		HttpSession session = request.getSession();
      
		//Access the session value
		String email = (String) session.getAttribute("email");
    
		//Find user by email
		User user = userRepository.getUserByUserName(email);
		
		Atm atm = new Atm();
		atm.setId(RandomIdGenerator.generateRandomId());
		atm.setCardNo(atmDto.getCardNo());
		
//		atm = atmRepository.save(atm);
		
		ticket.setUser(user);
		ticket.setAtm(atm);
		ticket.setDriver(driver);
		
		ticket = ticketRepository.save(ticket);
//		System.out.println(ticket);
//		System.out.println("------------------------------------XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX------------------------------");
		
		ResAtmDto resAtmDto = atmConverter.entityToDto(ticket);
		
		// Empty the object
        ticket = new TicketDetails();
		
        return resAtmDto;
	}
	
	
	
	
	

}
