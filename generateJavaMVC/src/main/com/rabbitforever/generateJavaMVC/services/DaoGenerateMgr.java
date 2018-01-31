package com.rabbitforever.generateJavaMVC.services;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import com.rabbitforever.generateJavaMVC.commons.JavaOracle;
import com.rabbitforever.generateJavaMVC.commons.Misc;
import com.rabbitforever.generateJavaMVC.models.eos.MetaDataField;
import com.rabbitforever.generateJavaMVC.policies.SystemParams;

public class DaoGenerateMgr {

	private String tableName;
	private String voClassName;
	private String objClassName;

	public DaoGenerateMgr(String _tableName) {
		tableName = _tableName;
		voClassName = tableName;

		objClassName = Misc
				.convertTableFieldsFormat2JavaPropertiesFormat(tableName);
	} // end constructor

	public void generateDao() {
		try {
			// Create file

			voClassName = tableName;

			String voFile = SystemParams.OUTPUT_ROOT_DIRECTORY
					+ "\\" + SystemParams.PROJECT_FOLDER_ROOT +"\\" + SystemParams.DAO_DIR_NAME + "\\" + voClassName + "DaoImpl.java";

			FileWriter fstream = new FileWriter(voFile);
			BufferedWriter out = new BufferedWriter(fstream);
			// ################################################## begin writing
			// file
			StringBuilder sb = new StringBuilder();

			// --- class
			sb.append("public class " + voClassName + "DaoImpl implements " + voClassName + "Dao\n");
			sb.append("{\n");

			OracleDbMgr oracleDbMgr = new OracleDbMgr();
			List<MetaDataField> metaDataFieldList = new ArrayList<MetaDataField>();
			metaDataFieldList = oracleDbMgr.getMetaDataList(tableName);

			// properties
			sb.append("private Connection conn;\n");
			sb.append("private PreparedStatement  pstmt;\n");
			sb.append("private ResultSet rs;\n");
			sb.append("private Logger log;\n");
			// constructor
			sb.append("public " + voClassName + "DaoImpl(){\n");
			sb.append("this.conn = \"SysParams.getConn();\";\n");
			sb.append("this.pstmt = null;\n");
			sb.append("this.rs = null;\n");
			sb.append("log = Log4j.getInstanceOfLog(" + voClassName + "DaoImpl.class);\n");
			sb.append("} // end constructor\n");

			// ###############################
			// select statement
			// ###############################
			sb.append("private final String SELECT_SQL=\n");
			sb.append("\t\t\t\"select ");

			for (int i = 0; i < metaDataFieldList.size(); i++) {
				MetaDataField metaDataField = new MetaDataField();
				metaDataField = metaDataFieldList.get(i);

				sb.append(metaDataField.getColumnName());

				if (i != metaDataFieldList.size() - 1) {
					sb.append(", ");
				} else {
					sb.append(" ");
				}
			} // end for (int i = 0; i < metaDataFieldList.size(); i++)

			sb.append("from " + tableName + "\";\n");

			// select function
			sb.append("public List<" + voClassName + "> " + "selectAll(){\n");
			sb.append("List<" + voClassName + "> " + objClassName
					+ "List = new ArrayList<" + voClassName + ">();\n");
			sb.append("try{\n");
			sb.append("pstmt = conn.prepareStatement(SELECT_SQL);\n");
			sb.append("//pstmt.setString(1, xxx);\n");
			sb.append("rs = pstmt.executeQuery();\n");

			// while select recordset
			sb.append("while (rs.next()){\n");
			sb.append(voClassName + " " + objClassName + " = new "
					+ voClassName + "();\n");

			// loop field name
			for (int i = 0; i < metaDataFieldList.size(); i++) {
				MetaDataField metaDataField = new MetaDataField();
				metaDataField = metaDataFieldList.get(i);

				sb.append(objClassName
						+ ".set"
						+ Misc.upperStringFirstChar(Misc
								.convertTableFieldsFormat2JavaPropertiesFormat(metaDataField
										.getColumnName()))
						+ "("
						+ "rs.get"
						+ JavaOracle.mapOracleType2JavaType(metaDataField
								.getTypeName()) + "(\""
						+ metaDataField.getColumnName() + "\")" + ");\n");
				sb.append(objClassName + "List.add(" + objClassName + ");\n");

			} // end for (int i = 0; i < metaDataFieldList.size(); i++)

			sb.append("} // end while (rs.next())\n");

			sb.append("rs.close();\n");
			sb.append("pstmt.close();\n");
			sb.append("conn.close();\n");

			sb.append("}\n");
			sb.append("catch (Exception ex){\n");
			sb.append("if ( log.isDebugEnabled() ){\n");
			//sb.append("log = Log4j.getInstanceOfLog(" + voClassName + "Dao.class);\n");
			sb.append("log.error(ex.getStackTrace());\n");
			sb.append("}// end if (log.isDebugEnabled())\n");
			sb.append("} // end try ... catch\n");			
			
			sb.append("return " + objClassName + "List;\n");
			sb.append("} // end select function\n");

			// ###############################
			// insert statement
			// ###############################
			sb.append("private final String INSERT_SQL=\n");
			sb.append("\t\t\t\"insert into " + this.tableName + "(");

			for (int i = 0; i < metaDataFieldList.size(); i++) {
				MetaDataField metaDataField = new MetaDataField();
				metaDataField = metaDataFieldList.get(i);

				sb.append(metaDataField.getColumnName());

				if (i != metaDataFieldList.size() - 1) {
					sb.append(", ");
				} else {
					sb.append(" ");
				}
			} // end for (int i = 0; i < metaDataFieldList.size(); i++)

			sb.append(")\" + \n");
			sb.append("\t\t\t\"values(");
			for (int i = 0; i < metaDataFieldList.size(); i++) {
				MetaDataField metaDataField = new MetaDataField();
				metaDataField = metaDataFieldList.get(i);

				sb.append("?");

				if (i != metaDataFieldList.size() - 1) {
					sb.append(", ");
				} else {
					sb.append(" ");
				}
			} // end for (int i = 0; i < metaDataFieldList.size(); i++)
			sb.append(")\";\n");

			// insert function
			sb.append("public " + voClassName + " insert(" + voClassName + " " + objClassName +"){\n");
				sb.append(voClassName + " " + objClassName + "Rtn = new " + voClassName + "();\n");
				sb.append("try{\n");
				sb.append("pstmt = conn.prepareStatement(INSERT_SQL);\n");
				
				// loop prep statement insert fields
				// loop field name
				for (int i = 0; i < metaDataFieldList.size(); i++) {
					MetaDataField metaDataField = new MetaDataField();
					metaDataField = metaDataFieldList.get(i);

					sb.append("pstmt.set" + JavaOracle.mapOracleType2JavaType(metaDataField.getTypeName()) + "(" + (i+1) + ", " + objClassName + ".get" + Misc.upperStringFirstChar(Misc
							.convertTableFieldsFormat2JavaPropertiesFormat(metaDataField.getColumnName())) + "());\n");

				} // end for (int i = 0; i < metaDataFieldList.size(); i++)				
				
				
				
				sb.append("pstmt.executeUpdate();\n");
				sb.append("rs.close();\n");
				sb.append("pstmt.close();\n");
				sb.append("conn.close();\n");	
				
				sb.append("}\n");
				sb.append("catch (Exception ex){\n");
				sb.append("if ( log.isDebugEnabled() ){\n");
				//sb.append("log = Log4j.getInstanceOfLog(" + voClassName + "DaoImpl.class);\n");
				sb.append("log.error(ex.getStackTrace());\n");
				sb.append("}// end if (log.isDebugEnabled())\n");
				sb.append("} // end try ... catch\n");	
				sb.append("return " + objClassName + "Rtn;\n");
			sb.append("} // end insert()\n");
			
			
			// ###############################
			// update statement
			// ###############################
			sb.append("private final String UPDATE_SQL=\n");
			sb.append("\t\t\t\"update " + this.tableName + " set ");

			for (int i = 0; i < metaDataFieldList.size(); i++) {
				MetaDataField metaDataField = new MetaDataField();
				metaDataField = metaDataFieldList.get(i);

				sb.append(metaDataField.getColumnName() + "= ?" );

				if (i != metaDataFieldList.size() - 1) {
					sb.append(", ");
				} else {
					sb.append(" ");
				}
			} // end for (int i = 0; i < metaDataFieldList.size(); i++)

			sb.append("where \" +\n");
			sb.append("\t\t\t\"TMSMTPLSTUPD = ? and xxx = ?\";\n");
			
			
			// update function
			sb.append("public " + voClassName + " update(" + voClassName + " " + objClassName +"){\n");
				sb.append(voClassName + " " + objClassName + "Rtn = new " + voClassName + "();\n");
				sb.append("try{\n");
				sb.append("pstmt = conn.prepareStatement(UPDATE_SQL);\n");
				
				// loop prep statement update fields
				// loop field name
				for (int i = 0; i < metaDataFieldList.size(); i++) {
					MetaDataField metaDataField = new MetaDataField();
					metaDataField = metaDataFieldList.get(i);

					sb.append("pstmt.set" + JavaOracle.mapOracleType2JavaType(metaDataField.getTypeName()) + "(" + (i+1) + ", " + objClassName + ".get" + Misc.upperStringFirstChar(Misc
							.convertTableFieldsFormat2JavaPropertiesFormat(metaDataField.getColumnName())) + "());\n");

				} // end for (int i = 0; i < metaDataFieldList.size(); i++)				
				
				
				sb.append("pstmt.setDate(" + (metaDataFieldList.size() + 1) + ", " + objClassName + ".getTmsmtplstupd());\n");
				sb.append("pstmt.setXXX(" + (metaDataFieldList.size() + 2) + ", " + objClassName + ".getXXX());\n");
				sb.append("pstmt.executeUpdate();\n");
				sb.append("rs.close();\n");
				sb.append("pstmt.close();\n");
				sb.append("conn.close();\n");	
				sb.append("}\n");
				sb.append("catch (Exception ex){\n");
				sb.append("if ( log.isDebugEnabled() ){\n");
				//sb.append("log = Log4j.getInstanceOfLog(" + voClassName + "DaoImpl.class);\n");
				sb.append("log.error(ex.getStackTrace());\n");
				sb.append("}// end if (log.isDebugEnabled())\n");
				sb.append("} // end try ... catch\n");					
				sb.append("return " + objClassName + "Rtn;\n");
			sb.append("} // end update()\n");			
			
			// ###############################
			// delete statement
			// ###############################
			sb.append("private final String DELETE_SQL=\n");
			sb.append("\t\t\t\"delete from " + this.tableName + " where TMSMTPLSTUPD = ? and xxx = ?\";\n");

			// delete function
			sb.append("public int delete(" + voClassName + " " + objClassName +"){\n");
				sb.append("int result;\n");
				sb.append("try{\n");
				sb.append("pstmt = conn.prepareStatement(DELETE_SQL);\n");
								
				sb.append("pstmt.setDate(1, " + objClassName + ".getTmsmtplstupd());\n");
				sb.append("pstmt.setXXX(2, " + objClassName + ".getXXX());\n");
				sb.append("result = pstmt.executeUpdate();\n");
				sb.append("rs.close();\n");
				sb.append("pstmt.close();\n");
				sb.append("conn.close();\n");	
				
				sb.append("}\n");
				sb.append("catch (Exception ex){\n");
				sb.append("if ( log.isDebugEnabled() ){\n");
				//sb.append("log = Log4j.getInstanceOfLog(" + voClassName + "DaoImpl.class);\n");
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
		  System.out.println("Dao is generated. : " + voClassName + "DaoImpl.java");		
	} // end generateDao()

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DaoGenerateMgr daoGenerateMgr = new DaoGenerateMgr("LACCCDTL");
		daoGenerateMgr.generateDao();
	}

}
