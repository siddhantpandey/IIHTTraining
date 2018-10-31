package com.verizon.sdmongo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.verizon.sdmongo.dao.EmployeeMongoRepository;
import com.verizon.sdmongo.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeMongoRepository employeeDAO;
	@Override
	public void addEmployee(Employee employee) {
		employeeDAO.insert(employee);
		
	}

	@Override
	public void removeEmployee(int empId) {
		employeeDAO.deleteById(empId);
		
	}

	@Override
	public void updateEmployee(Employee employee) {
		employeeDAO.save(employee);
		
	}

	@Override
	public Employee getEmployee(int empId) {
		Optional<Employee> opt = employeeDAO.findById(empId);
		return opt.isPresent()?opt.get():null;
	}

	@Override
	public List<Employee> getEmployees() {
		return employeeDAO.findAll();
	}

	@Override
	public boolean exists(int empId) {
		
		return employeeDAO.existsById(empId);
	}

}
