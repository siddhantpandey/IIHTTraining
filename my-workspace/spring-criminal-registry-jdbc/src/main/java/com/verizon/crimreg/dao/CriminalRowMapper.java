package com.verizon.crimreg.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import org.springframework.stereotype.Component;

import com.verizon.crimreg.model.Criminal;

@Component
public class CriminalRowMapper implements RowMapper<Criminal>{

	@Override
	public Criminal mapRow(ResultSet rs, int rowNum) throws SQLException {
		Criminal criminal = new Criminal();
		
		criminal.setcId(rs.getInt(1));
		criminal.setcName(rs.getString(2));
		criminal.setcNature(rs.getString(3));
		criminal.setcSentenceDur(rs.getInt(4));
		
		return criminal;
		
	}

}
