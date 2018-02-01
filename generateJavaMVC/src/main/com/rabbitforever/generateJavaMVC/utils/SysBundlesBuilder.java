package com.rabbitforever.generateJavaMVC.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.rabbitforever.generateJavaMVC.bundles.SysProperties;

public class SysBundlesBuilder extends BundlesBuilder <SysProperties>{
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private String className;
	public SysBundlesBuilder(String fileName) throws Exception {
		super(fileName);
	}


	private String getClassName(){
		if (className == null) {
			className = this.getClass().getName();
		}
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
			sysProperties.setPackageName(packageName);
			String outputRootDirectory = getPropValues("output_root_directory");
			sysProperties.setOutputRootDirectory(outputRootDirectory);
			String tablePrefix = getPropValues("table_prefix");
			sysProperties.setTablePrefix(tablePrefix);
			String bundleDirName = getPropValues("bundle_dir_name");
			sysProperties.setBundleDirName(bundleDirName);
			
			
		} catch (Exception e){
			logger.error(getClassName() + ".getSysProperties()", e);
			throw e;
		}
		return sysProperties;
	}







}