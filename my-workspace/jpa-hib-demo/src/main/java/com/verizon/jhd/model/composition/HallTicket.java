package com.verizon.jhd.model.composition;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.verizon.jhd.model.composition.Identification;;

@Entity
@Table(name="halltickets")
public class HallTicket {

	@Id
	private String hallTicketNumber;
	private String candidateName;
	private String examTitle;
	@Embedded
	private Identification identity;
	public HallTicket() {
		super();
	}
	public HallTicket(String hallTicketNumber, String candidateName, String examTitle, Identification identity) {
		super();
		this.hallTicketNumber = hallTicketNumber;
		this.candidateName = candidateName;
		this.examTitle = examTitle;
		this.identity = identity;
	}
	public String getHallTicketNumber() {
		return hallTicketNumber;
	}
	public void setHallTicketNumber(String hallTicketNumber) {
		this.hallTicketNumber = hallTicketNumber;
	}
	public String getCandidateName() {
		return candidateName;
	}
	public void setCandidateName(String candidateName) {
		this.candidateName = candidateName;
	}
	public String getExamTitle() {
		return examTitle;
	}
	public void setExamTitle(String examTitle) {
		this.examTitle = examTitle;
	}
	public Identification getIdentity() {
		return identity;
	}
	public void setIdentity(Identification identity) {
		this.identity = identity;
	}
	
	
}
