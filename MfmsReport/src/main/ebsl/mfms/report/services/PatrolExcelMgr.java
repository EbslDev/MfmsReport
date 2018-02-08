package ebsl.mfms.report.services;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.ServletOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ebsl.mfms.report.bundles.ReportProperties;
import ebsl.mfms.report.factories.PropertiesFactory;
import ebsl.mfms.report.factories.UtilsFactory;
import ebsl.mfms.report.models.vos.ExportPatrolRoutineVo;
import ebsl.mfms.report.utils.CommonUtils;
import ebsl.mfms.report.utils.FileUtils;
public class PatrolExcelMgr extends ServiceBase{
	private final Logger logger = LoggerFactory.getLogger(getClassName());
	private PropertiesFactory propertiesFactory;
	private ReportProperties reportProperties;
	private UtilsFactory utilsFactory;
	private CommonUtils commonUtils;
	private FileUtils fileUtils;
	private final String EXCEL_EXT = ".xlsx";
	public PatrolExcelMgr() throws Exception{
		try {
			propertiesFactory = PropertiesFactory.getInstanceOfPropertiesFactory();
			reportProperties = propertiesFactory.getInstanceOfReportProperties();
			utilsFactory = UtilsFactory.getInstance();
			commonUtils = utilsFactory.getInstanceOfCommonUtils();
			fileUtils = utilsFactory.getInstanceOfFileUtils();
		} catch (Exception e) {
			logger.error(getClassName() + ".PatrolExcelMgr()" , e);
			throw e;
		}

	}
	private String getClassName(){
		return this.getClass().getName();
	}
	
	public void generateExcelAndSave(List<ExportPatrolRoutineVo> exportPatrolRoutineVoList) throws Exception {
		try{
			generateExcel(exportPatrolRoutineVoList, null);
			
		} catch (Exception e){
			logger.error(getClassName() + ".generateExcel() - exportPatrolRoutineVoList=" + exportPatrolRoutineVoList, e);
			throw e;
		}
	}
	public void generateExcel(List<ExportPatrolRoutineVo> exportPatrolRoutineVoList, ByteArrayOutputStream  out) throws Exception {
		String rootDir = null;
		String fileName = null;
		String fileNamePrefix = null;
		String fileNameSuffix = null;
		XSSFWorkbook workbook = null;
		XSSFSheet sheet = null;
		FileOutputStream outputStream = null;
		
		try{
			workbook = new XSSFWorkbook();
			sheet = workbook.createSheet("PatrolRoutine");
			rootDir = reportProperties.getReportDirectory();
			fileNamePrefix = reportProperties.getPatrolExcelPrefix();
			fileNameSuffix = reportProperties.getPatrolExcelSuffix();
			fileName =rootDir + "/" + fileNamePrefix + "_" + fileNameSuffix +  commonUtils.genTimestampString() + EXCEL_EXT;
			fileUtils.createDirectoryIfNotExisted(rootDir);
			for (int r =0; r < exportPatrolRoutineVoList.size(); r++) {
				ExportPatrolRoutineVo vo = exportPatrolRoutineVoList.get(r);
				Row row = sheet.createRow(r);
				Cell cell0 = row.createCell(0); 
				cell0.setCellValue(vo.getRouteCode());
				Cell cell1 = row.createCell(1);
				cell1.setCellValue(vo.getCollectionDateTime());
				Cell cell2 = row.createCell(2);
				cell2.setCellValue(vo.getLocationCode());
				Cell cell3 = row.createCell(3);
				cell3.setCellValue(vo.getLocationName());
				Cell cell4 = row.createCell(4);
				cell4.setCellValue(vo.getReadingResult());	
			}
			if (out == null) { // write to file Directly
				outputStream = new FileOutputStream(fileName);
				workbook.write(outputStream);
			} else {
				workbook.write(out);
			}
	
//			workbook.close();
			
		} catch (Exception e){
			logger.error(getClassName() + ".generateExcel() - exportPatrolRoutineVoList=" + exportPatrolRoutineVoList, e);
			throw e;
		} finally {
			if (workbook != null) {
				workbook = null;
			}
			if (outputStream != null) {
				outputStream.close();
				outputStream = null;
			}
		}
	}
}
