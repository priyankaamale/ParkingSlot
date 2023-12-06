package com.parking_slot.main.exception;

public class SlotNotFoundException extends RuntimeException {
public SlotNotFoundException(String msg)
{
	super(msg);
}
}
