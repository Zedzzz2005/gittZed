package com.bookingSystem.springdb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/patients")
public class patientController {
	@Autowired
	private patientRepo repo;

	@GetMapping("/{patientID}")
	public ResponseEntity<patientEntity> getPatient(@PathVariable Long patientID) {
		return repo.findById(patientID).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}

	@PostMapping
	public patientEntity createPatient(@RequestBody patientEntity patient) {
		return repo.save(patient);
	}

	@PutMapping("/{patientID}")
	public ResponseEntity<patientEntity> updatePatient(@PathVariable Long patientID,
			@RequestBody patientEntity updatePatient) {
		return repo.findById(patientID).map(update -> {
			update.setPatientName(updatePatient.getPatientName());
			update.setPatientEmail(updatePatient.getPatientEmail());
			update.setPatientAge(updatePatient.getPatientAge());
			update.setPatientSex(updatePatient.getPatientSex());
			patientEntity save = repo.save(update);
			return ResponseEntity.ok(save);
		}).orElseGet(() -> ResponseEntity.notFound().build());
	}

	@DeleteMapping("/{patientID}")
	public ResponseEntity<Void> deletePatient(@PathVariable Long patientID) {
		if (repo.existsById(patientID)) {
			repo.deleteById(patientID);
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
