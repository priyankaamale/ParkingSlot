package com.parking_slot.main.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ParkingLotDto {
	@NotNull
	private int id;
	
	@NotNull(message = "Add Slot")
   private String slots;
	
    @NotNull
    @Size(max = 10,min = 5)
    private int capacity;

}
