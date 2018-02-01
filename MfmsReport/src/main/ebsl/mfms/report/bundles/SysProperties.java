package ebsl.mfms.report.bundles;

public class SysProperties {
	public static final String DATABASE_DB2 = "db2";
	public static final String DATABASE_MYSQL = "mysql";
	public static final String DATABASE_MSSQL = "mssql";
	private String database;

	
	public String getDatabase() {
		return database;
	}
	public void setDatabase(String database) {
		this.database = database;
	}
}
