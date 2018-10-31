package com.verizon.eda.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.verizon.eda.Servce.EmployeeService;
import com.verizon.eda.model.Employee;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService empServ;

	@GetMapping({ "", "/", "/home" })
	public ModelAndView defaultHomeAction() {
		return new ModelAndView("homescreen", "employees", empServ.getAllEmployees());
	}

	@GetMapping("/addEmployee")
	public ModelAndView addEmployeeAction() {

		ModelAndView mv = new ModelAndView();

		mv.setViewName("addEmployeeForm");
		mv.addObject("employee", new Employee());
		mv.addObject("posibDepts", new String[] { "Developer", "HR", "Testing", "Finance" });

		return mv;
	}

	@PostMapping("/saveEmployee")
	public String saveEmployeeAction(@ModelAttribute Employee emp) {
		if (empServ.getEmployeeById(emp.getEmpId()) == null)
			empServ.addEmployee(emp);
		else
			empServ.updateEmployee(emp);
		return "redirect:/home";
	}

	@GetMapping("/editEmployee")
	public ModelAndView editBookAction(@RequestParam("employeeId") int id) {
		ModelAndView mv = new ModelAndView();

		mv.setViewName("addEmployeeForm");
		mv.addObject("employee", empServ.getEmployeeById(id));
		mv.addObject("posibDepts", new String[] { "Developer", "HR", "Testing", "Finance" });

		return mv;
	}

	@GetMapping("/delEmployee")
	public String deleteBookAction(@RequestParam("employeeId") int id) {
		empServ.deleteEmployeeById(id);
		return "redirect:/home";
	}

}
