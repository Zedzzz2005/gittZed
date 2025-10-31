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
@Table(name = "availability")
public class avaiEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "avail_id")
	private Long availID;
	private String startTime;
	private String endTime;
	private String availDate;

	@ManyToOne
	@JoinColumn(name = "doc_id")
	private docEntity doc;

	public Long getAvailID() {
		return availID;
	}

	public void setAvailID(Long availID) {
		this.availID = availID;
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

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getAvailDate() {
		return availDate;
	}

	public void setAvailDate(String availDate) {
		this.availDate = availDate;
	}

	public docEntity getDoc() {
		return doc;
	}

	public void setDoc(docEntity doc) {
		this.doc = doc;
	}

}
