package com.verizon.sdmongo.service;

import java.util.List;

import com.verizon.sdmongo.model.Employee;



public interface EmployeeService {
	public void addEmployee(Employee employee);

	public void removeEmployee(int empId);

	public void updateEmployee(Employee employee);

	public Employee getEmployee(int empId);

	public List<Employee> getEmployees();
	
	public boolean exists(int empId);
}
