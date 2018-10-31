package com.verizon.sta.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.verizon.sta.model.Customer;
@Repository
public interface CustomerDao extends JpaRepository<Customer, Integer> {

}
