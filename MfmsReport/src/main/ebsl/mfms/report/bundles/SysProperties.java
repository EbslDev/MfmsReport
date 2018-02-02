package ebsl.mfms.report.bundles;
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
	private String deployType;
	public void setDatabase(String database){
		this.database = database;
	}
	public String getDatabase(){
		return this.database;
	}
	public void setDeployType(String deployType){
		this.deployType = deployType;
	}
	public String getDeployType(){
		return this.deployType;
	}
}
