package com.twan.framework.controller;

import com.twan.framework.entity.Hotel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;


@RestController
public class HotelController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@GetMapping("/getBookings")
	public Hotel getBookings(@RequestParam(value = "name", defaultValue = "CozyHotel") String name) {
		return new Hotel(counter.incrementAndGet(),name);
	}
}