package com.parking_slot.main.exception;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiErrorResponse {
	
	private int statusCode;
	private String errorMsg;
	private LocalDate date;

}

