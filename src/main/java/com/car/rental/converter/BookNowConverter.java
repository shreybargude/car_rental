package com.car.rental.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.car.rental.dto.ReqBookNowDto;
import com.car.rental.dto.ResBookNowDto;
import com.car.rental.entity.BookNow;

@Component
public class BookNowConverter {
	
	
	public ResBookNowDto entityToDto(BookNow bookNow){
		
		ResBookNowDto bookNowDto = new ResBookNowDto();
		
		bookNowDto.setCarCompany(bookNow.getCar().getCarCompany());
		bookNowDto.setCarColor(bookNow.getCar().getCarColor());
		bookNowDto.setCarModel(bookNow.getCar().getCarModel());
		bookNowDto.setCarType(bookNow.getCar().getCarType());
		bookNowDto.setCarOwner(bookNow.getCar().getCarOwner());
		bookNowDto.setCarImg(bookNow.getCar().getCarImg());
		bookNowDto.setNumPlate(bookNow.getCar().getNumPlate());
		bookNowDto.setInsuranceValidity(bookNow.getCar().getInsuranceValidity());
		bookNowDto.setFuelType(bookNow.getCar().getFuelType());
		bookNowDto.setFeature(bookNow.getCar().getFeature());
		bookNowDto.setPickUpLocation(bookNow.getPickUpLocation());
		bookNowDto.setDropLocation(bookNow.getDropLocation());
		bookNowDto.setPickUpTime(bookNow.getPickUpTime());
		bookNowDto.setPickUpDate(bookNow.getPickUpDate());
		bookNowDto.setDropDate(bookNow.getDropDate());
		bookNowDto.setPassangerCapacity(bookNow.getCar().getPassangerCapacity());
		bookNowDto.setMembers(bookNow.getMembers());
		bookNowDto.setDays(bookNow.getDays());
		bookNowDto.setNumBags(bookNow.getNumBags());
		bookNowDto.setTotalPrice(bookNow.getTotalPrice());
		bookNowDto.set_id(bookNow.get_id());
		
		return bookNowDto;
	}
	
	public List<ResBookNowDto> entityToDto(List<BookNow> bookNow){
		return bookNow.stream().map(x->entityToDto(x)).collect(Collectors.toList());
	}
	
	public BookNow dtoToEntity(ReqBookNowDto BookNowDto) {
		
		BookNow bookNow = new BookNow();
		
		bookNow.setPickUpLocation(BookNowDto.getPickUpLocation());
		bookNow.setDropLocation(BookNowDto.getDropLocation());
		bookNow.setPickUpTime(BookNowDto.getPickUpTime());
		bookNow.setPickUpDate(BookNowDto.getPickUpDate());
		bookNow.setDropDate(BookNowDto.getDropDate());
		bookNow.setMembers(BookNowDto.getMembers());
		bookNow.setDays(BookNowDto.getDays());
		bookNow.setNumBags(BookNowDto.getNumBags());
		
		return bookNow;
	}
	
	public List<BookNow> dtoToEntity(List<ReqBookNowDto> bookNowDto){
		return bookNowDto.stream().map(x->dtoToEntity(x)).collect(Collectors.toList());
	}
}
