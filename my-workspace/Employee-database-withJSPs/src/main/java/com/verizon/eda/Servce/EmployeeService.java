package com.verizon.eda.Servce;

import java.util.List;

import com.verizon.eda.model.Employee;

public interface EmployeeService {
	Employee addEmployee(Employee Employee);
	Employee updateEmployee(Employee Employee);
	Employee getEmployeeById(int empId);
	boolean deleteEmployeeById(int empId);
	List<Employee> getAllEmployees();
}
