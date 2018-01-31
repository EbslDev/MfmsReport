package com.rabbitforever.generateJavaMVC.bundles;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MySqlDbProperties extends PropertiesBase implements DbProperties{
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private String className = this.getClass().getName();
	private final static String FILE_NAME = "mysql.db.properties";
	private String connectString;
	private String host;
	private String port;
	private String userName;
	private String password;
	private String schema;
	private String systemSchema;
	private String classForName;
	
	public MySqlDbProperties() throws Exception {
		super(FILE_NAME);
	}
	
	public String getSchema() throws Exception {
		try {
			schema = this.getPropValues("schema");
		} catch (Exception e) {
			logger.error(className + ".getSchema()", e);
			throw e;
		}
		return schema;
	}

	public String getConnectString() throws Exception{
		try {
			connectString = this.getPropValues("connection_string");
		} catch (Exception e) {
			logger.error(className + ".getConnectString()", e);
			throw e;
		}
		return connectString;
	}

	public String getHost() throws Exception{
		try {
			host = this.getPropValues("host");
		} catch (Exception e) {
			logger.error(className + ".init()", e);
			throw e;
		} 
		return host;
	}

	public String getPort() throws Exception{
		try {
			port = this.getPropValues("port");
		} catch (Exception e) {
			logger.error(className + ".init()", e);
			throw e;
		}

		return port;
	}

	public String getUserName() throws Exception{
		try {
			userName = this.getPropValues("username");
		} catch (Exception e) {
			logger.error(className + ".getUserName()", e);
			throw e;
		}

		return userName;
	}

	public String getPassword() throws Exception{
		try {
			password = this.getPropValues("password");
		} catch (Exception e) {
			logger.error(className + ".getPassword()", e);
			throw e;
		}

		return password;
	}

	public String getClassForName() throws Exception{
		try {
			classForName = this.getPropValues("class_for_name");
		} catch (Exception e) {
			logger.error(className + ".getClassForName()", e);
			throw e;
		}

		return classForName;
	}

	public String getSystemSchema() throws Exception{
		try {
			systemSchema = this.getPropValues("system_schema");
		} catch (Exception e) {
			logger.error(className + ".getSystemSchema()", e);
			throw e;
		}

		return systemSchema;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MySqlDbProperties [logger=");
		builder.append(logger);
		builder.append(", className=");
		builder.append(className);
		builder.append(", connectString=");
		builder.append(connectString);
		builder.append(", host=");
		builder.append(host);
		builder.append(", port=");
		builder.append(port);
		builder.append(", userName=");
		builder.append(userName);
		builder.append(", password=");
		builder.append(password);
		builder.append(", schema=");
		builder.append(schema);
		builder.append(", systemSchema=");
		builder.append(systemSchema);
		builder.append(", classForName=");
		builder.append(classForName);
		builder.append("]");
		return builder.toString();
	}
	

	
}
