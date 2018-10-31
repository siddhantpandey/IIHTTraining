package com.verizon.jhd.ui;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.verizon.jhd.model.onetoone.AssociateEmployee;
import com.verizon.jhd.model.onetoone.BankAccount;
import com.verizon.jhd.model.studentlibrary.LibraryMembership;
import com.verizon.jhd.model.studentlibrary.Student;
import com.verizon.jhd.util.JPAUtil;

public class StudentLibraryDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student st1 = new Student("2018001","Ram Singh");
		LibraryMembership lm1 = new LibraryMembership("2018L001");
		st1.setLibraryMembership(lm1);
		lm1.setMemberStudent(st1);
		
		
		
		EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
		EntityTransaction txn = em.getTransaction();
		txn.begin();
		em.persist(st1);	
		txn.commit();
		System.out.println("Data Persisted");
		JPAUtil.shutdown();
	}
}
