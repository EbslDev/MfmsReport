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
//http://localhost:8080/MfmsReport/rest/generateReportWs/test
//http://localhost:8080/MfmsReport/rest/generateReportWs/exportPatrolRoutine
@Path("/generateReportWs")
public class GenerateReportWs {
	private final Logger logger = LoggerFactory.getLogger(getClassName());
	
	private String getClassName(){
		return this.getClass().getName();
	}
	@GET
	@Path("/test")
	@Produces("text/plain")
	public String getAllConsolidateJob(){ 
		String returnString = "";
		try{
			returnString = "Test";
		}catch (Exception e){
			logger.error("ConsolidateJobsWs.getAllConsolidateJob() - Exception: ", e);
		}
		return returnString;
	}
	@GET
	@Path("/exportPatrolRoutine")
	@Produces("text/plain")
	public String exportPatrolRoutine(
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
			for(ExportPatrolRoutineVo vo: voList) {
				
			}
		}catch (Exception e){
			logger.error(getClassName() + ".generateReport() - Exception: ", e);
		}
		return returnString;
	}
	
}
