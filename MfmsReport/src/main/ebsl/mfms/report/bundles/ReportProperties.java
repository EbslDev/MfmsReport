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
	private String reportDirectory;
	private Integer noOfRecordsPerFile;
	private Boolean saveExcelsToServer;
	private Boolean saveCompressedFilesToServer;
	private String patrolExcelPrefixEn;
	private String patrolExcelSuffixEn;
	private String patrolExcelSheetNameEn;
	private String inspectionExcelPrefixEn;
	private String inspectionExcelSuffixEn;
	private String inspectionExcelSheetNameEn;
	private String patrolExcelPrefixTc;
	private String patrolExcelSuffixTc;
	private String patrolExcelSheetNameTc;
	private String inspectionExcelPrefixTc;
	private String inspectionExcelSuffixTc;
	private String inspectionExcelSheetNameTc;
	public void setReportDirectory(String reportDirectory){
		this.reportDirectory = reportDirectory;
	}
	public String getReportDirectory(){
		return this.reportDirectory;
	}
	public void setNoOfRecordsPerFile(Integer noOfRecordsPerFile){
		this.noOfRecordsPerFile = noOfRecordsPerFile;
	}
	public Integer getNoOfRecordsPerFile(){
		return this.noOfRecordsPerFile;
	}
	public void setSaveExcelsToServer(Boolean saveExcelsToServer){
		this.saveExcelsToServer = saveExcelsToServer;
	}
	public Boolean getSaveExcelsToServer(){
		return this.saveExcelsToServer;
	}
	public void setSaveCompressedFilesToServer(Boolean saveCompressedFilesToServer){
		this.saveCompressedFilesToServer = saveCompressedFilesToServer;
	}
	public Boolean getSaveCompressedFilesToServer(){
		return this.saveCompressedFilesToServer;
	}
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
	public void setPatrolExcelSheetNameEn(String patrolExcelSheetNameEn){
		this.patrolExcelSheetNameEn = patrolExcelSheetNameEn;
	}
	public String getPatrolExcelSheetNameEn(){
		return this.patrolExcelSheetNameEn;
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
	public void setInspectionExcelSheetNameEn(String inspectionExcelSheetNameEn){
		this.inspectionExcelSheetNameEn = inspectionExcelSheetNameEn;
	}
	public String getInspectionExcelSheetNameEn(){
		return this.inspectionExcelSheetNameEn;
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
	public void setPatrolExcelSheetNameTc(String patrolExcelSheetNameTc){
		this.patrolExcelSheetNameTc = patrolExcelSheetNameTc;
	}
	public String getPatrolExcelSheetNameTc(){
		return this.patrolExcelSheetNameTc;
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
	public void setInspectionExcelSheetNameTc(String inspectionExcelSheetNameTc){
		this.inspectionExcelSheetNameTc = inspectionExcelSheetNameTc;
	}
	public String getInspectionExcelSheetNameTc(){
		return this.inspectionExcelSheetNameTc;
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
	public String getPatrolExcelSheetName(){
		String property = null;
		if(this.lang == null){
			this.lang = LANG_EN;
		}
		if(this.lang.equals(LANG_TCHI)){
			property = this.getPatrolExcelSheetNameTc();
		} else
		if(this.lang.equals(LANG_EN)){
			property = this.getPatrolExcelSheetNameEn();
		} else {
			property = this.getPatrolExcelSheetNameEn();
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
	public String getInspectionExcelSheetName(){
		String property = null;
		if(this.lang == null){
			this.lang = LANG_EN;
		}
		if(this.lang.equals(LANG_TCHI)){
			property = this.getInspectionExcelSheetNameTc();
		} else
		if(this.lang.equals(LANG_EN)){
			property = this.getInspectionExcelSheetNameEn();
		} else {
			property = this.getInspectionExcelSheetNameEn();
		}
		return property;
	}

}
