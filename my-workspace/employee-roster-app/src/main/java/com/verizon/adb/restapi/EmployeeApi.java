package com.verizon.adb.restapi;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.verizon.adb.model.Employee;
import com.verizon.adb.service.EmployeeService;

@RestController
@CrossOrigin
@RequestMapping("/employees")
public class EmployeeApi {

	@Autowired
	private EmployeeService service;

	@GetMapping
	public ResponseEntity<List<Employee>> getAllEmployees() {
		return new ResponseEntity<>(service.getAllEmployees(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") long employeeId) {
		ResponseEntity<Employee> resp;
		Employee c = service.getEmployeeById(employeeId);
		if (c == null)
			resp = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		else
			resp = new ResponseEntity<>(c, HttpStatus.OK);
		return resp;
	}

	@GetMapping("/{field}/{srhValue}")
	public ResponseEntity<List<Employee>> getAllEmployees(@PathVariable("field") String fieldBy,
			@PathVariable("srhValue") String searchValue) {

		ResponseEntity<List<Employee>> resp;

		switch (fieldBy) {
		case "mobileNumber":
			Employee cByMobNum = service.findByMobileNumber(searchValue);
			if (cByMobNum != null) {
				resp = new ResponseEntity<>(Collections.singletonList(cByMobNum), HttpStatus.OK);
			} else {
				resp = new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			break;
		case "emailId":
			Employee cByEmail = service.findByEmailId(searchValue);
			if (cByEmail != null) {
				resp = new ResponseEntity<>(Collections.singletonList(cByEmail), HttpStatus.OK);
			} else {
				resp = new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			break;
		case "lastName":
			List<Employee> results = service.findAllByLastName(searchValue);
			if (results != null && results.size() != 0) {
				resp = new ResponseEntity<>(results, HttpStatus.OK);
			} else {
				resp = new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			break;
		default:
			resp = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			break;
		}

		return resp;
	}

	@PostMapping
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
		ResponseEntity<Employee> resp = null;

		if (service.existsByEmailId(employee.getEmailId())) {
			resp = new ResponseEntity<Employee>(HttpStatus.ALREADY_REPORTED);
		}

		if (service.existsByMobileNumber(employee.getMobileNumber())) {
			resp = new ResponseEntity<Employee>(HttpStatus.ALREADY_REPORTED);
		}

		if (resp == null) {
			Employee c = service.addEmployee(employee);
			if (c == null)
				resp = new ResponseEntity<Employee>(HttpStatus.BAD_REQUEST);
			else
				resp = new ResponseEntity<Employee>(c, HttpStatus.OK);
		}
		return resp;
	}

	@PutMapping
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
		ResponseEntity<Employee> resp = null;

		Employee c = service.getEmployeeById(employee.getEmployeeId());
		if (!employee.getEmailId().equals(c.getEmailId())) {
			if (service.existsByEmailId(employee.getEmailId())) {
				resp = new ResponseEntity<Employee>(HttpStatus.ALREADY_REPORTED);
			}
		}

		if (!employee.getMobileNumber().equals(c.getMobileNumber())) {
			if (service.existsByMobileNumber(employee.getMobileNumber())) {
				resp = new ResponseEntity<Employee>(HttpStatus.ALREADY_REPORTED);
			}
		}

		if (resp == null) {
			c = service.updateEmployee(employee);
			if (c == null)
				resp = new ResponseEntity<Employee>(HttpStatus.BAD_REQUEST);
			else
				resp = new ResponseEntity<Employee>(c, HttpStatus.OK);
		}
		return resp;
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteEmployee(@PathVariable("id") long employeeId) {
		ResponseEntity<Void> resp = null;

		if (service.deleteEmployee(employeeId))
			resp = new ResponseEntity<>(HttpStatus.OK);
		else
			resp = new ResponseEntity<>(HttpStatus.NOT_FOUND);

		return resp;
	}
}
