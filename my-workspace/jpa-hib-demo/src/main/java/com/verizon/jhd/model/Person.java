package com.verizon.jhd.model;

import javax.persistence.Transient;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Persons")
public class Person {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="pin")
	private int personIdentificationNumber;
	
	@Column(name="fnm")
	private String firstName;
	@Column(name="lnm")
	private String lastName;
	
	@Transient
	private String fullName;
	@Enumerated(EnumType.STRING)
	private Gender gender;
	private boolean isMarried;
	@Column(name="dob")
	private LocalDate dateOfBirth;
	
	public Person() {
		
	}
	
	public Person(String firstName, String lastName, Gender gender, boolean isMarried,
			LocalDate dateOfBirth) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		
		this.gender = gender;
		this.isMarried = isMarried;
		this.dateOfBirth = dateOfBirth;
	}

	
	public int getPersonIdentificationNumber() {
		return personIdentificationNumber;
	}
	
	/*
	public void setPersonIdentificationNumber(int personIdentificationNumber) {
		this.personIdentificationNumber = personIdentificationNumber;
	}*/
	
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName() {
		this.fullName = this.firstName+" "+this.lastName;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public boolean isMarried() {
		return isMarried;
	}
	public void setMarried(boolean isMarried) {
		this.isMarried = isMarried;
	}
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
		
	
}
