package com.verizon.sta.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.verizon.sta.dao.CustomerDao;
import com.verizon.sta.model.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerDao custDao;

	@Override
	public List<Customer> getAllCustomers() {
		return custDao.findAll();
	}

}
