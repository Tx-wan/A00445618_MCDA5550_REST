package com.twan.framework.controller;

import java.util.ArrayList;
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
		List<Guest> resultguests = guestRepository.findAll();
		List<Guest> guests = new ArrayList<Guest>();
		
		for (Guest g : resultguests) {
			Guest guest = new Guest();
			guest.setGuestId(g.getGuestId());
			guest.setFirstName(g.getFirstName());
			guest.setLastName(g.getLastName());
			guest.setAge(g.getAge());
			guest.setGender(g.getGender());
			
			guests.add(guest);
		}
		
		return guests;
	}
	
	@RequestMapping(value="/saveguest", method=RequestMethod.POST,consumes="application/json")
	public Guest createGuest(@RequestBody Guest guest) {
		return guestRepository.save(guest);
	}
	
}
