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
import com.verizon.sjdbc.model.Item;

@Repository
public class ItemDAOImpl implements ItemDAO {

	private SqlUpdate insOperator;
	private SqlUpdate updOperator;
	private SqlUpdate delOperator;
	private MappingSqlQuery<Item> getItemOperator;
	private MappingSqlQuery<Item> getAllItemOperators;
	/*
	@Autowired
	private RowMapper rowMapper;
	*/
	
	@Autowired
	public ItemDAOImpl(DataSource ds) {
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
		/*this.getItemOperator = new MappingSqlQuery<Item>(ds,IQueryMapper.GET_ITEM_QRY) {

			@Override
			protected Item mapRow(ResultSet rs, int rowNum) throws SQLException {
				return rowMapper.mapRow(rs, rowNum);
			}
			
		};*/
		this.getItemOperator = new ItemQuery(ds,IQueryMapper.GET_ITEM_QRY);
		this.getItemOperator.declareParameter(param1);
		this.getItemOperator.compile();
		
		this.getAllItemOperators = new ItemQuery(ds,IQueryMapper.GET_ALL_ITEM_QRY);
		this.getAllItemOperators.compile();
		
		
		
	
	}
	
	@Override
	public void addItem(Item item) {
		this.insOperator.update(item.getiCode(),item.getiName(),item.getiPrice());

	}

	@Override
	public void removeItem(int iCode) {
		this.delOperator.update(iCode);

	}

	@Override
	public void updateItem(Item item) {
		this.updOperator.update(item.getiName(),item.getiPrice(),item.getiCode());

	}

	@Override
	public Item getItem(int iCode) {
		List<Item> items =
				this.getItemOperator.execute(iCode);
		return items!=null && items.size()>0?items.get(0):null;
	}

	@Override
	public List<Item> getItems() {
		
			return this.getAllItemOperators.execute();
		
		
	}

}
