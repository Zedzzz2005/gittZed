package com.bookingSystem.springdb;

public class bookRequest {
	public Long avail_id;
	public Long patId;
	public String status;
	public String bookedTime;

	public Long getPatId() {
		return patId;
	}

	public void setPatId(Long patId) {
		this.patId = patId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getAvail_id() {
		return avail_id;
	}

	public void setAvail_id(Long avail_id) {
		this.avail_id = avail_id;
	}

	public String getBookedTime() {
		return bookedTime;
	}

	public void setBookedTime(String bookedTime) {
		this.bookedTime = bookedTime;
	}

}
