package ebsl.mfms.report.bundles;
public class ReportProperties extends PropertiesBase{
	public static final String LANG_EN = PropertiesBase.LANG_EN;
	public static final String LANG_TCHI = PropertiesBase.LANG_TCHI;
	public ReportProperties() {
		super();
}
	public ReportProperties(String lang) {
		super(lang);
}
	private String patrolExcelPrefixEn;
	private String patrolExcelSuffixEn;
	private String inspectionExcelPrefixEn;
	private String inspectionExcelSuffixEn;
	private String patrolExcelPrefixTc;
	private String patrolExcelSuffixTc;
	private String inspectionExcelPrefixTc;
	private String inspectionExcelSuffixTc;
	public void setPatrolExcelPrefixEn(String patrolExcelPrefixEn){
		this.patrolExcelPrefixEn = patrolExcelPrefixEn;
	}
	public String getPatrolExcelPrefixEn(){
		return this.patrolExcelPrefixEn;
	}
	public void setPatrolExcelSuffixEn(String patrolExcelSuffixEn){
		this.patrolExcelSuffixEn = patrolExcelSuffixEn;
	}
	public String getPatrolExcelSuffixEn(){
		return this.patrolExcelSuffixEn;
	}
	public void setInspectionExcelPrefixEn(String inspectionExcelPrefixEn){
		this.inspectionExcelPrefixEn = inspectionExcelPrefixEn;
	}
	public String getInspectionExcelPrefixEn(){
		return this.inspectionExcelPrefixEn;
	}
	public void setInspectionExcelSuffixEn(String inspectionExcelSuffixEn){
		this.inspectionExcelSuffixEn = inspectionExcelSuffixEn;
	}
	public String getInspectionExcelSuffixEn(){
		return this.inspectionExcelSuffixEn;
	}
	public void setPatrolExcelPrefixTc(String patrolExcelPrefixTc){
		this.patrolExcelPrefixTc = patrolExcelPrefixTc;
	}
	public String getPatrolExcelPrefixTc(){
		return this.patrolExcelPrefixTc;
	}
	public void setPatrolExcelSuffixTc(String patrolExcelSuffixTc){
		this.patrolExcelSuffixTc = patrolExcelSuffixTc;
	}
	public String getPatrolExcelSuffixTc(){
		return this.patrolExcelSuffixTc;
	}
	public void setInspectionExcelPrefixTc(String inspectionExcelPrefixTc){
		this.inspectionExcelPrefixTc = inspectionExcelPrefixTc;
	}
	public String getInspectionExcelPrefixTc(){
		return this.inspectionExcelPrefixTc;
	}
	public void setInspectionExcelSuffixTc(String inspectionExcelSuffixTc){
		this.inspectionExcelSuffixTc = inspectionExcelSuffixTc;
	}
	public String getInspectionExcelSuffixTc(){
		return this.inspectionExcelSuffixTc;
	}
	public String getPatrolExcelPrefix(){
		String property = null;
		if(this.lang == null){
			this.lang = LANG_EN;
		}
		if(this.lang.equals(LANG_TCHI)){
			property = this.getPatrolExcelPrefixTc();
		} else
		if(this.lang.equals(LANG_EN)){
			property = this.getPatrolExcelPrefixEn();
		} else {
			property = this.getPatrolExcelPrefixEn();
		}
		return property;
	}
	public String getPatrolExcelSuffix(){
		String property = null;
		if(this.lang == null){
			this.lang = LANG_EN;
		}
		if(this.lang.equals(LANG_TCHI)){
			property = this.getPatrolExcelSuffixTc();
		} else
		if(this.lang.equals(LANG_EN)){
			property = this.getPatrolExcelSuffixEn();
		} else {
			property = this.getPatrolExcelSuffixEn();
		}
		return property;
	}
	public String getInspectionExcelPrefix(){
		String property = null;
		if(this.lang == null){
			this.lang = LANG_EN;
		}
		if(this.lang.equals(LANG_TCHI)){
			property = this.getInspectionExcelPrefixTc();
		} else
		if(this.lang.equals(LANG_EN)){
			property = this.getInspectionExcelPrefixEn();
		} else {
			property = this.getInspectionExcelPrefixEn();
		}
		return property;
	}
	public String getInspectionExcelSuffix(){
		String property = null;
		if(this.lang == null){
			this.lang = LANG_EN;
		}
		if(this.lang.equals(LANG_TCHI)){
			property = this.getInspectionExcelSuffixTc();
		} else
		if(this.lang.equals(LANG_EN)){
			property = this.getInspectionExcelSuffixEn();
		} else {
			property = this.getInspectionExcelSuffixEn();
		}
		return property;
	}
}
