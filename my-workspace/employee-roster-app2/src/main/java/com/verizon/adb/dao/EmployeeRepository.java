package com.verizon.adb.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.verizon.adb.model.Employee;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, Long>{

	boolean existsByMobileNumber(String mobileNumber);
	boolean existsByEmailId(String emailId);
	
	Employee findByMobileNumber(String mobileNumber);
	Employee findByEmailId(String emailId);
	
	List<Employee> findAllByLastName(String lastName);
	
}
