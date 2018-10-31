package com.verizon.crimreg.dao;

import java.util.Collections;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.verizon.crimreg.exception.CustomExceptionTranslator;
import com.verizon.crimreg.model.Criminal;


@Repository
public class CriminalDAOImpl implements CriminalDAO {

	private NamedParameterJdbcTemplate jtmp;
	@Autowired
	CriminalRowMapper rowMapper;
	
	@Autowired
	public CriminalDAOImpl(DataSource ds,CustomExceptionTranslator expt ) {
		this.jtmp = new NamedParameterJdbcTemplate(ds);
	}
	
	@Override
	public void addCriminal(Criminal criminal) {
		jtmp.update(IQueryMapper.INS_ITEM_QRY,
				new BeanPropertySqlParameterSource(criminal)
				);

	}

	@Override
	public void removeCriminal(int iCode) {
		jtmp.update(IQueryMapper.DEL_ITEM_QRY,Collections.singletonMap("cId",iCode));

	}

	@Override
	public void updateCriminal(Criminal criminal) {
		jtmp.update(IQueryMapper.UPD_ITEM_QRY,
				new BeanPropertySqlParameterSource(criminal)
				);

	}

	@Override
	public Criminal getCriminal(int iCode) {
		List<Criminal> criminals =
				jtmp.query(IQueryMapper.GET_ITEM_QRY,Collections.singletonMap("cId",iCode),rowMapper);
				return criminals!=null && criminals.size()>0?criminals.get(0):null;
	}

	@Override
	public List<Criminal> getCriminals() {
		return jtmp.query(IQueryMapper.GET_ALL_ITEM_QRY,
				rowMapper);
	}

}
