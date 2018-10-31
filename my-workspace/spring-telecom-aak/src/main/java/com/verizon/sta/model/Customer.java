package com.verizon.sta.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customers")
public class Customer {

	@Id
	private int custId;
	private String custName;
	private String telecomCircle;
	private String vas;
	private String pBills;
	private String custType;
	
	
	public Customer() {
		super();
	}
	public Customer(int custId, String custName, String telecomCircle, String vas, String pBills, String custType) {
		super();
		this.custId = custId;
		this.custName = custName;
		this.telecomCircle = telecomCircle;
		this.vas = vas;
		this.pBills = pBills;
		this.custType = custType;
	}
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getTelecomCircle() {
		return telecomCircle;
	}
	public void setTelecomCircle(String telecomCircle) {
		this.telecomCircle = telecomCircle;
	}
	public String getVas() {
		return vas;
	}
	public void setVas(String vas) {
		this.vas = vas;
	}
	public String getpBills() {
		return pBills;
	}
	public void setpBills(String pBills) {
		this.pBills = pBills;
	}
	public String getCustType() {
		return custType;
	}
	public void setCustType(String custType) {
		this.custType = custType;
	}
	
	
	
}
