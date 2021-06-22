package com.twan.framework.entity;

import java.util.ArrayList;
import java.util.List;

public class Hotel {


	private List<Reservation> reservations;

	private final long id;
	private final String hotelName;
	private float price;
	private boolean availability;

	public Hotel(long id, String hotelName) {
		this.id = id;
		this.hotelName = hotelName;
		this.reservations = new ArrayList<Reservation>();
		Reservation reservation = new Reservation();
		reservation.setReservationID(23);
		this.reservations.add(reservation);
	}
	
	public Hotel(long id, String hotelName, float price, boolean availability) {
		this.id = id;
		this.hotelName = hotelName;
		this.price = price;
		this.availability = availability;
		this.reservations = new ArrayList<Reservation>();
	}

	public long getId() {
		return id;
	}

	public String getHotelName() {
		return hotelName;
	}

	public List<Reservation> getReservations() {
		return reservations;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public boolean isAvailability() {
		return availability;
	}
	
	public void setAvailability(boolean availability) {
		this.availability = availability;
	}
	
	void setReservation(List<Reservation> reservations) {
		this.reservations = reservations;
	}

}
