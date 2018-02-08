package ebsl.mfms.report.utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ebsl.mfms.report.bundles.ReportProperties;
public class ReportBundleUtils extends BundlesUtils<ReportProperties>{
		private String className;
	private final Logger logger = LoggerFactory.getLogger(getClassName());
	public ReportBundleUtils(String fileName) throws Exception {
		super(fileName);
	}
	private String getClassName(){
		if(className == null){
			className = this.getClass().getName();
		}
		return className;
	}
	public ReportProperties getProperties() throws Exception{
		ReportProperties ReportProperties = null;
		try{
			ReportProperties = new ReportProperties();
			String patrolExcelPrefixEn=getPropValues("patrol_excel_prefix.en");
			ReportProperties.setPatrolExcelPrefixEn(patrolExcelPrefixEn);
			String patrolExcelSuffixEn=getPropValues("patrol_excel_suffix.en");
			ReportProperties.setPatrolExcelSuffixEn(patrolExcelSuffixEn);
			String inspectionExcelPrefixEn=getPropValues("inspection_excel_prefix.en");
			ReportProperties.setInspectionExcelPrefixEn(inspectionExcelPrefixEn);
			String inspectionExcelSuffixEn=getPropValues("inspection_excel_suffix.en");
			ReportProperties.setInspectionExcelSuffixEn(inspectionExcelSuffixEn);
			String patrolExcelPrefixTc=getPropValues("patrol_excel_prefix.tc");
			ReportProperties.setPatrolExcelPrefixTc(patrolExcelPrefixTc);
			String patrolExcelSuffixTc=getPropValues("patrol_excel_suffix.tc");
			ReportProperties.setPatrolExcelSuffixTc(patrolExcelSuffixTc);
			String inspectionExcelPrefixTc=getPropValues("inspection_excel_prefix.tc");
			ReportProperties.setInspectionExcelPrefixTc(inspectionExcelPrefixTc);
			String inspectionExcelSuffixTc=getPropValues("inspection_excel_suffix.tc");
			ReportProperties.setInspectionExcelSuffixTc(inspectionExcelSuffixTc);
			String reportDirectory=getPropValues("report_directory");
			ReportProperties.setReportDirectory(reportDirectory);
		} catch (Exception e){
			logger.error(getClassName() + ".getProperties()", e);
			throw e;
		}
		return ReportProperties;
	}
} //end class
