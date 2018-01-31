package com.rabbitforever.generateJavaMVC.bundles;

public interface DbProperties {
	public String getSchema() throws Exception;
	public String getConnectString() throws Exception;
	public String getHost() throws Exception;
	public String getPort() throws Exception;
	public String getUserName() throws Exception;
	public String getPassword() throws Exception;
	public String getClassForName() throws Exception;
	public String getSystemSchema() throws Exception;
}
