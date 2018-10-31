package com.verizon.sdmongo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="employees")
public class Employee {

	@Id
	private int empId;
	private String empName;
	private double empBasic;
	public Employee() {
		super();
	}
	public Employee(int empId, String empName, double empBasic) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empBasic = empBasic;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public double getEmpBasic() {
		return empBasic;
	}
	public void setEmpBasic(double empBasic) {
		this.empBasic = empBasic;
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empBasic=" + empBasic + "]";
	}
	
	
}
