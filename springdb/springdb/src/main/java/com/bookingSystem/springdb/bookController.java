package com.bookingSystem.springdb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/booking")
public class bookController {
	@Autowired
	bookRepo bookRepo;
	@Autowired
	Repo docRepo;
	@Autowired
	patientRepo patRepo;
	@Autowired 
	availRepo availRepo;
	
	@PostMapping
	public ResponseEntity<bookEntity> createBook(@RequestBody bookRequest req) {

		patientEntity patient = patRepo.findById(req.getPatId())
				.orElseThrow(() -> new RuntimeException("Patient not found"));
		avaiEntity availability = availRepo.findById(req.getAvail_id())
				.orElseThrow(() -> new RuntimeException("Availability not found"));
		
		bookEntity booking = new bookEntity();
		booking.setAvailId(availability);
		booking.setPatId(patient);
		booking.setStatus(req.getStatus());
		booking.setBookedTime(req.getBookedTime());
		

		bookEntity save = bookRepo.save(booking);

		return ResponseEntity.ok(save);

	}
}
