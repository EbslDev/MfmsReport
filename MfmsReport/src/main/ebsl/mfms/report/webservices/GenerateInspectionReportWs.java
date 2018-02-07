package ebsl.mfms.report.webservices;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ebsl.mfms.report.models.sos.ExportPatrolRoutineSo;
import ebsl.mfms.report.models.vos.ExportPatrolRoutineVo;
import ebsl.mfms.report.services.TblPatrolresultMgr;

//http://localhost:8080/MfmsReport/rest/generateInspectionReportWs/test
//http://localhost:8080/MfmsReport/rest/generateInspectionReportWs/requestInspectionJson
@Path("/generateInspectionReportWs")
public class GenerateInspectionReportWs {
	private final Logger logger = LoggerFactory.getLogger(getClassName());
	
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
	@Produces("text/plain")
	public String requestInspectionExcel(
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
			logger.error(getClassName() + ".requestInspectionExcel() - Exception: ", e);
		}
		return returnString;
	}
}
