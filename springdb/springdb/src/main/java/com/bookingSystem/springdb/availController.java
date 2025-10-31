package com.bookingSystem.springdb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/availability")
public class availController {
	@Autowired
	availRepo repo;
	@Autowired
	Repo docRepo;

	@PostMapping
	public ResponseEntity<avaiEntity> createAvail(@RequestBody availRequest avail) {
		docEntity doctor = docRepo.findById(avail.getDocID())
				.orElseThrow(() -> new RuntimeException("Doctor not found"));
		avaiEntity availability = new avaiEntity();
		availability.setAvailDate(avail.getAvailreqDate());
		availability.setStartTime(avail.getStartTime());
		availability.setEndTime(avail.getEndTime());
		availability.setDoc(doctor);
		avaiEntity save = repo.save(availability);
		return ResponseEntity.ok(save);
	}

}
