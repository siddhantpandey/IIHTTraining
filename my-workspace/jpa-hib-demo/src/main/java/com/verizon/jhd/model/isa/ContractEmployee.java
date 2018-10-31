package com.verizon.jhd.model.isa;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
//same table will be used need not mention table name
@Entity
//@DiscriminatorValue("cemp")

//@Table(name="CEmps")
@Table(name="CEmpsOnly")
public class ContractEmployee extends Employee{

	@Column(name="cdur")
	private int contractDuration;
	
	public ContractEmployee() {
		
	}

	public ContractEmployee(int empId, String ename, double basic, int contractDuration) {
		super(empId, ename, basic);
		
		this.contractDuration = contractDuration;
		
	}

	public int getContractDuration() {
		return contractDuration;
	}

	public void setContractDuration(int contractDuration) {
		this.contractDuration = contractDuration;
	}
	
	
}
