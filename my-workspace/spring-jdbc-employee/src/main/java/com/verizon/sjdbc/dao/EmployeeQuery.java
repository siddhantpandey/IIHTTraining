package com.verizon.sjdbc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.object.MappingSqlQuery;
import org.springframework.stereotype.Component;

import com.verizon.sjdbc.model.Employee;


public class EmployeeQuery extends MappingSqlQuery<Employee> {

	
	
	public EmployeeQuery() {
		super();
	}
	
	public EmployeeQuery(DataSource ds, String sql) {
		super(ds, sql);
	}

	@Override
	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		Employee employee = new Employee();
		
		employee.setempId(rs.getInt(1));
		employee.setempName(rs.getString(2));
		employee.setempBasic(rs.getDouble(3));
		return employee;
	}

}
