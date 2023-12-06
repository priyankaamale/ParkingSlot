package com.parking_slot.main.exception;

public class CustomerNotFoundException extends RuntimeException{
	public CustomerNotFoundException(String msg)
	{
		super(msg);
	}

}
