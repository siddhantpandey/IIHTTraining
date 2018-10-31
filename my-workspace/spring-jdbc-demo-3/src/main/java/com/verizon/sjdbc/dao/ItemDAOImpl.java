package com.verizon.sjdbc.dao;

import java.util.Collections;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.verizon.sjdbc.exception.CustomExceptionTranslator;
import com.verizon.sjdbc.model.Item;

@Repository
public class ItemDAOImpl extends NamedParameterJdbcDaoSupport implements ItemDAO {

	
	@Autowired
	private ItemRowMapper rowMapper;
	@Autowired
	private DataSource dataSource;
	@PostConstruct
	private void initialize() {
		setDataSource(dataSource);
	}
	
	public ItemDAOImpl( ) {
		
	}
	
	@Override
	public void addItem(Item item) {
		
		getNamedParameterJdbcTemplate().update(IQueryMapper.INS_ITEM_QRY,
				new BeanPropertySqlParameterSource(item)
				);

	}

	@Override
	public void removeItem(int iCode) {
		getNamedParameterJdbcTemplate().update(IQueryMapper.DEL_ITEM_QRY,Collections.singletonMap("iCode",iCode));

	}

	@Override
	public void updateItem(Item item) {
		getNamedParameterJdbcTemplate().update(IQueryMapper.UPD_ITEM_QRY,
				new BeanPropertySqlParameterSource(item)
				);

	}

	@Override
	public Item getItem(int iCode) {
		List<Item> items =
				getNamedParameterJdbcTemplate().query(IQueryMapper.GET_ITEM_QRY,Collections.singletonMap("iCode",iCode),rowMapper);
		return items!=null && items.size()>0?items.get(0):null;
	}

	@Override
	public List<Item> getItems() {
		
			return getNamedParameterJdbcTemplate().query(IQueryMapper.GET_ALL_ITEM_QRY,
					rowMapper);
		
		
	}

}
