package com.parking_slot.main.service;

import java.util.List;

import com.parking_slot.main.dto.ParkingLotDto;
import com.parking_slot.main.response.CarResponse;
import com.parking_slot.main.response.ParkingDetailsResponse;
import com.parking_slot.main.response.ParkingLotresponse;

public interface ParkingLotService {

	ParkingLotDto createParkingLot(ParkingLotDto parkDto);

	ParkingDetailsResponse calculateCharges(int id);

	List<ParkingLotresponse> findAllParkingLots();

	List<Long> getTicketNumbersByColor(String color);

	List<CarResponse> getRegistrationNumbersByColor(String color);

	Long getTicketNumberByRegistrationNumber(String registrationNumber);



}
