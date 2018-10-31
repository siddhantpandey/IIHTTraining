package com.verizon.sjdbc.model;

public class Employee {

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

	public int getempId() {
		return empId;
	}

	public void setempId(int empId) {
		this.empId = empId;
	}

	public String getempName() {
		return empName;
	}

	public void setempName(String empName) {
		this.empName = empName;
	}

	public double getempBasic() {
		return empBasic;
	}

	public void setempBasic(double empBasic) {
		this.empBasic = empBasic;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empBasic=" + empBasic + "]";
	}
	
	
}
