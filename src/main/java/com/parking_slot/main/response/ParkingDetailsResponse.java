package com.parking_slot.main.response;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ParkingDetailsResponse {
	
	 	private LocalDateTime entryDateTime;
		
		private LocalDateTime exitDateTime;
		
		private int chargeperHour;
		private long totalHour;
		private int totalCharges;

}
