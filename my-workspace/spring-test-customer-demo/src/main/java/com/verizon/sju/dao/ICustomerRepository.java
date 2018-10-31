package com.verizon.sju.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.verizon.sju.model.Customer;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Long> {

}
