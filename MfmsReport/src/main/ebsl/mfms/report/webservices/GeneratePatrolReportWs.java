package ebsl.mfms.report.webservices;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import ebsl.mfms.report.models.sos.ExportPatrolRoutineSo;
import ebsl.mfms.report.models.vos.ExportPatrolRoutineVo;
import ebsl.mfms.report.services.TblPatrolresultMgr;
//http://localhost:8080/MfmsReport/rest/generatePatrolReportWs/test
//http://localhost:8080/MfmsReport/rest/generatePatrolReportWs/exportPatrolRoutine
@Path("/generatePatrolReportWs")
public class GeneratePatrolReportWs {
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
			returnString = "Test return from GeneratePatrolReportWs()";
		}catch (Exception e){
			logger.error(getClassName() + ".getAllConsolidateJob() - Exception: ", e);
		}
		return returnString;
	}
	@GET
	@Path("/requestPatrolRoutineJson")
	@Produces("text/plain")
	public String requestPatrolRoutineJson(
			@QueryParam("siteKey") Integer siteKey,
			@QueryParam("resultStartDate") String resultStartDate,
			@QueryParam("resultEndDate") String resultEndDate,
			@QueryParam("routeKeyList") String routeKeyList,
			@QueryParam("routeLocationList") String routeLocationList
			){ 
		String returnString = "";
		try{
			TblPatrolresultMgr manager = new TblPatrolresultMgr();
			ExportPatrolRoutineSo so = new ExportPatrolRoutineSo();
			so.setSiteKey(2);
			List<ExportPatrolRoutineVo> voList =  manager.readByExportPatrolRoutineSo(so);
			Gson gson = new GsonBuilder().create();
			returnString = gson.toJson(voList);
			 
		}catch (Exception e){
			logger.error(getClassName() + ".requestPatrolRoutineJson() - Exception: ", e);
		}
		return returnString;
	}
	@GET
	@Path("/requestPatrolRoutineExcel")
	@Produces("text/plain")
	public String requestPatrolRoutineExcel(
			@QueryParam("siteKey") Integer siteKey,
			@QueryParam("resultStartDate") String resultStartDate,
			@QueryParam("resultEndDate") String resultEndDate,
			@QueryParam("routeKeyList") String routeKeyList,
			@QueryParam("routeLocationList") String routeLocationList
			){ 
		String returnString = "";
		try{
			TblPatrolresultMgr manager = new TblPatrolresultMgr();
			ExportPatrolRoutineSo so = new ExportPatrolRoutineSo();
			so.setSiteKey(2);
			List<ExportPatrolRoutineVo> voList =  manager.readByExportPatrolRoutineSo(so);

			 
		}catch (Exception e){
			logger.error(getClassName() + ".requestPatrolRoutineExcel() - Exception: ", e);
		}
		return returnString;
	}
}
