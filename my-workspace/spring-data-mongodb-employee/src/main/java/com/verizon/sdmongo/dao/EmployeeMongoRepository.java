package com.verizon.sdmongo.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.verizon.sdmongo.model.Employee;

public interface EmployeeMongoRepository extends MongoRepository<Employee, Integer>{

}
