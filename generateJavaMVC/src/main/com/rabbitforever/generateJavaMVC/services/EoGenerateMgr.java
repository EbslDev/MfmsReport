package com.rabbitforever.generateJavaMVC.services;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import com.rabbitforever.generateJavaMVC.bundles.SysProperties;
import com.rabbitforever.generateJavaMVC.commons.JavaOracle;
import com.rabbitforever.generateJavaMVC.commons.Misc;
import com.rabbitforever.generateJavaMVC.factories.PropertiesFactory;
import com.rabbitforever.generateJavaMVC.models.eos.MetaDataField;
import com.rabbitforever.generateJavaMVC.policies.SystemParams;

public class EoGenerateMgr {

	private String tableName;
	private String eoClassName;
	private PropertiesFactory propertiesFactory;
	private SysProperties sysProperties;
	public EoGenerateMgr(String _tableName) {
		try {
			tableName = _tableName;
			eoClassName = tableName;

			propertiesFactory = PropertiesFactory.getInstanceOfPropertiesFactory();
			sysProperties = propertiesFactory.getInstanceOfSysProperties();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	} // end constructor

	public void generateVo() {
		try {
			// Create file

			eoClassName = tableName;
			String outputRootDirectory = sysProperties.getOutputRootDirectory();
			String modelsDirName = sysProperties.getModelsDirName();
			String eosDirName = sysProperties.getEosDirName();
			
			String eoFile = outputRootDirectory + "\\" + modelsDirName + "\\"
					+ eosDirName + "\\" + eoClassName + ".java";

			FileWriter fstream = new FileWriter(eoFile);
			BufferedWriter out = new BufferedWriter(fstream);
			// ################################################## begin writing file
			StringBuilder sb = new StringBuilder();

			// --- class
			sb.append("public class " + eoClassName + "\n");
			sb.append("{\n");

			MySqlDbMgr oracleDbMgr = new MySqlDbMgr();
			List<MetaDataField> metaDataFieldList = new ArrayList<MetaDataField>();
			metaDataFieldList = oracleDbMgr.getMetaDataList(tableName);
			for (int i = 0; i < metaDataFieldList.size(); i++) {
				MetaDataField metaDataField = new MetaDataField();
				metaDataField = metaDataFieldList.get(i);

				sb.append("protected " + JavaOracle.mapOracleType2JavaType(metaDataField.getTypeName()) + " "
						+ Misc.convertTableFieldsFormat2JavaPropertiesFormat(metaDataField.getColumnName()) + ";\n");
			} // end for (int i = 0; i < metaDataFieldList.size(); i++)

			sb.append("}\n");
			out.write(sb.toString());

			// ################################################## end writing file
			out.close();
		} catch (Exception e) {// Catch exception if any
			System.err.println("Error: " + e.getMessage());
		} // end try ... catch ...

		System.out.println("Vo is generated. : " + eoClassName + ".java");
	} // end generateVo()
} // end VoGenerateMgr
