package com.verizon.sju.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.verizon.sju.model.Customer;
import com.verizon.sju.service.ICustomerService;

@Controller
public class CustomerController {

	
	
	@Autowired
	private ICustomerService custService;

	
	
	@GetMapping("/listEmps")
	public ModelAndView listCustomers() {
		return new ModelAndView("custList", "custs", custService.listCustomers());
	}

	@GetMapping("/addEmp")
	public ModelAndView addCustomers() {
		return new ModelAndView("addEmp", "cust", new Customer());
	}

	@PostMapping("/addEmp")
	public String doAddCustomers(@ModelAttribute Customer cust) {
		custService.addCustomer(cust);
		return "redirect:/listEmps";
	}

}
