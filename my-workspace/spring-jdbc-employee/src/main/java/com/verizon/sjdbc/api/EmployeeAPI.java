package com.verizon.sjdbc.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mysql.fabric.Response;
import com.verizon.sjdbc.model.Employee;
import com.verizon.sjdbc.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeAPI {

	@Autowired
	EmployeeService service;

	@GetMapping
	public ResponseEntity<List<Employee>> getAllEmployees() {
		ResponseEntity<List<Employee>> resp = null;
		List<Employee> employees = service.getEmployees();
		if (employees != null && employees.size() > 0)
			resp = new ResponseEntity<List<Employee>>(employees, HttpStatus.OK);
		else
			resp = new ResponseEntity<List<Employee>>(HttpStatus.NOT_FOUND);
		return resp;
	}

	@GetMapping("/{icode}")
	public ResponseEntity<Employee> getEmployee(@PathVariable("icode") int icode) {
		ResponseEntity<Employee> resp = null;
		Employee employee = service.getEmployee(icode);
		if (employee != null)
			resp = new ResponseEntity<Employee>(employee, HttpStatus.OK);
		else
			resp = new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
		return resp;
	}

	@PostMapping
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
		ResponseEntity<Employee> resp = null;

		if (employee != null && !service.exists(employee.getempId())) {
			service.addEmployee(employee);
			resp = new ResponseEntity<Employee>(employee, HttpStatus.OK);

		} else
			resp = new ResponseEntity<Employee>(HttpStatus.CONFLICT);
		return resp;
	}

	@PutMapping
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
		ResponseEntity<Employee> resp = null;

		if (employee != null && service.exists(employee.getempId())) {
			service.updateEmployee(employee);
			resp = new ResponseEntity<Employee>(employee, HttpStatus.OK);
		} else
			resp = new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
		return resp;
	}

	@DeleteMapping("/{icode}")
	public ResponseEntity<Void> delEmployee(@PathVariable("icode") int icode) {
		ResponseEntity<Void> resp = null;
		if (service.exists(icode)) {
			service.removeEmployee(icode);
			resp = new ResponseEntity<>(HttpStatus.OK);

		} else
			resp = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		return resp;
	}
}
