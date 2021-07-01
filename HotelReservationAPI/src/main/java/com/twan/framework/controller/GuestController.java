package com.twan.framework.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.twan.framework.entity.Guest;
import com.twan.framework.repository.GuestRepository;

@RestController
public class GuestController {
	@Autowired
	private GuestRepository guestRepository;
	
	@RequestMapping("/guests")
	public List<Guest> getAllGuest() {
		return guestRepository.findAll();
	}
	
	@RequestMapping(value="/saveguest", method=RequestMethod.POST,consumes="application/json")
	public Guest createGuest(@RequestBody Guest guest) {
		return guestRepository.save(guest);
	}
	
}
