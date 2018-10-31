package com.verizon.jhd.model.studentlibrary;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.verizon.jhd.model.onetoone.BankAccount;

@Entity
@Table(name="students")
public class Student {

	@Id
	private String regNo;
	private String studentName;
	
	@OneToOne(mappedBy="memberStudent",cascade=CascadeType.ALL,fetch=FetchType.LAZY) //two-way mapping
	private LibraryMembership libraryMembership;

	
	public Student() {
		
	}


	public LibraryMembership getLibraryMembership() {
		return libraryMembership;
	}


	public void setLibraryMembership(LibraryMembership libraryMembership) {
		this.libraryMembership = libraryMembership;
	}


	public Student(String regNo, String studentName) {
		super();
		this.regNo = regNo;
		this.studentName = studentName;
	}


	public String getRegNo() {
		return regNo;
	}


	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}


	public String getStudentName() {
		return studentName;
	}


	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	
}
