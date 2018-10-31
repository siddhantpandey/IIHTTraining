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
@RequestMapping("/deleteEmployee")
public class DeleteEmployeeController {
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping
	public ModelAndView handleNewEmployee() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("deleteEmployeePage");
		mv.addObject("employee",new Employee());
		//mv.addObject("genders",Gender.values());
		return mv;
	}
	//spring side validation
	@PostMapping
	public ModelAndView handleAddEmployee(
			@ModelAttribute("employeeId") @Valid long employeeId,
			BindingResult validationResults) {
		ModelAndView mv = new ModelAndView();
		
		if(employeeService.getEmployeeById(employeeId)==null) {
			validationResults.rejectValue("employeeId","error.employee","Employee Does Not Exist");
		}
		
		/*if(!employeeService.existsByMobileNumber(employee.getMobileNumber())) {
			//validationResults.addError(new ObjectError("mobileNumber","Mobile Number already exists"));
			validationResults.rejectValue("mobileNumber","error.employee","Employee Doesn't Exist");
		}*/
		
		if(validationResults.hasErrors()) {
			mv.setViewName("deleteEmployeePage");
			mv.addObject("employeeId",employeeId);
			//mv.addObject("genders",Gender.values());
		}else {
			employeeService.deleteEmployee(employeeId);
			mv.setViewName("redirect:/employeeList");
		}
		
		return mv;
	}
	
	
	
}
