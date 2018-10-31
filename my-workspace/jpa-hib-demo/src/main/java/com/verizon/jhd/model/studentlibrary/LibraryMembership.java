package com.verizon.jhd.model.studentlibrary;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.verizon.jhd.model.onetoone.AssociateEmployee;

@Entity
@Table(name="librarymembers")
public class LibraryMembership {

	@Id
	private String libraryMemberId;
	
	@OneToOne
	@JoinColumn(name="memberId")
	private Student memberStudent;
	
	public LibraryMembership() {
		
	}

	public LibraryMembership(String libraryMemberId) {
		super();
		this.libraryMemberId = libraryMemberId;
	}

	public String getLibraryMemberId() {
		return libraryMemberId;
	}

	public void setLibraryMemberId(String libraryMemberId) {
		this.libraryMemberId = libraryMemberId;
	}

	public Student getMemberStudent() {
		return memberStudent;
	}

	public void setMemberStudent(Student memberStudent) {
		this.memberStudent = memberStudent;
	}
	
	
}
