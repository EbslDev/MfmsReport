package com.rabbitforever.generateJavaMVC.bundles;

public class MySqlDbProperties extends PropertiesBase implements DbProperties{
	private String className = this.getClass().getName();
	private String connectString;
	private String host;
	private String port;
	private String userName;
	private String password;
	private String schema;
	private String systemSchema;
	private String classForName;
	public String getConnectString() {
		return connectString;
	}
	public void setConnectString(String connectString) {
		this.connectString = connectString;
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public String getPort() {
		return port;
	}
	public void setPort(String port) {
		this.port = port;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSchema() {
		return schema;
	}
	public void setSchema(String schema) {
		this.schema = schema;
	}
	public String getSystemSchema() {
		return systemSchema;
	}
	public void setSystemSchema(String systemSchema) {
		this.systemSchema = systemSchema;
	}
	public String getClassForName() {
		return classForName;
	}
	public void setClassForName(String classForName) {
		this.classForName = classForName;
	}

	

	

	
}
