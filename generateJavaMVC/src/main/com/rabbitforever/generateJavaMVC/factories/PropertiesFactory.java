package com.rabbitforever.generateJavaMVC.factories;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.rabbitforever.generateJavaMVC.bundles.MySqlDbProperties;
import com.rabbitforever.generateJavaMVC.bundles.SysProperties;
import com.rabbitforever.generateJavaMVC.utils.BundlesUtils;
import com.rabbitforever.generateJavaMVC.utils.SysBundlesUtils;

public class PropertiesFactory {
	private final static Logger logger = LoggerFactory.getLogger(PropertiesFactory.class);
	private final static String className = PropertiesFactory.class.getName();
	
	
	private BundlesUtils<SysProperties> sysBundlesUtils;
	private final String SYS_PROPERTIES_FILE = "sys.properties";
	
	private static PropertiesFactory propertiesFactory;
	private static MySqlDbProperties mysqlDbProperties;
	private static SysProperties sysProperties;
	private String getClassName() {
		String className = this.getClassName();
		return className;
	}
	private PropertiesFactory() throws Exception{
		try {
			init();
		} catch (Exception e) {
			logger.error(getClassName() + ".PropertiesFactory()", e);
		}
	}

	private void init() throws Exception {
		try {


		} catch (Exception e) {
			logger.error(getClassName() + ".BundlesFactory()", e);
		}
	}
	
	public static PropertiesFactory getInstanceOfPropertiesFactory() throws Exception {
		try {
			if (propertiesFactory == null) {
				propertiesFactory = new PropertiesFactory();
			}
		} catch (Exception e) {
			logger.error(className + ".getInstanceOfPropertiesFactory() - ", e);
		}
		return propertiesFactory;
	}
	
	public MySqlDbProperties getInstanceOfMySqlDbProperties() throws Exception {
		try {
			if (mysqlDbProperties == null) {
				mysqlDbProperties = new MySqlDbProperties();
			}

		} catch (Exception e) {
			logger.error(className + ".getInstanceOfMySqlDbProperties() - ", e);
		}
		return mysqlDbProperties;
	}
	
	public SysProperties getInstanceOfSysProperties() throws Exception {
		try {
			if(sysBundlesUtils == null) {
				sysBundlesUtils = new SysBundlesUtils(SYS_PROPERTIES_FILE);
			}
			sysProperties = (SysProperties) sysBundlesUtils.getProperties();
			if (sysProperties == null) {
				throw new Exception(SYS_PROPERTIES_FILE + " does not exist!");
			}

		} catch (Exception ex) {
			logger.error(className + ".getInstanceOfSysProperties() - ", ex);
			throw ex;
		}
		return sysProperties;
	}

}
