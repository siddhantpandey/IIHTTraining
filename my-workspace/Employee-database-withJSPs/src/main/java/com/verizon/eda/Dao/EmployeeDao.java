package com.verizon.eda.Dao;

import java.util.List;

import com.verizon.eda.model.Employee;

public interface EmployeeDao {
	
	Employee addEmployee(Employee Employee);
	Employee updateEmployee(Employee Employee);
	Employee getEmployeeById(int empId);
	boolean deleteEmployeeById(int empId);
	List<Employee> getAllEmployees();
}
