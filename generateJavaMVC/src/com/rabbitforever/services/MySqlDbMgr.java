package com.rabbitforever.services;

import java.util.List;

import com.rabbitforever.daos.MySqlDbDao;
import com.rabbitforever.vos.MetaDataField;

public class MySqlDbMgr {
	private MySqlDbDao mysqlDbDao;
	public MySqlDbMgr()
	{
		mysqlDbDao = new MySqlDbDao();
	} // end constructor
	public List<MetaDataField> getMetaDataList(String _database)
	{
		return mysqlDbDao.getMetaDataList(_database);
	} // end getMetaData()
} // end class
