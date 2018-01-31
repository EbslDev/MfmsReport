package com.rabbitforever.generateJavaMVC.factories;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.rabbitforever.generateJavaMVC.bundles.MySqlDbProperties;
import com.rabbitforever.generateJavaMVC.bundles.SysProperties;

public class PropertiesFactory {
	private final static Logger logger = LoggerFactory.getLogger(PropertiesFactory.class);
	private final static String className = PropertiesFactory.class.getName();
	private static MySqlDbProperties mysqlDbProperties;
	private static SysProperties sysPropertiesEo;

	private PropertiesFactory() {

	}

	public static MySqlDbProperties getInstanceOfMySqlDbProperties() throws Exception {
		try {
			if (mysqlDbProperties == null) {
				mysqlDbProperties = new MySqlDbProperties();
			}

		} catch (Exception e) {
			logger.error(className + ".getInstanceOfMySqlDbProperties() - ", e);
		}
		return mysqlDbProperties;
	}
	
	public static SysProperties getInstanceOfSysPropertiesEo() throws Exception {
		try {
			if (sysPropertiesEo == null) {
				sysPropertiesEo = new SysProperties();
			}
		} catch (Exception ex) {
			logger.error(className + ".getInstanceOfSysPropertiesEo() - ", ex);
			throw ex;
		}
		return sysPropertiesEo;
	}

}
