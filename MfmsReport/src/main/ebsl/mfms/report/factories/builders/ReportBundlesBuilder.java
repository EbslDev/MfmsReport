package ebsl.mfms.report.factories.builders;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ebsl.mfms.report.bundles.ReportProperties;
public class ReportBundlesBuilder extends BundlesBuilder<ReportProperties>{
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private String className;
	public ReportBundlesBuilder(String fileName) throws Exception{
		super(fileName);
	}
	private String getClassName(){
		if(className == null){
			className = this.getClass().getName();
		}
		return className;
	}
	@Override
	public ReportProperties build() throws Exception{
		 ReportProperties reportProperties= null;
		try{
			reportProperties = new ReportProperties();
			String patrolExcelPrefixEn = getPropValues("patrol_excel_prefix.en");
			reportProperties.setPatrolExcelPrefixEn(patrolExcelPrefixEn);
			String patrolExcelSuffixEn = getPropValues("patrol_excel_suffix.en");
			reportProperties.setPatrolExcelSuffixEn(patrolExcelSuffixEn);
			String patrolExcelSheetNameEn = getPropValues("patrol_excel_sheet_name.en");
			reportProperties.setPatrolExcelSheetNameEn(patrolExcelSheetNameEn);
			String inspectionExcelPrefixEn = getPropValues("inspection_excel_prefix.en");
			reportProperties.setInspectionExcelPrefixEn(inspectionExcelPrefixEn);
			String inspectionExcelSuffixEn = getPropValues("inspection_excel_suffix.en");
			reportProperties.setInspectionExcelSuffixEn(inspectionExcelSuffixEn);
			String inspectionExcelSheetNameEn = getPropValues("inspection_excel_sheet_name.en");
			reportProperties.setInspectionExcelSheetNameEn(inspectionExcelSheetNameEn);
			String patrolExcelPrefixTc = getPropValues("patrol_excel_prefix.tc");
			reportProperties.setPatrolExcelPrefixTc(patrolExcelPrefixTc);
			String patrolExcelSuffixTc = getPropValues("patrol_excel_suffix.tc");
			reportProperties.setPatrolExcelSuffixTc(patrolExcelSuffixTc);
			String patrolExcelSheetNameTc = getPropValues("patrol_excel_sheet_name.tc");
			reportProperties.setPatrolExcelSheetNameTc(patrolExcelSheetNameTc);
			String inspectionExcelPrefixTc = getPropValues("inspection_excel_prefix.tc");
			reportProperties.setInspectionExcelPrefixTc(inspectionExcelPrefixTc);
			String inspectionExcelSuffixTc = getPropValues("inspection_excel_suffix.tc");
			reportProperties.setInspectionExcelSuffixTc(inspectionExcelSuffixTc);
			String inspectionExcelSheetNameTc = getPropValues("inspection_excel_sheet_name.tc");
			reportProperties.setInspectionExcelSheetNameTc(inspectionExcelSheetNameTc);
			String reportDirectory = getPropValues("report_directory");
			reportProperties.setReportDirectory(reportDirectory);
			String noOfRecordsPerFileString = getPropValues("no_of_records_per_file");
			String saveExcelsToServerString = getPropValues("save_excels_to_server");
			Boolean saveExcelsToServer = Boolean.parseBoolean(saveExcelsToServerString);
			reportProperties.setSaveExcelsToServer(saveExcelsToServer);
			String saveCompressedFilesToServerString = getPropValues("save_compressed_files_to_server");
			Boolean saveCompressedFilesToServer = Boolean.parseBoolean(saveCompressedFilesToServerString);
			reportProperties.setSaveCompressedFilesToServer(saveCompressedFilesToServer);
			if (commonUtils == null) {
				commonUtils = utilsFactory.getInstanceOfCommonUtils();
			}
			
			if (noOfRecordsPerFileString != null && commonUtils.isInteger(noOfRecordsPerFileString)) {
				Integer noOfRecordsPerFile = null;
				noOfRecordsPerFile = Integer.parseInt(noOfRecordsPerFileString);
				reportProperties.setNoOfRecordsPerFile(noOfRecordsPerFile);
			}

		} catch (Exception e) {
			this.logger.error(getClassName() + ".build() - this.fileName=" + this.fileName, e);
			throw e;
		}
		return reportProperties;
	}
}
