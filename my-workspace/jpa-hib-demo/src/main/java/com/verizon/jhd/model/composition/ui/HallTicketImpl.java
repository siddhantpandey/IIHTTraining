package com.verizon.jhd.model.composition.ui;

import com.verizon.jhd.model.composition.Identification;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.verizon.jhd.model.composition.HallTicket;

import com.verizon.jhd.util.JPAUtil;

public class HallTicketImpl {

public static void main(String[] args) {
		
		HallTicket ht1= new HallTicket("JEE2014","Ram Prasad","JEE-Mains",new Identification("ramImg","ramPrint")); 
		
		
		
		
		EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
		EntityTransaction txn = em.getTransaction();
		txn.begin();
		em.persist(ht1);
		
		txn.commit();
		System.out.println("Data Persisted");
		JPAUtil.shutdown();

	}

}
