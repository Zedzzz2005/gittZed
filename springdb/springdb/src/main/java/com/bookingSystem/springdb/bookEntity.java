package com.bookingSystem.springdb;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "booking")
public class bookEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long bookId;

	@ManyToOne
	@JoinColumn(name = "avail_id")
	private avaiEntity availId;

	@ManyToOne
	@JoinColumn(name = "patient_id")
	private patientEntity patId;

	private String status;
	
	@Column (name = "booked_time")
	private String bookedTime;

	public patientEntity getPatId() {
		return patId;
	}

	public void setPatId(patientEntity patId) {
		this.patId = patId;
	}

	public Long getBookId() {
		return bookId;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getBookedTime() {
		return bookedTime;
	}

	public void setBookedTime(String bookedTime) {
		this.bookedTime = bookedTime;
	}

	public avaiEntity getAvailId() {
		return availId;
	}

	public void setAvailId(avaiEntity availId) {
		this.availId = availId;
	}
}
