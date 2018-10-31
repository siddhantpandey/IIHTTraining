package com.verizon.eda.model;

public class Employee {
	private int empId;
	private String name;
	private double basic;
	private double hra;
	private String dept;
	
	
	public Employee() {}
	
	public Employee(int empId, String name, double basic, double hra, String dept) {
		super();
		this.empId = empId;
		this.name = name;
		this.basic = basic;
		this.hra = hra;
		this.dept = dept;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getBasic() {
		return basic;
	}
	public void setBasic(double basic) {
		this.basic = basic;
	}
	public double getHra() {
		return hra;
	}
	public void setHra(double hra) {
		this.hra = hra;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	} 
}
