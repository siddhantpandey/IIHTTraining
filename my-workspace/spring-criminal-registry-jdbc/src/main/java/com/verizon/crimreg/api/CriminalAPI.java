package com.verizon.crimreg.api;


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
import com.verizon.crimreg.model.Criminal;
import com.verizon.crimreg.service.CriminalService;



@RestController
@RequestMapping("/criminals")
public class CriminalAPI {

	@Autowired
	CriminalService service;

	@GetMapping
	public ResponseEntity<List<Criminal>> getAllCriminals() {
		ResponseEntity<List<Criminal>> resp = null;
		List<Criminal> criminals = service.getCriminals();
		if (criminals != null && criminals.size() > 0)
			resp = new ResponseEntity<List<Criminal>>(criminals, HttpStatus.OK);
		else
			resp = new ResponseEntity<List<Criminal>>(HttpStatus.NOT_FOUND);
		return resp;
	}

	@GetMapping("/{icode}")
	public ResponseEntity<Criminal> getCriminal(@PathVariable("icode") int icode) {
		ResponseEntity<Criminal> resp = null;
		Criminal criminal = service.getCriminal(icode);
		if (criminal != null)
			resp = new ResponseEntity<Criminal>(criminal, HttpStatus.OK);
		else
			resp = new ResponseEntity<Criminal>(HttpStatus.NOT_FOUND);
		return resp;
	}

	@PostMapping
	public ResponseEntity<Criminal> addCriminal(@RequestBody Criminal criminal) {
		ResponseEntity<Criminal> resp = null;

		if (criminal != null && !service.exists(criminal.getcId())) {
			service.addCriminal(criminal);
			resp = new ResponseEntity<Criminal>(criminal, HttpStatus.OK);

		} else
			resp = new ResponseEntity<Criminal>(HttpStatus.CONFLICT);
		return resp;
	}

	@PutMapping
	public ResponseEntity<Criminal> updateItem(@RequestBody Criminal criminal) {
		ResponseEntity<Criminal> resp = null;

		if (criminal != null && service.exists(criminal.getcId())) {
			service.updateCriminal(criminal);
			resp = new ResponseEntity<Criminal>(criminal, HttpStatus.OK);
		} else
			resp = new ResponseEntity<Criminal>(HttpStatus.NOT_FOUND);
		return resp;
	}

	@DeleteMapping("/{icode}")
	public ResponseEntity<Void> delCriminal(@PathVariable("icode") int icode) {
		ResponseEntity<Void> resp = null;
		if (service.exists(icode)) {
			service.removeCriminal(icode);
			resp = new ResponseEntity<>(HttpStatus.OK);

		} else
			resp = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		return resp;
	}
}
