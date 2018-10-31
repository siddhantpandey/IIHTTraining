package com.verizon.jhd.ui;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.verizon.jhd.model.Gender;
import com.verizon.jhd.model.Person;
import com.verizon.jhd.util.JPAUtil;

public class SavePerson {

	public static void main(String[] args) {

		Person person1= new Person("Siddhant","Pandey",Gender.Masculine,false,LocalDate.of(1995,9,02));
		Person person2= new Person("Aakanksha","Saini",Gender.Feminine,false,LocalDate.of(1995,10,24));
		
		EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
		EntityTransaction txn = em.getTransaction();
		txn.begin();
		em.persist(person1);
		em.persist(person2);
		txn.commit();
		System.out.println("Data Persisted");
		JPAUtil.shutdown();
		

	}

}
