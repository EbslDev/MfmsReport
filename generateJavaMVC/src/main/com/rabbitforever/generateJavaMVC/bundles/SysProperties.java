package com.rabbitforever.generateJavaMVC.bundles;

public class SysProperties extends PropertiesBase{
	public static final String LANG_EN = PropertiesBase.LANG_EN;
	public static final String LANG_TCHI = PropertiesBase.LANG_TCHI;
	private String database;
	private String packageName;
	private String outputRootDirectory;
	private String tablePrefix;
	private String bundleDirName;
	
	public SysProperties() {
		super();
	}
	
	public SysProperties(String lang) {
		super(lang);
	}
	
	public String getDatabase() {
		return database;
	}
	public void setDatabase(String database) {
		this.database = database;
	}
	public String getPackageName() {
		return packageName;
	}
	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}
	public String getOutputRootDirectory() {
		return outputRootDirectory;
	}
	public void setOutputRootDirectory(String outputRootDirectory) {
		this.outputRootDirectory = outputRootDirectory;
	}
	public String getTablePrefix() {
		return tablePrefix;
	}
	public void setTablePrefix(String tablePrefix) {
		this.tablePrefix = tablePrefix;
	}
	public String getBundleDirName() {
		return bundleDirName;
	}
	public void setBundleDirName(String bundleDirName) {
		this.bundleDirName = bundleDirName;
	}


}
