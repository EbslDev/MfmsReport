package com.rabbitforever.generateJavaMVC.bundles;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SysProperties extends PropertiesBase{
	private final static String FILE_NAME = "system.properties";
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private String className = this.getClass().getName();

	private String database;
	private String packageName;
	private String outputRootDirectory;
	private String tablePrefix;
	public String getBundleDirName() {
		return bundleDirName;
	}
	public void setBundleDirName(String bundleDirName) {
		this.bundleDirName = bundleDirName;
	}
	private String bundleDirName;

	public SysProperties() throws Exception {
		super(FILE_NAME);
	}
	public String getOutputRootDirectory() throws Exception{
		try {
			outputRootDirectory = this.getPropValues("output_root_directory");
		} catch (Exception e) {
			logger.error(className + ".getConsumerThreadPool()", e);
			throw e;
		}
		return outputRootDirectory;
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
	public String getTablePrefix() {
		return tablePrefix;
	}
	public void setTablePrefix(String tablePrefix) {
		this.tablePrefix = tablePrefix;
	}
	public void setOutputRootDirectory(String outputRootDirectory) {
		this.outputRootDirectory = outputRootDirectory;
	}


}
