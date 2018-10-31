package com.verizon.eda.Dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.stereotype.Repository;

import com.verizon.eda.model.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	Map<Integer,Employee>employees;
	
	public EmployeeDaoImpl() {
		employees=new TreeMap<>();
		
		employees.put(2607167, new Employee(2607167,"Popo",2312432,1222,"Testing"));
		employees.put(2607168, new Employee(2607168,"Lolo",223213,1342,"HR"));
		employees.put(2607169, new Employee(2607169,"Momo",41212432,12,"Finance"));
		employees.put(2607170, new Employee(2607170,"HoHo",344432,652,"Developer"));
	}
	
	@Override
	public Employee addEmployee(Employee Employee) {
		return employees.put(Employee.getEmpId(), Employee);
	}

	@Override
	public Employee updateEmployee(Employee Employee) {
		return employees.replace(Employee.getEmpId(),Employee);
	}

	@Override
	public Employee getEmployeeById(int empId) {
		return employees.get(empId);
	}

	@Override
	public boolean deleteEmployeeById(int empId) {
		boolean isDeleted=false;
		if(employees.containsKey(empId)) {
			employees.remove(empId);
			isDeleted=true;
		}
		return isDeleted;
	}

	@Override
	public List<Employee> getAllEmployees() {
		return new ArrayList<Employee>(employees.values());
	}

}
