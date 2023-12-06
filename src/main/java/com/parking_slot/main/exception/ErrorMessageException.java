package com.parking_slot.main.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.parking_slot.main.response.ApiResponse;

import lombok.Getter;

@Getter
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class ErrorMessageException extends RuntimeException{

	private static final long serialVersionUID = 1L;
    private ApiResponse apiResponse;
	
	public ErrorMessageException(String msg) {
		super(msg);
	}
	
	public ErrorMessageException(ApiResponse apiResponse) {
		super();
		this.apiResponse = apiResponse;
	}
	
	public ErrorMessageException(ApiResponse apiResponse,String msg) {
		super(msg);
		this.apiResponse=apiResponse;
	}
	
	

}
