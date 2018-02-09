package ebsl.mfms.report.webservices;

import java.util.List;

import javax.servlet.ServletException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ebsl.mfms.report.bundles.ReportProperties;
import ebsl.mfms.report.factories.PropertiesFactory;
import ebsl.mfms.report.factories.UtilsFactory;
import ebsl.mfms.report.models.sos.ExportPatrolRoutineSo;
import ebsl.mfms.report.models.vos.ExportPatrolRoutineVo;
import ebsl.mfms.report.services.TblPatrolresultMgr;
import ebsl.mfms.report.utils.CommonUtils;
import ebsl.mfms.report.utils.DateUtils;
import ebsl.mfms.report.utils.FileUtils;

//http://localhost:8080/MfmsReport/generateInspectionReportWs/test
//http://localhost:8080/MfmsReport/generateInspectionReportWs/requestInspectionJson
@Path("/generateInspectionReportWs")
public class GenerateInspectionReportWs {
	private final Logger logger = LoggerFactory.getLogger(getClassName());
	private PropertiesFactory propertiesFactory;
	private ReportProperties reportProperties;
	private UtilsFactory utilsFactory;
	private CommonUtils commonUtils;
	private FileUtils fileUtils;
	private DateUtils dateUtils;
	private final String EXCEL_EXT = ".xlsx";
	
	public void init() throws ServletException {
		try {
			propertiesFactory = PropertiesFactory.getInstanceOfPropertiesFactory();
			reportProperties = propertiesFactory.getInstanceOfReportProperties();
			utilsFactory = UtilsFactory.getInstance();
			commonUtils = utilsFactory.getInstanceOfCommonUtils();
			fileUtils = utilsFactory.getInstanceOfFileUtils();
			dateUtils = utilsFactory.getInstanceOfDateUtils();
		} catch (Exception e) {
			logger.error(getClassName() + ".GenerateInspectionReportWs() - Exception: ", e);
		}
	}	
	private String getClassName(){
		return this.getClass().getName();
	}
	
	@GET
	@Path("/test")
	@Produces("text/plain")
	public String test(){ 
		String returnString = "";
		try{
			returnString = "Test return from GenerateInspectionReportWs()";
		}catch (Exception e){
			logger.error(getClassName() + ".GenerateInspectionReportWs() - Exception: ", e);
		}
		return returnString;
	}
	
	@GET
	@Path("/requestInspectionJson")
	@Produces("text/plain")
	public String requestInspectionJson(
			@QueryParam("xxx") Integer siteKey,
			@QueryParam("xxx") String resultStartDate,
			@QueryParam("xxx") String resultEndDate,
			@QueryParam("xxx") String routeKeyList,
			@QueryParam("xxx") String routeLocationList
			){ 
		String returnString = "";
		try{
//			TblPatrolresultMgr manager = new TblPatrolresultMgr();
//			ExportPatrolRoutineSo so = new ExportPatrolRoutineSo();
//			so.setSiteKey(2);
//			List<ExportPatrolRoutineVo> voList =  manager.readByExportPatrolRoutineSo(so);
//			for(ExportPatrolRoutineVo vo: voList) {
//				
//			}
		}catch (Exception e){
			logger.error(getClassName() + ".requestInspectionJson() - Exception: ", e);
		}
		return returnString;
	}
	@GET
	@Path("/requestInspectionExcel")
	@Produces(MediaType.APPLICATION_JSON)
	public Response requestInspectionExcel(
			@QueryParam("xxx") Integer siteKey,
			@QueryParam("xxx") String resultStartDate,
			@QueryParam("xxx") String resultEndDate,
			@QueryParam("xxx") String routeKeyList,
			@QueryParam("xxx") String routeLocationList
			){ 
		String returnString = "";
		Response response = null;
		try{
//			TblPatrolresultMgr manager = new TblPatrolresultMgr();
//			ExportPatrolRoutineSo so = new ExportPatrolRoutineSo();
//			so.setSiteKey(2);
//			List<ExportPatrolRoutineVo> voList =  manager.readByExportPatrolRoutineSo(so);
//			for(ExportPatrolRoutineVo vo: voList) {
//				
//			}
			
			ResponseBuilder builder = Response.status(201).entity(returnString);
			response = builder.build();
		}catch (Exception e){
			logger.error(getClassName() + ".requestInspectionExcel() xxx=" + siteKey + ",xxx=" + resultStartDate, e);
		}
		return response;
	}
}
