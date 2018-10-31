package com.verizon.sjdbc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import javax.sql.DataSource;
import javax.swing.tree.RowMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.MappingSqlQuery;
import org.springframework.jdbc.object.SqlUpdate;
import org.springframework.stereotype.Repository;

import com.verizon.sjdbc.exception.CustomExceptionTranslator;
import com.verizon.sjdbc.model.Employee;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	private SqlUpdate insOperator;
	private SqlUpdate updOperator;
	private SqlUpdate delOperator;
	private MappingSqlQuery<Employee> getEmployeeOperator;
	private MappingSqlQuery<Employee> getAllEmployeeOperators;
	/*
	@Autowired
	private RowMapper rowMapper;
	*/
	
	@Autowired
	public EmployeeDAOImpl(DataSource ds) {
		this.insOperator = new SqlUpdate(ds,IQueryMapper.INS_ITEM_QRY);
		this.updOperator = new SqlUpdate(ds,IQueryMapper.UPD_ITEM_QRY);
		this.delOperator = new SqlUpdate(ds,IQueryMapper.DEL_ITEM_QRY);
		
		SqlParameter param1 = new SqlParameter("icode",Types.INTEGER);
		SqlParameter param2 = new SqlParameter("iname",Types.VARCHAR);
		SqlParameter param3 = new SqlParameter("iprice",Types.DECIMAL);
		
		insOperator.declareParameter(param1);
		insOperator.declareParameter(param2);
		insOperator.declareParameter(param3);
		insOperator.compile();
		
		updOperator.declareParameter(param2);
		updOperator.declareParameter(param3);
		updOperator.declareParameter(param1);
		updOperator.compile();
		
		delOperator.declareParameter(param1);
		delOperator.compile();
		
		//
		/*this.getEmployeeOperator = new MappingSqlQuery<Employee>(ds,IQueryMapper.GET_ITEM_QRY) {

			@Override
			protected Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
				return rowMapper.mapRow(rs, rowNum);
			}
			
		};*/
		this.getEmployeeOperator = new EmployeeQuery(ds,IQueryMapper.GET_ITEM_QRY);
		this.getEmployeeOperator.declareParameter(param1);
		this.getEmployeeOperator.compile();
		
		this.getAllEmployeeOperators = new EmployeeQuery(ds,IQueryMapper.GET_ALL_ITEM_QRY);
		this.getAllEmployeeOperators.compile();
		
		
		
	
	}
	
	@Override
	public void addEmployee(Employee employee) {
		this.insOperator.update(employee.getempId(),employee.getempName(),employee.getempBasic());

	}

	@Override
	public void removeEmployee(int empId) {
		this.delOperator.update(empId);

	}

	@Override
	public void updateEmployee(Employee employee) {
		this.updOperator.update(employee.getempName(),employee.getempBasic(),employee.getempId());

	}

	@Override
	public Employee getEmployee(int empId) {
		List<Employee> employees =
				this.getEmployeeOperator.execute(empId);
		return employees!=null && employees.size()>0?employees.get(0):null;
	}

	@Override
	public List<Employee> getEmployees() {
		
			return this.getAllEmployeeOperators.execute();
		
		
	}

}
