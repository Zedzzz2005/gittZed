package com.bookingSystem.springdb;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "doctors")
public class docEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "doc_id")
	private Long docID;

	@Column(name = "doc_name")
	private String docName;

	@Column(name = "doc_specialization")
	private String docSpecialization;

	public Long getDocID() {
		return docID;
	}

	public void setDocID(Long docID) {
		this.docID = docID;
	}

	public String getDocName() {
		return docName;
	}

	public void setDocName(String docName) {
		this.docName = docName;
	}

	public String getdocSpecialization() {
		return docSpecialization;
	}

	public void setdocSpecialization(String docSpecialization) {
		this.docSpecialization = docSpecialization;
	}

}
