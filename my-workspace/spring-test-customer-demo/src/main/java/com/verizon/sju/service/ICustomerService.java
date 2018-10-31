package com.verizon.sju.service;

import java.util.List;

import com.verizon.sju.model.Customer;

public interface ICustomerService {
	public Customer addCustomer(Customer cust);

	public Customer updateCustomer(Customer cust);

	public void deleteCustomer(Long custId);

	public Customer getCustomerById(Long custId);

	public List<Customer> listCustomers();
}
