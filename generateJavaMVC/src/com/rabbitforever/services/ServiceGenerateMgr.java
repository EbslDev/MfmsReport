package com.rabbitforever.services;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import com.rabbitforever.commons.Misc;
import com.rabbitforever.policies.SystemParams;
import com.rabbitforever.vos.MetaDataField;

public class ServiceGenerateMgr {

	private String tableName;
	private String voClassName;
	private String objClassName;

	public ServiceGenerateMgr(String _tableName) {
		tableName = _tableName;
		voClassName = tableName;

		objClassName = Misc
				.convertTableFieldsFormat2JavaPropertiesFormat(tableName);
	} // end constructor

	public void generateService() {
		try {
			// Create file

			voClassName = tableName;

			String voFile = SystemParams.OUTPUT_ROOT_DIRECTORY
					+ "\\"+ SystemParams.PROJECT_FOLDER_ROOT +"\\" + SystemParams.SERVICE_DIR_NAME + "\\" + voClassName + "MgrImpl.java";

			FileWriter fstream = new FileWriter(voFile);
			BufferedWriter out = new BufferedWriter(fstream);
			// ################################################## begin writing
			// file
			StringBuilder sb = new StringBuilder();

			// --- class
			sb.append("public class " + voClassName + "MgrImpl extends " + voClassName +"Mgr\n");
			sb.append("{\n");

			OracleDbMgr oracleDbMgr = new OracleDbMgr();
			List<MetaDataField> metaDataFieldList = new ArrayList<MetaDataField>();
			metaDataFieldList = oracleDbMgr.getMetaDataList(tableName);

			// properties
			sb.append("private " + voClassName +"Dao " + objClassName + "Dao;\n");
			sb.append("private Logger log;\n");
			// constructor
			sb.append("public " + voClassName + "MgrImpl(){\n");
				sb.append(objClassName + "Dao = new " + voClassName + "Dao();\n");
				sb.append("log = Log4j.getInstanceOfLog(" + voClassName + "MgrImpl.class);\n");
			sb.append("} // end constructor\n");

			// ###############################
			// select Mgr
			// ###############################
			sb.append("public List<" + voClassName + "> " + "selectAll(){\n");
			sb.append("List<" + voClassName + "> " + objClassName
					+ "List = new ArrayList<" + voClassName + ">();\n");
			sb.append("try{\n");
			sb.append(objClassName + "List = " +objClassName + "Dao.selectAll();\n");
			sb.append("}\n");
			sb.append("catch (Exception ex){\n");
			sb.append("if ( log.isDebugEnabled() ){\n");
			//sb.append("log = Log4j.getInstanceOfLog(" + voClassName + "MgrImpl.class);\n");
			sb.append("log.error(ex.getStackTrace());\n");
			sb.append("}// end if (log.isDebugEnabled())\n");
			sb.append("} // end try ... catch\n");
			sb.append("return " + objClassName + "List;\n");
			sb.append("} // end select function\n");

			// ###############################
			// insert Mgr
			// ###############################
			sb.append("public " + voClassName + " insert(" + voClassName + " " + objClassName +"){\n");
				sb.append(voClassName + " " + objClassName + "Rtn = new " + voClassName + "();\n");
				sb.append("try{\n");
				sb.append(objClassName + "Rtn = " + objClassName + "Dao.insert(" + objClassName + ");\n");
				sb.append("}\n");
				sb.append("catch (Exception ex){\n");
				sb.append("if ( log.isDebugEnabled() ){\n");
				//sb.append("log = Log4j.getInstanceOfLog(" + voClassName + "MgrImpl.class);\n");
				sb.append("log.error(ex.getStackTrace());\n");
				sb.append("}// end if (log.isDebugEnabled())\n");
				sb.append("} // end try ... catch\n");
				sb.append("return " + objClassName + "Rtn;\n");
			sb.append("} // end insert()\n");
			
			
			// ###############################
			// update Mgr
			// ###############################
			sb.append("public " + voClassName + " update(" + voClassName + " " + objClassName +"){\n");
				sb.append(voClassName + " " + objClassName + "Rtn = new " + voClassName + "();\n");
				sb.append("try{\n");
				sb.append(objClassName + "Rtn = " + objClassName + "Dao.update(" + objClassName + ");\n");
				sb.append("}\n");
				sb.append("catch (Exception ex){\n");
				sb.append("if ( log.isDebugEnabled() ){\n");
				//sb.append("log = Log4j.getInstanceOfLog(" + voClassName + "MgrImpl.class);\n");
				sb.append("log.error(ex.getStackTrace());\n");
				sb.append("}// end if (log.isDebugEnabled())\n");
				sb.append("} // end try ... catch\n");
				sb.append("return " + objClassName + "Rtn;\n");
			sb.append("} // end update()\n");			
			
			// ###############################
			// delete statement
			// ###############################
			sb.append("public int delete(" + voClassName + " " + objClassName +"){\n");
				sb.append("int result = 0;\n");
				sb.append("try{\n");
				sb.append("result = " + objClassName + "Dao.delete(" + objClassName + ");\n");
				sb.append("}\n");
				sb.append("catch (Exception ex){\n");
				sb.append("if ( log.isDebugEnabled() ){\n");
				//sb.append("log = Log4j.getInstanceOfLog(" + voClassName + "MgrImpl.class);\n");
				sb.append("log.error(ex.getStackTrace());\n");
				sb.append("}// end if (log.isDebugEnabled())\n");
				sb.append("} // end try ... catch\n");
				sb.append("return result;\n");
			sb.append("} // end delete()\n");				
			

				
			// ########## end class ##############################
			sb.append("} //end class\n");
			out.write(sb.toString());

			// ################################################## end writing
			// file
			out.close();
		} catch (Exception e) {// Catch exception if any
			System.err.println("Error: " + e.getMessage());
		} // end try ... catch ...
		  System.out.println("Service is generated. : " + voClassName + "MgrImpl.java");
	} // end generateDao()

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ServiceGenerateMgr daoGenerateMgr = new ServiceGenerateMgr("LACCCDTL");
		daoGenerateMgr.generateService();
	}

}
