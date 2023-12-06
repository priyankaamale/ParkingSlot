package com.parking_slot.main.response;

import com.parking_slot.main.dto.CarDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketResponse {
	
	 private CarDto carDto;

	 private String  ParkingSlot;

}
