package com.verizon.jhd.ui;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.verizon.jhd.model.isa.Employee;
import com.verizon.jhd.model.onetoone.AssociateEmployee;
import com.verizon.jhd.model.onetoone.BankAccount;
import com.verizon.jhd.util.JPAUtil;

public class OneToOneDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AssociateEmployee emp = new AssociateEmployee(101,"Raghu",58650);
		BankAccount acc = new BankAccount("SB0001","SBI","SBI0089");
		
		acc.setAccHolder(emp);
		
		emp.setSalaryAccount(acc);
		
		EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
		/*EntityTransaction txn = em.getTransaction();
		txn.begin();
		em.persist(emp);	
		txn.commit();
		System.out.println("Data Persisted");*/
		
		//retrieve data
		
		AssociateEmployee emp1 = em.find(AssociateEmployee.class, 101);
		
		em.close();
		JPAUtil.shutdown();
		if(emp1!=null) {
			System.out.println("Emp Name "+emp1.getEname() );
			BankAccount acc1 = emp1.getSalaryAccount();
			System.out.println("Bank Acc Number "+acc1.getAccNum());
		}
		//em.close();
		//JPAUtil.shutdown();
	}

}
