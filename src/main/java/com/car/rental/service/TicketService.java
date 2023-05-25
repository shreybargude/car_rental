package com.car.rental.service;

import com.car.rental.dto.ReqAtmDto;
import com.car.rental.dto.ReqBookNowDto;
import com.car.rental.dto.ReqDriverHotelDto;
import com.car.rental.dto.ResAtmDto;
import com.car.rental.dto.ResBookNowDto;
import com.car.rental.dto.ResDriverHotelDto;

public interface TicketService {

	public ResBookNowDto addBookingDetails(ReqBookNowDto bookNowDto);

	public ResDriverHotelDto addDriverHotel(ReqDriverHotelDto driverHotelDto);

	public ResAtmDto addAtm(ReqAtmDto atmDto);

}
