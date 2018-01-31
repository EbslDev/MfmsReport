package com.rabbitforever.services;

import java.util.List;

import com.rabbitforever.daos.OracleDbDao;
import com.rabbitforever.vos.MetaDataField;

public class OracleDbMgr {
	private OracleDbDao oracleDbDao;
	public OracleDbMgr()
	{
		oracleDbDao = new OracleDbDao();
	} // end constructor
	public List<MetaDataField> getMetaDataList(String _database)
	{
		return oracleDbDao.getMetaDataList(_database);
	} // end getMetaData()
} // end class
