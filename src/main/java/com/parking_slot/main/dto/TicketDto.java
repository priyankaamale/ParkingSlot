package com.parking_slot.main.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketDto {
	@Valid
	 private CarDto carDto;
    @NotNull
	 private int  slotNo;

}
