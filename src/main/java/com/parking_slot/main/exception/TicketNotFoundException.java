package com.parking_slot.main.exception;

public class TicketNotFoundException extends RuntimeException {
	public TicketNotFoundException(String msg)
	{
		super(msg);
	}

}
