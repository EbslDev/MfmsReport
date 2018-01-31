package com.rabbitforever.generateJavaMVC.commons;

import com.rabbitforever.generateJavaMVC.policies.SystemParams;

public class Misc {
	

	public static String upperStringFirstChar(String _s)
	{
		String resultStr = "";
		if (_s.length() > 1)
		{
			resultStr = _s.substring(0, 1).toUpperCase() + _s.substring(1, _s.length());
		}
		else
		{
			resultStr = _s.toUpperCase();
		}
		
		return resultStr;
	} // end upperStringFirstChar()
	public static String lowerStringFirstChar(String _s)
	{
		String resultStr = "";
		if (_s.length() > 1)
		{
			resultStr = _s.substring(0, 1).toLowerCase() + _s.substring(1, _s.length());
		}
		else
		{
			resultStr = _s.toLowerCase();
		}
		
		return resultStr;
	} // end lowerStringFirstChar()
	public static String convertTableNameFormat2ClassNameFormat(String _databaseName)
	{
		String voClassName = "";
		if (null != _databaseName)
		{
		  int idxOfTablePrefix = _databaseName.indexOf(SystemParams.TABLE_PREFIX);

		  if (idxOfTablePrefix != -1)
		  {
			  String tempClassName = _databaseName.substring(idxOfTablePrefix + SystemParams.TABLE_PREFIX.length(), _databaseName.length());
			  
			  String [] splitClassName = tempClassName.split("_");
			  
			  for (int i = 0; i < splitClassName.length; i++)
			  {
				  voClassName += Misc.upperStringFirstChar(splitClassName[i]);
			  } // end for 
		  } // end if (idxOfTablePrefix != -1)
		} // end if (null != databaseName)	
		return voClassName;
	} // end convertTableNameFormat2ClassNameFormat
	public static String convertTableFieldsFormat2JavaPropertiesFormat(String _tableFieldName)
	{
		_tableFieldName = _tableFieldName.toLowerCase();
		String javaPropertiesName = "";
		if (null != _tableFieldName)
		{
			String [] splitTableFieldName = _tableFieldName.split("_");
			
			for (int i = 0; i < splitTableFieldName.length; i++)
			{
				if (i == 0)
				{
					javaPropertiesName += Misc.lowerStringFirstChar(splitTableFieldName[i]);
				}
				else
				{
					javaPropertiesName += Misc.upperStringFirstChar(splitTableFieldName[i]);
				}
			} // end for 
		} // end if (null != _tableFieldName)
		return javaPropertiesName;
	} // end convertTableFieldsFormat2JavaPropertiesFormat
	public static String convertTableFieldsFormat2JavaFnFormat(String _tableFieldName)
	{
		String javaPropertiesName = "";
		if (null != _tableFieldName)
		{
			String [] splitTableFieldName = _tableFieldName.split("_");
			
			for (int i = 0; i < splitTableFieldName.length; i++)
			{

				javaPropertiesName += Misc.upperStringFirstChar(splitTableFieldName[i]);

			} // end for 
		} // end if (null != _tableFieldName)
		return javaPropertiesName;
	} // end convertTableFieldsFormat2JavaPropertiesFormat	
} // end class
