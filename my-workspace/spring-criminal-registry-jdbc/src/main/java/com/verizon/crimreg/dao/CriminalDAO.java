package com.verizon.crimreg.dao;

import java.util.List;

import com.verizon.crimreg.model.Criminal;

public interface CriminalDAO {
public void addCriminal(Criminal item);
	
	public void removeCriminal(int iCode);
	
	public void updateCriminal(Criminal item);
	
	public Criminal getCriminal(int iCode);
	
	public List<Criminal> getCriminals();
}
