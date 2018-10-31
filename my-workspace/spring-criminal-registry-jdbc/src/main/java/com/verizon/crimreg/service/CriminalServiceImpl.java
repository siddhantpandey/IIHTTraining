package com.verizon.crimreg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.verizon.crimreg.dao.CriminalDAO;
import com.verizon.crimreg.model.Criminal;

@Service
public class CriminalServiceImpl implements CriminalService {

	@Autowired
	private CriminalDAO criminalDAO;
	@Override
	public void addCriminal(Criminal criminal) {
		criminalDAO.addCriminal(criminal);
		
	}

	@Override
	public void removeCriminal(int iCode) {
		criminalDAO.removeCriminal(iCode);
		
	}

	@Override
	public void updateCriminal(Criminal criminal) {
		criminalDAO.updateCriminal(criminal);
		
	}

	@Override
	public Criminal getCriminal(int iCode) {
		
		return criminalDAO.getCriminal(iCode);
	}

	@Override
	public List<Criminal> getCriminals() {
		
		return criminalDAO.getCriminals();
	}

	@Override
	public boolean exists(int icode) {
		return criminalDAO.getCriminal(icode)!=null;
	}

}
