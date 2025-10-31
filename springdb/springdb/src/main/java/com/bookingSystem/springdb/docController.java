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
@RequestMapping("/doctors")
public class docController {
	@Autowired
	Repo repo;
	
	
	@GetMapping ("/{docID}")
	public ResponseEntity<docEntity> getDoc(@PathVariable Long docID) {
		return repo.findById(docID)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}

	@PostMapping
	public docEntity createDoc(@RequestBody docEntity doc) {
		return repo.save(doc);
	}

	@PutMapping("/{docID}")
	public ResponseEntity<docEntity> updateDoc(@PathVariable Long docID, @RequestBody docEntity update) {
		return repo.findById(docID).map(doc -> {
			doc.setDocName(update.getDocName());
			doc.setdocSpecialization(update.getdocSpecialization());
			docEntity save = repo.save(doc);
			return ResponseEntity.ok(save);
		}).orElseGet(() -> ResponseEntity.notFound().build());
	}

	@DeleteMapping("/{docID}")
	public ResponseEntity<Void> deleteDoc(@PathVariable Long docID) {
		if (repo.existsById(docID)) {
			repo.deleteById(docID);
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
