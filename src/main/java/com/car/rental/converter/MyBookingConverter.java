package com.car.rental.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.car.rental.dto.ResMyBookingsDto;
import com.car.rental.entity.TicketDetails;

@Component
public class MyBookingConverter {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public ResMyBookingsDto entityToDto(TicketDetails ticket) {
		
//		ResAtmDto myBookingsDto = this.modelMapper.map(ticket, ResAtmDto.class);
		
		ResMyBookingsDto myBookingsDto = new ResMyBookingsDto();
		
		myBookingsDto.set_id(ticket.get_id());
		myBookingsDto.setEmail(ticket.getUser().getEmail());
		myBookingsDto.setFname(ticket.getUser().getFname());
		myBookingsDto.setLname(ticket.getUser().getLname());
		myBookingsDto.setDriverImg(ticket.getDriver().getDriverImg());
		myBookingsDto.setDriverName(ticket.getDriver().getDriverName());
		myBookingsDto.setDriverMobNo(ticket.getDriver().getDriverMobNo());
		myBookingsDto.setCharges(ticket.getDriver().getCharges());
		myBookingsDto.setHotel(ticket.getDriverHotel().getHotel());
		myBookingsDto.setRoom(ticket.getDriverHotel().getRoom());
		myBookingsDto.setStay(ticket.getDriverHotel().getStay());
		myBookingsDto.setManageParking(ticket.getDriverHotel().getManageParking());
		myBookingsDto.setFinalCost(ticket.getDriverHotel().getFinalCost());
		myBookingsDto.setCarCompany(ticket.getBookNow().getCar().getCarCompany());
		myBookingsDto.setCarColor(ticket.getBookNow().getCar().getCarColor());
		myBookingsDto.setCarModel(ticket.getBookNow().getCar().getCarModel());
		myBookingsDto.setCarType(ticket.getBookNow().getCar().getCarType());
		myBookingsDto.setCarImg(ticket.getBookNow().getCar().getCarImg());
		myBookingsDto.setFuelType(ticket.getBookNow().getCar().getFuelType());
		myBookingsDto.setPickUpLocation(ticket.getBookNow().getPickUpLocation());
		myBookingsDto.setDropLocation(ticket.getBookNow().getDropLocation());
		myBookingsDto.setPickUpTime(ticket.getBookNow().getPickUpTime());
		myBookingsDto.setPickUpDate(ticket.getBookNow().getPickUpDate());
		myBookingsDto.setDropDate(ticket.getBookNow().getDropDate());
		myBookingsDto.setPassangerCapacity(ticket.getBookNow().getCar().getPassangerCapacity());
		myBookingsDto.setMembers(ticket.getBookNow().getMembers());
		myBookingsDto.setDays(ticket.getBookNow().getDays());
		myBookingsDto.setCardNo(ticket.getAtm().getCardNo());
		
		return myBookingsDto;
	}
	
	public List<ResMyBookingsDto> entityToDto(List<TicketDetails> ticketDetails){
		return ticketDetails.stream().map(x->entityToDto(x)).collect(Collectors.toList());
	}
	
}
	
	