package com.twan.framework.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.twan.framework.entity.Hotel;
import com.twan.framework.entity.Reservation;


@RestController
public class HotelController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
	
	@RequestMapping("/getListOfHotels")
	public List<Hotel> getListOfHotels() {
		List<Hotel> hotelsList = this.getHotelList();
		return hotelsList;
	}
	
	@RequestMapping(value="/reservationConfirmation", method=RequestMethod.POST,consumes="application/json")
	public String reservationConfirmation(@RequestBody Reservation reservation) {
		return "Confirmation Number :"+ reservation.getReservationID();
	}
	
	public List<Hotel> getHotelList() {
		List<Hotel> hotelsList = new ArrayList<Hotel>();
		List<String> hotelsNames = Arrays.asList("Holiday Inn","Hilton", "Four Seasons", "Marriot");
		Random random = new Random();
		
		for(int i=0; i<hotelsNames.size(); i++) {
			float randomPrice = random.nextInt(30000 - 5000 + 100) / 100 + 50;
			
			Hotel hotel = new Hotel(i+1, hotelsNames.get(i), randomPrice, true);
			
			hotelsList.add(hotel);
			hotel = null;
		}
		
		return hotelsList;
	}
	
	
	
	@GetMapping("/getBookings")
	public Hotel getBookings(@RequestParam(value = "name", defaultValue = "CozyHotel") String name) {
		return new Hotel(counter.incrementAndGet(),name);
	}
}