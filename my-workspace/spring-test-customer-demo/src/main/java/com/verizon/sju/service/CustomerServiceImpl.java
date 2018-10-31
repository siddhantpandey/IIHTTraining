package com.verizon.sju.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.verizon.sju.dao.ICustomerRepository;
import com.verizon.sju.model.Customer;

@Service
public class CustomerServiceImpl implements ICustomerService {

	@Autowired
	private ICustomerRepository custRepo;

	@Transactional
	@Override
	public Customer addCustomer(Customer cust) {
		return custRepo.save(cust);
	}

	@Transactional
	@Override
	public Customer updateCustomer(Customer cust) {
		return custRepo.save(cust);
	}

	@Transactional
	@Override
	public void deleteCustomer(Long custId) {

		custRepo.deleteById(custId);
	}

	@Override
	public Customer getCustomerById(Long custId) {
		Optional<Customer> optEmp = custRepo.findById(custId);
		Customer cust = optEmp.isPresent() ? optEmp.get() : null;
		return cust;
	}

	@Override
	public List<Customer> listCustomers() {
		return custRepo.findAll();
	}

}
