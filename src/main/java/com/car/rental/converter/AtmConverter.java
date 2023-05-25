package com.car.rental.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.car.rental.dto.ResAtmDto;
import com.car.rental.entity.TicketDetails;

@Component
public class AtmConverter {
	
	@Autowired
	private ModelMapper modelMapper;

	public ResAtmDto entityToDto(TicketDetails ticket) {
		
//		ResAtmDto atmDto = this.modelMapper.map(ticket, ResAtmDto.class);
		
		ResAtmDto atmDto = new ResAtmDto();
		
		atmDto.setEmail(ticket.getUser().getEmail());
		atmDto.setFname(ticket.getUser().getFname());
		atmDto.setLname(ticket.getUser().getLname());
		atmDto.setDriverImg(ticket.getDriver().getDriverImg());
		atmDto.setDriverName(ticket.getDriver().getDriverName());
		atmDto.setDriverMobNo(ticket.getDriver().getDriverMobNo());
		atmDto.setCharges(ticket.getDriver().getCharges());
		atmDto.setHotel(ticket.getDriverHotel().getHotel());
		atmDto.setRoom(ticket.getDriverHotel().getRoom());
		atmDto.setStay(ticket.getDriverHotel().getStay());
		atmDto.setManageParking(ticket.getDriverHotel().getManageParking());
		atmDto.setFinalCost(ticket.getDriverHotel().getFinalCost());
		atmDto.setCarCompany(ticket.getBookNow().getCar().getCarCompany());
		atmDto.setCarColor(ticket.getBookNow().getCar().getCarColor());
		atmDto.setCarModel(ticket.getBookNow().getCar().getCarModel());
		atmDto.setCarType(ticket.getBookNow().getCar().getCarType());
		atmDto.setCarImg(ticket.getBookNow().getCar().getCarImg());
		atmDto.setFuelType(ticket.getBookNow().getCar().getFuelType());
		atmDto.setPickUpLocation(ticket.getBookNow().getPickUpLocation());
		atmDto.setDropLocation(ticket.getBookNow().getDropLocation());
		atmDto.setPickUpTime(ticket.getBookNow().getPickUpTime());
		atmDto.setPickUpDate(ticket.getBookNow().getPickUpDate());
		atmDto.setDropDate(ticket.getBookNow().getDropDate());
		atmDto.setPassangerCapacity(ticket.getBookNow().getCar().getPassangerCapacity());
		atmDto.setMembers(ticket.getBookNow().getMembers());
		atmDto.setDays(ticket.getBookNow().getDays());
		atmDto.setCardNo(ticket.getAtm().getCardNo());
		atmDto.set_id(ticket.getAtm().getId());
		
		return atmDto;
	}
}
