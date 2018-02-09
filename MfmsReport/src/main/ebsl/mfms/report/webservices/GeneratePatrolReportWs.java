package ebsl.mfms.report.webservices;

import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.StreamingOutput;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import ebsl.mfms.report.models.sos.ExportPatrolRoutineSo;
import ebsl.mfms.report.models.vos.ExportPatrolRoutineVo;
import ebsl.mfms.report.services.PatrolExcelMgr;
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
//    @Produces("application/vnd.ms-excel")
    @Produces(MediaType.TEXT_PLAIN)
//	@Produces(MediaType.APPLICATION_OCTET_STREAM)
	public Response requestPatrolRoutineExcel(
			@QueryParam("siteKey") Integer siteKey,
			@QueryParam("resultStartDate") String resultStartDate,
			@QueryParam("resultEndDate") String resultEndDate,
			@QueryParam("routeKeyList") String routeKeyList,
			@QueryParam("routeLocationList") String routeLocationList
			){

		Response response = null;
		StreamingOutput  stream = null;
		try{
			TblPatrolresultMgr manager = new TblPatrolresultMgr();
			ExportPatrolRoutineSo so = new ExportPatrolRoutineSo();
			so.setSiteKey(2);
			List<ExportPatrolRoutineVo> voList =  manager.readByExportPatrolRoutineSo(so);
			PatrolExcelMgr mgr = new PatrolExcelMgr();

			ByteArrayOutputStream oStream = new ByteArrayOutputStream();
//			mgr.generateExcelAndSave(voList);	
			mgr.generateExcel(voList, oStream);			
			

	        stream = new StreamingOutput() {
	            @Override
	            public void write(OutputStream os) throws IOException, WebApplicationException {
	                os.write(oStream.toByteArray());
	                os.flush();
	            }
	        };
			
	
			ResponseBuilder builder = 
					Response.ok(stream, MediaType.APPLICATION_OCTET_STREAM)
				    .header("content-disposition",
				      "attachment; filename = patrol.xlsx");

			response = builder.build();

		}catch (Exception e){
			logger.error(getClassName() + ".requestPatrolRoutineExcel() - Exception: ", e);
		}
		return response;
	}
	
//	 @GET
//	 @Path("/download")
//	 public Response downloadPdfFile() {
//	  StreamingOutput fileStream = new StreamingOutput() {
//	   @Override
//	   public void write(java.io.OutputStream output) throws IOException,
//	     WebApplicationException {
//	    try {
//	     java.nio.file.Path path = Paths.get("/Report/patrol_excel20180802142602.xlsx");
//	     byte[] data = Files.readAllBytes(path);
//	     output.write(data);
//	     output.flush();
//	    } catch (Exception e) {
//	     throw new WebApplicationException("File Not Found !!");
//	    }
//	   }
//	  };
//	  return Response
//	    .ok(fileStream, MediaType.APPLICATION_OCTET_STREAM)
//	    .header("content-disposition",
//	      "attachment; filename = patrol.xlsx").build();
//	 }
	
}
