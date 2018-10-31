package com.verizon.crimreg.dao;


public interface IQueryMapper {

	public static final String INS_ITEM_QRY=
			"INSERT INTO criminals VALUES(:cId,:cName,:cNature,:cSentenceDur)";
	public static final String UPD_ITEM_QRY=
			"UPDATE criminals SET cname=:cName, cnature=:cNature, csentencedur=:cSentenceDur WHERE cid=:cId";
	public static final String DEL_ITEM_QRY=
			"DELETE FROM criminals WHERE cid=:cId";
	public static final String GET_ITEM_QRY=
			"SELECT * FROM criminals WHERE cid=:cId";
	public static final String GET_ALL_ITEM_QRY=
			"SELECT * FROM criminals";
}
