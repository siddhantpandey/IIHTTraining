package com.verizon.adb.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.verizon.adb.model.Employee;
import com.verizon.adb.model.Gender;
import com.verizon.adb.service.EmployeeService;

@Controller
@RequestMapping("/addEmployee")
public class AddEmployeeController {
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping
	public ModelAndView handleNewEmployee() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("addEmployeePage");
		mv.addObject("employee",new Employee());
		mv.addObject("genders",Gender.values());
		return mv;
	}
	//spring side validation
	@PostMapping
	public ModelAndView handleAddEmployee(
			@ModelAttribute("employee") @Valid Employee employee,
			BindingResult validationResults) {
		ModelAndView mv = new ModelAndView();
		
		if(employeeService.existsByEmailId(employee.getEmailId())) {
			//validationResults.addError(new ObjectError("emailId","Email Id already exists"));
			validationResults.rejectValue("emailId","error.employee","Email Id already exists");
		}
		
		if(employeeService.existsByMobileNumber(employee.getMobileNumber())) {
			//validationResults.addError(new ObjectError("mobileNumber","Mobile Number already exists"));
			validationResults.rejectValue("mobileNumber","error.employee","Mobile Number already exists");
		}
		
		if(validationResults.hasErrors()) {
			mv.setViewName("addEmployeePage");
			mv.addObject("employee",employee);
			mv.addObject("genders",Gender.values());
		}else {
			employeeService.addEmployee(employee);
			mv.setViewName("redirect:/employeeList");
		}
		
		return mv;
	}
	
	
	
}
