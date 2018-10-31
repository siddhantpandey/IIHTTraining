package com.verizon.jhd.model.onetoone;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="bankaccounts")
public class BankAccount {
	
	@Id
	private String accNum;
	private String bankTitle;
	private String ifscCode;
	
	@OneToOne
	@JoinColumn(name="accHolderId")
	private AssociateEmployee accHolder;
	
	public BankAccount() {
		
	}

	public BankAccount(String accNum, String bankTitle, String ifscCode) {
		super();
		this.accNum = accNum;
		this.bankTitle = bankTitle;
		this.ifscCode = ifscCode;
	}

	public String getAccNum() {
		return accNum;
	}

	public void setAccNum(String accNum) {
		this.accNum = accNum;
	}

	public String getBankTitle() {
		return bankTitle;
	}

	public void setBankTitle(String bankTitle) {
		this.bankTitle = bankTitle;
	}

	public String getIfscCode() {
		return ifscCode;
	}

	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}

	public AssociateEmployee getAccHolder() {
		return accHolder;
	}

	public void setAccHolder(AssociateEmployee accHolder) {
		this.accHolder = accHolder;
	}
	
	
}
