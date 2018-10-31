package com.verizon.crimreg.service;

import java.util.List;

import com.verizon.crimreg.model.Criminal;


public interface CriminalService {

	public void addCriminal(Criminal criminal);

	public void removeCriminal(int iCode);

	public void updateCriminal(Criminal criminal);

	public Criminal getCriminal(int iCode);

	public List<Criminal> getCriminals();
	
	public boolean exists(int icode);
}
