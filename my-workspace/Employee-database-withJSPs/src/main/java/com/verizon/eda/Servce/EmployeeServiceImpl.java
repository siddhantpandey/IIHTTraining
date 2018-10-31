package com.verizon.eda.Servce;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.verizon.eda.Dao.EmployeeDao;
import com.verizon.eda.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao employeedao;
	
	@Override
	public Employee addEmployee(Employee Employee) {
		return employeedao.addEmployee(Employee);
	}

	@Override
	public Employee updateEmployee(Employee Employee) {
		return employeedao.updateEmployee(Employee);
	}

	@Override
	public Employee getEmployeeById(int empId) {
		return employeedao.getEmployeeById(empId);
	}

	@Override
	public boolean deleteEmployeeById(int empId) {
		return employeedao.deleteEmployeeById(empId);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return employeedao.getAllEmployees();
	}

}
