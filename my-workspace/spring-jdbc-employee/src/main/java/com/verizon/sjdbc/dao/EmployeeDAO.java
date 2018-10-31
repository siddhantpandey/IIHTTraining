package com.verizon.sjdbc.dao;

import java.util.List;

import com.verizon.sjdbc.model.Employee;

public interface EmployeeDAO {

	public void addEmployee(Employee employee);
	
	public void removeEmployee(int iCode);
	
	public void updateEmployee(Employee employee);
	
	public Employee getEmployee(int iCode);
	
	public List<Employee> getEmployees();
}
