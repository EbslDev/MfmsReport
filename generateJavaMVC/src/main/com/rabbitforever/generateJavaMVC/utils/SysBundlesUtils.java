package com.rabbitforever.generateJavaMVC.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.rabbitforever.generateJavaMVC.bundles.SysProperties;

public class SysBundlesUtils extends BundlesUtils <SysProperties>{
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	public SysBundlesUtils(String fileName) throws Exception {
		super(fileName);
	}


	private String getClassName(){
		String className = this.getClassName();
		return className;
	}
	@Override
	public SysProperties getProperties() throws Exception{
		SysProperties sysProperties = null;
		try{
			
			sysProperties = new SysProperties();
			String database = getPropValues("database");
			sysProperties.setDatabase(database);
			String packageName = getPropValues("package_name");
			sysProperties.setDatabase(packageName);
			String outputRootDirectory = getPropValues("output_root_directory");
			sysProperties.setDatabase(outputRootDirectory);
			String tablePrefix = getPropValues("table_prefix");
			sysProperties.setDatabase(tablePrefix);
			String bundleDirName = getPropValues("bundle_dir_name");
			sysProperties.setDatabase(bundleDirName);
			
			
		} catch (Exception e){
			logger.error(getClassName() + ".getSysProperties()", e);
			throw e;
		}
		return sysProperties;
	}







}
