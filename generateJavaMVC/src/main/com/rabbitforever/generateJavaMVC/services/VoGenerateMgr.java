package com.rabbitforever.generateJavaMVC.services;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import com.rabbitforever.generateJavaMVC.commons.JavaOracle;
import com.rabbitforever.generateJavaMVC.commons.Misc;
import com.rabbitforever.generateJavaMVC.models.eos.MetaDataField;
import com.rabbitforever.generateJavaMVC.policies.SystemParams;

public class VoGenerateMgr {

	private String tableName;
	private String voClassName;
	public VoGenerateMgr(String _tableName)
	{
		tableName =  _tableName;
		voClassName = tableName;
		
	} // end constructor
	public void generateVo()
	{
		  try{
			  // Create file 
			  
			  voClassName = tableName;
			  
			  String voFile = SystemParams.OUTPUT_ROOT_DIRECTORY 
					  + "\\" + SystemParams.PROJECT_FOLDER_ROOT+ "\\" + SystemParams.VO_DIR_NAME + "\\" + voClassName + ".java";
			  
			  
			  FileWriter fstream = new FileWriter(voFile);
			  BufferedWriter out = new BufferedWriter(fstream);
			  // ################################################## begin writing file
			  StringBuilder sb = new StringBuilder();

			  
			  // --- class
			  sb.append("public class " + voClassName + "\n");
			  sb.append("{\n");
			  
			  OracleDbMgr oracleDbMgr = new OracleDbMgr();
			  List<MetaDataField> metaDataFieldList = new ArrayList<MetaDataField> ();
			  metaDataFieldList = oracleDbMgr.getMetaDataList(tableName);
			  for (int i = 0; i < metaDataFieldList.size(); i++)
			  {
				  MetaDataField metaDataField = new MetaDataField();
				  metaDataField = metaDataFieldList.get(i);
		
				  sb.append("protected " + JavaOracle.mapOracleType2JavaType(metaDataField.getTypeName()) + " " + Misc.convertTableFieldsFormat2JavaPropertiesFormat(metaDataField.getColumnName()) + ";\n");
			  } // end for (int i = 0; i < metaDataFieldList.size(); i++)
			  
			 			  
			  sb.append("}\n");
			  out.write(sb.toString());

			  // ################################################## end writing file
			  out.close();
		  }
		  catch (Exception e){//Catch exception if any
			  System.err.println("Error: " + e.getMessage());
		  } // end try ... catch ...
		  
		  System.out.println("Vo is generated. : " + voClassName + ".java");
	} // end generateVo()
} // end VoGenerateMgr
