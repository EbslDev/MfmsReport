package com.rabbitforever.generateJavaMVC.bundles;
public class SysProperties extends PropertiesBase{
	public static final String LANG_EN = PropertiesBase.LANG_EN;
	public static final String LANG_TCHI = PropertiesBase.LANG_TCHI;
	public SysProperties() {
		super();
}
	public SysProperties(String lang) {
		super(lang);
}
	private String database;
	private String packageName;
	private String outputRootDirectory;
	private String tablePrefix;
	private String bundleDirName;
	private String factoriesDirName;
	private String factoriesBuilderDirName;
	public void setDatabase(String database){
		this.database = database;
	}
	public String getDatabase(){
		return this.database;
	}
	public void setPackageName(String packageName){
		this.packageName = packageName;
	}
	public String getPackageName(){
		return this.packageName;
	}
	public void setOutputRootDirectory(String outputRootDirectory){
		this.outputRootDirectory = outputRootDirectory;
	}
	public String getOutputRootDirectory(){
		return this.outputRootDirectory;
	}
	public void setTablePrefix(String tablePrefix){
		this.tablePrefix = tablePrefix;
	}
	public String getTablePrefix(){
		return this.tablePrefix;
	}
	public void setBundleDirName(String bundleDirName){
		this.bundleDirName = bundleDirName;
	}
	public String getBundleDirName(){
		return this.bundleDirName;
	}
	public void setFactoriesDirName(String factoriesDirName){
		this.factoriesDirName = factoriesDirName;
	}
	public String getFactoriesDirName(){
		return this.factoriesDirName;
	}
	public void setFactoriesBuilderDirName(String factoriesBuilderDirName){
		this.factoriesBuilderDirName = factoriesBuilderDirName;
	}
	public String getFactoriesBuilderDirName(){
		return this.factoriesBuilderDirName;
	}
}
