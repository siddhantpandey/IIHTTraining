package com.verizon.sjdbc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.verizon.sjdbc.dao.EmployeeDAO;
import com.verizon.sjdbc.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeDAO employeeDAO;
	@Override
	public void addEmployee(Employee employee) {
		employeeDAO.addEmployee(employee);
		
	}

	@Override
	public void removeEmployee(int iCode) {
		employeeDAO.removeEmployee(iCode);
		
	}

	@Override
	public void updateEmployee(Employee employee) {
		employeeDAO.updateEmployee(employee);
		
	}

	@Override
	public Employee getEmployee(int iCode) {
		
		return employeeDAO.getEmployee(iCode);
	}

	@Override
	public List<Employee> getEmployees() {
		
		return employeeDAO.getEmployees();
	}

	@Override
	public boolean exists(int icode) {
		return employeeDAO.getEmployee(icode)!=null;
	}

}
