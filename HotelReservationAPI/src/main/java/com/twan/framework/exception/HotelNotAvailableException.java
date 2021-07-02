package com.twan.framework.exception;

public class HotelNotAvailableException extends Exception{
	private static final long serialVersionUID = 1L;
	
	public HotelNotAvailableException(String message) {
		super(message);
	}
}
