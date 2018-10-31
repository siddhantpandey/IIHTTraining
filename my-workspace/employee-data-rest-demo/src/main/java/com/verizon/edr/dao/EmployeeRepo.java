package com.verizon.edr.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.verizon.edr.model.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long>{

	
}
