package com.verizon.adb.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.verizon.adb.model.Employee;
import com.verizon.adb.model.Gender;
import com.verizon.adb.service.EmployeeService;

@Controller
@RequestMapping("/searchEmployee")
public class SearchEmployeeController {
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping
	public String handleSearchEmployee() {
		return "searchPage";
	}
	
	@PostMapping
	public ModelAndView handleDoSearchEmployee(@RequestParam("srhValue") String searchValue,
			@RequestParam("field") String byField) {
		
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("searchPage");
		mv.addObject("pageTitle","Results For "+byField+" = "+searchValue);
		
		switch(byField) {
		
			case "mobile" :
				mv.addObject("result",employeeService.findByMobileNumber(searchValue));
				break;
			case "email" :
				mv.addObject("result",employeeService.findByEmailId(searchValue));
				break;
			case "employeeId" :
				mv.addObject("result",employeeService.getEmployeeById(Integer.parseInt(searchValue)));
				break;
		}
		//mv.setViewName("redirect:/searchEmployee");
		return mv;
	}
	
	
	
}
