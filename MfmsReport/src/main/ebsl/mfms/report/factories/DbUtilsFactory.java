package ebsl.mfms.report.factories;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ebsl.mfms.report.utils.DbUtils;
import ebsl.mfms.report.utils.MySqlDbUtils;
public class DbUtilsFactory {
	private final static Logger logger = LoggerFactory.getLogger(getClassName());
	private static DbUtils mySqlDbUtils;
//	private static DbUtils db2DbUtils;
//	private static DbUtils msSqlDbUtils;
	private static DbUtilsFactory dbUtilsFactory;
	private DbUtilsFactory(){
		
	}
	public static String getClassName() {
		String className = DbUtilsFactory.class.getName();
		return className;
	}
	public static DbUtilsFactory getInstanceOfDbUtilsFactory() throws Exception {
		try {
			if (dbUtilsFactory == null) {
				dbUtilsFactory = new DbUtilsFactory();
			}
		} catch (Exception e) {
			logger.error(getClassName() + ".getInstanceOfDbUtilsFactory() - ", e);
		}
		return dbUtilsFactory;
	}
	public DbUtils getInstanceOfMySqlDbUtils() throws Exception{
		if (mySqlDbUtils == null){
			mySqlDbUtils = new MySqlDbUtils();
		}
		return mySqlDbUtils;
	}
//	public static DbUtils getInstanceOfDb2DbUtils() throws Exception{
//		if (db2DbUtils == null){
//			db2DbUtils = new Db2DbUtils();
//		}
//		return db2DbUtils;
//	}
//	
//	public static DbUtils getInstanceOfMsSqlDbUtils() throws Exception{
//		if (msSqlDbUtils == null){
//			msSqlDbUtils = new MsSqlDbUtils();
//		}
//		return msSqlDbUtils;
//	}
}
