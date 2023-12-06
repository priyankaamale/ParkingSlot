package com.parking_slot.main.dto;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class parkingDetailsDto {
	
    private LocalDateTime entryDateTime;
	
	private LocalDateTime exitDateTime;
	@NotNull
	private int chargeperHour;

	private long totalHour;
	
	private int totalCharges;

}
