package com.verizon.sjdbc.dao;

public interface IQueryMapper {

	public static final String INS_ITEM_QRY=
			"INSERT INTO employees VALUES(?,?,?)";
	public static final String UPD_ITEM_QRY=
			"UPDATE employees SET empname=?, empbasic=? WHERE empid=?";
	public static final String DEL_ITEM_QRY=
			"DELETE FROM employees WHERE empid=?";
	public static final String GET_ITEM_QRY=
			"SELECT * FROM employees WHERE empid=?";
	public static final String GET_ALL_ITEM_QRY=
			"SELECT * FROM employees";
}
