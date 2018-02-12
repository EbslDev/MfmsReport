package ebsl.mfms.report.servlets;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ebsl.mfms.report.bundles.ReportProperties;
import ebsl.mfms.report.factories.PropertiesFactory;
import ebsl.mfms.report.factories.UtilsFactory;
import ebsl.mfms.report.models.sos.ExportPatrolRoutineSo;
import ebsl.mfms.report.models.vos.ExportPatrolRoutineVo;
import ebsl.mfms.report.services.PatrolExcelMgr;
import ebsl.mfms.report.services.TblPatrolresultMgr;
import ebsl.mfms.report.utils.CommonUtils;
import ebsl.mfms.report.utils.DateUtils;
import ebsl.mfms.report.utils.FileUtils;

@SuppressWarnings("serial")
public class GeneratePatrolReportServlet extends HttpServlet {
	private final Logger logger = LoggerFactory.getLogger(getClassName());
	private PropertiesFactory propertiesFactory;
	private ReportProperties reportProperties;
	private UtilsFactory utilsFactory;
	private CommonUtils commonUtils;
	private FileUtils fileUtils;
	private DateUtils dateUtils;
	private final String EXCEL_EXT = ".xlsx";
	private String getClassName(){
		return this.getClass().getName();
	}

	public void init() throws ServletException {
		try {
			propertiesFactory = PropertiesFactory.getInstanceOfPropertiesFactory();
			reportProperties = propertiesFactory.getInstanceOfReportProperties();
			utilsFactory = UtilsFactory.getInstance();
			commonUtils = utilsFactory.getInstanceOfCommonUtils();
			fileUtils = utilsFactory.getInstanceOfFileUtils();
			dateUtils = utilsFactory.getInstanceOfDateUtils();
		} catch (Exception e) {
			logger.error(getClassName() + ".ServletException() - Exception: ", e);
		}
	}	

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletOutputStream os = null;
		ByteArrayOutputStream baos = null;
		String rootDir = null;
		String fileName = null;
		String fileNamePrefix = null;
		String fileNameSuffix = null;
		try {
			String siteKeyString = request.getParameter("siteKey");
			String resultStartDateString = request.getParameter("resultStartDate");
			String resultEndDateString = request.getParameter("resultSEndDate");
			String routeKeyListString = request.getParameter("routeKeyList");
			String routeLocationListString = request.getParameter("routeLocationList");

			Integer siteKey = null;
			Date resultStartDate = null;
			Date resultEndDate = null;
			List<String> routeKeyList = null;
			List<String> routeLocationKeyList = null;
			
			
			if (siteKeyString != null && commonUtils.isInteger(siteKeyString)) {
				siteKey = Integer.parseInt(siteKeyString);
			}
			
			if (resultStartDateString != null) {
				resultStartDate = dateUtils.convertParamDateTimeString2Date(resultStartDateString);
			}
			if (resultEndDateString != null) {
				resultEndDate = dateUtils.convertParamDateTimeString2Date(resultEndDateString);
			}
			
			if (routeKeyListString != null) {
				routeKeyList = commonUtils.splitByDelimited(routeKeyListString, ",");
			}
			if (routeLocationListString != null) {
				routeLocationKeyList = commonUtils.splitByDelimited(routeLocationListString, ",");
			}
			
			
			ExportPatrolRoutineSo so = new ExportPatrolRoutineSo();
			if (siteKey != null) {
				so.setSiteKey(siteKey);
			}
			
			if (resultStartDate != null) {
				so.setResultStartDate(resultStartDate);
			}
			
			if (resultEndDate != null) {
				so.setResultEndDate(resultEndDate);
			}
			
			if (routeKeyList != null) {
				so.setRouteKeyList(routeKeyList);
			}
			if (routeLocationKeyList != null) {
				so.setRouteLocationKeyList(routeLocationKeyList);
			}
			
			
			response.setContentType("application/vnd.ms-excel");

			TblPatrolresultMgr manager = new TblPatrolresultMgr();

			List<ExportPatrolRoutineVo> voList = manager.readByExportPatrolRoutineSo(so);
			PatrolExcelMgr mgr = new PatrolExcelMgr();

			baos = new ByteArrayOutputStream();
			//TODO uncomment the function after finished
//			mgr.generateExcel(voList, baos);

			byte[] byteArray = baos.toByteArray();
			response.setContentLength(byteArray.length);
			os = response.getOutputStream();

			baos.writeTo(os);

			rootDir = reportProperties.getReportDirectory();
			fileNamePrefix = reportProperties.getPatrolExcelPrefix();
			fileNameSuffix = reportProperties.getPatrolExcelSuffix();
			fileName = fileNamePrefix + "_" + fileNameSuffix +  commonUtils.genTimestampString() + EXCEL_EXT;

			response.setHeader("Content-Disposition", "inline; filename=\""+ fileName + "\"");

		} catch (Exception e) {
			logger.error(getClassName() + ".doGet() - Exception: ", e);
		} finally {
			if (baos != null) {
				baos.close();		
				baos = null;
			}
			if (os != null) {
				os.flush();
				os.close();
				os = null;
			}
		}
	}

	public void destroy() {
		// do nothing.
	}
}
