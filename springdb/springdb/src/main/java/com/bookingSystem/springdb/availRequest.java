package com.bookingSystem.springdb;

import java.time.LocalDate;
import java.time.LocalTime;

public class availRequest {
	private Long docID;
	private String startTime;
	private String endTime;
	private String availreqDate;

	public Long getDocID() {
		return docID;
	}

	public void setDocID(Long docID) {
		this.docID = docID;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTIme(String endTime) {
		this.endTime = endTime;
	}

	public String getAvailreqDate() {
		return availreqDate;
	}

	public void setAvailreqDate(String availreqDate) {
		this.availreqDate = availreqDate;
	}

}
