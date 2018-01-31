package com.rabbitforever.generateJavaMVC.bundles;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SysProperties extends PropertiesBase{
	private final static String FILE_NAME = "system.properties";
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private String className = this.getClass().getName();

	private String outputRootDirectory;
	private String projectFolderRoot;
	private String tablePrefix;
	private String phpSysConfigRoot;



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

	public String getProjectFolderRoot() throws Exception{
		try {
			projectFolderRoot = this.getPropValues("project_folder_root");
		} catch (Exception e) {
			logger.error(className + ".getConsumerSleepTime()", e);
			throw e;
		}
		return projectFolderRoot;
	}

	public String getTablePrefix() throws Exception{
		try {
			tablePrefix = this.getPropValues("table_prefix");

		} catch (Exception e) {
			logger.error(className + ".getProducerThreadPool()", e);
			throw e;
		} 
		return tablePrefix;
	}
	public String getPhpSysConfigRoot() throws Exception {
		try{
			phpSysConfigRoot = this.getPropValues("php_sys_config_root");
		} catch (Exception e){
			logger.error(className + ".getPhpSysConfigRoot()", e);
			throw e;
		}
		return phpSysConfigRoot;
	}
}
