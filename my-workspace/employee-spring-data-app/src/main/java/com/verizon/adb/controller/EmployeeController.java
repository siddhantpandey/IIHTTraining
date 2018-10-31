package com.verizon.adb.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.verizon.adb.model.Employee;
import com.verizon.adb.model.Gender;
import com.verizon.adb.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/employeeList")
	public ModelAndView handleEmployeeList() {
		return new ModelAndView("elistPage","employees",employeeService.getAllEmployees());
	}
	
	
	
	
	
	
	@GetMapping("/login")
	public ModelAndView showLoginPage() {
		return new ModelAndView("loginPage");
	}
	
}
