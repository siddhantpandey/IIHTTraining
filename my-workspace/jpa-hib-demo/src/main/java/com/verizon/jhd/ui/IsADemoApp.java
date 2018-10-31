package com.verizon.jhd.ui;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.verizon.jhd.model.isa.ContractEmployee;
import com.verizon.jhd.model.isa.Employee;
import com.verizon.jhd.model.isa.Manager;
import com.verizon.jhd.util.JPAUtil;

public class IsADemoApp {

	public static void main(String[] args) {
		
		Employee emp1 = new Employee(101,"SIDDHANT",17000.0);
		Employee emp2 = new Employee(102,"ANANNYA",17000.0);
		
		ContractEmployee emp3 = new ContractEmployee(103,"RAM",10000.0,45);
		
		Manager emp4 = new Manager(104,"SARANYA",78435.0,56789);
		
		EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
		EntityTransaction txn = em.getTransaction();
		txn.begin();
		em.persist(emp1);
		em.persist(emp2);
		em.persist(emp3);
		em.persist(emp4);
		txn.commit();
		System.out.println("Data Persisted");
		JPAUtil.shutdown();

	}

}
