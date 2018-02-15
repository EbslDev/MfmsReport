package ebsl.mfms.report.webservices;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
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

import ebsl.mfms.report.bundles.ReportProperties;
import ebsl.mfms.report.factories.PropertiesFactory;
import ebsl.mfms.report.factories.UtilsFactory;
import ebsl.mfms.report.models.dtos.CompressFileDto;
import ebsl.mfms.report.models.sos.ExportPatrolRoutineSo;
import ebsl.mfms.report.models.vos.ExportPatrolRoutineVo;
import ebsl.mfms.report.services.PatrolExcelMgr;
import ebsl.mfms.report.services.TblPatrolresultMgr;
import ebsl.mfms.report.utils.CommonUtils;
import ebsl.mfms.report.utils.DateUtils;
import ebsl.mfms.report.utils.FileUtils;
//http://localhost:8080/MfmsReport/generatePatrolReportWs/test
//http://localhost:8080/MfmsReport/generatePatrolReportWs/requestPatrolRoutineJson
@Path("/generatePatrolReportWs")
public class GeneratePatrolReportWs {
	private final Logger logger = LoggerFactory.getLogger(getClassName());
	private PropertiesFactory propertiesFactory;
	private ReportProperties reportProperties;
	private UtilsFactory utilsFactory;
	private CommonUtils commonUtils;
	private FileUtils fileUtils;
	private DateUtils dateUtils;
	private final String EXCEL_EXT = ".xlsx";
	private final String ZIP_EXT = ".zip";
	
	public GeneratePatrolReportWs() {
		try {
			propertiesFactory = PropertiesFactory.getInstanceOfPropertiesFactory();
			reportProperties = propertiesFactory.getInstanceOfReportProperties();
			utilsFactory = UtilsFactory.getInstance();
			commonUtils = utilsFactory.getInstanceOfCommonUtils();
			fileUtils = utilsFactory.getInstanceOfFileUtils();
			dateUtils = utilsFactory.getInstanceOfDateUtils();
		} catch (Exception e) {
			logger.error(getClassName() + ".GeneratePatrolReportWs() - Exception: ", e);
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
			returnString = "Test return from GeneratePatrolReportWs()";
		}catch (Exception e){
			logger.error(getClassName() + ".getAllConsolidateJob() - Exception: ", e);
		}
		return returnString;
	}
	@GET
	@Path("/requestPatrolRoutineJson")
	@Produces(MediaType.APPLICATION_JSON)
	public Response requestPatrolRoutineJson(
			@QueryParam("siteKey") Integer siteKey,
			@QueryParam("resultStartDate") String resultStartDate,
			@QueryParam("resultEndDate") String resultEndDate,
			@QueryParam("routeKeyList") String routeKeyList,
			@QueryParam("routeLocationList") String routeLocationList
			){ 
		String returnString = "";
		Response response = null;
		try{
			TblPatrolresultMgr manager = new TblPatrolresultMgr();
			ExportPatrolRoutineSo so = new ExportPatrolRoutineSo();
			so.setSiteKey(2);
			List<ExportPatrolRoutineVo> voList =  manager.readByExportPatrolRoutineSo(so);
			Gson gson = new GsonBuilder().create();
			returnString = gson.toJson(voList);
			
			ResponseBuilder builder = Response.status(201).entity(returnString);
			response = builder.build();
			 
		}catch (Exception e){
			logger.error(getClassName() + ".requestPatrolRoutineJson() - Exception: ", e);
		}
		return response;
	}
	@GET
	@Path("/requestPatrolRoutineExcel")
//    @Produces("application/vnd.ms-excel")
    @Produces(MediaType.TEXT_PLAIN)
//	@Produces(MediaType.APPLICATION_OCTET_STREAM)
	public Response requestPatrolRoutineExcel(
			@QueryParam("siteKey") String siteKeyString,
			@QueryParam("resultStartDate") String resultStartDateString,
			@QueryParam("resultEndDate") String resultEndDateString,
			@QueryParam("routeKeyList") String routeKeyListString,
			@QueryParam("routeLocationList") String routeLocationListString
			){
		String rootDir = null;
		String fileName = null;
		String fileNamePrefix = null;
		String fileNameSuffix = null;
		Response response = null;
		StreamingOutput  stream = null;
		try{
			
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
			
			
			TblPatrolresultMgr manager = new TblPatrolresultMgr();
			List<ExportPatrolRoutineVo> voList =  manager.readByExportPatrolRoutineSo(so);
			PatrolExcelMgr mgr = new PatrolExcelMgr();

//			List<ByteArrayOutputStream> byteArrayOutputStreamList = new ArrayList<ByteArrayOutputStream>();
//			mgr.generateExcelAndSave(voList);	
		
			List<CompressFileDto> compressFileDtoList = new ArrayList<CompressFileDto>();
			
			mgr.generateExcels(voList, compressFileDtoList);
			Boolean saveExcelsToServer = reportProperties.getSaveExcelsToServer();
			if (saveExcelsToServer) {
				mgr.generateExcelAndSave(voList);
			}
			
			final ByteArrayOutputStream byteArrayOutputStream = mgr.compressByteArrayOutputStreamList(compressFileDtoList);
			
			Boolean saveCompressedFileToServer = reportProperties.getSaveCompressedFilesToServer();
			if (saveCompressedFileToServer && compressFileDtoList != null && compressFileDtoList.size() > 0) {
				mgr.compressByteArrayOutputStreamListAndSave(compressFileDtoList);
			}
			
//			mgr.generateExcel(voList, oStream);			
			

	        stream = new StreamingOutput() {
	            @Override
	            public void write(OutputStream os) throws IOException, WebApplicationException {
	                os.write(byteArrayOutputStream.toByteArray());
	                os.flush();
	            }
	        };
			
	        
			propertiesFactory = PropertiesFactory.getInstanceOfPropertiesFactory();
			reportProperties = propertiesFactory.getInstanceOfReportProperties();
			utilsFactory = UtilsFactory.getInstance();
			commonUtils = utilsFactory.getInstanceOfCommonUtils();
			fileUtils = utilsFactory.getInstanceOfFileUtils();
			dateUtils = utilsFactory.getInstanceOfDateUtils();
	        
			rootDir = reportProperties.getReportDirectory();
			fileNamePrefix = reportProperties.getPatrolExcelPrefix();
			fileNameSuffix = reportProperties.getPatrolExcelSuffix();
			fileName = fileNamePrefix + "_" + fileNameSuffix +  commonUtils.genTimestampString() + ZIP_EXT;

	        
	
			ResponseBuilder builder = 
					Response.ok(stream, MediaType.APPLICATION_OCTET_STREAM)
				    .header("content-disposition",
				      "attachment; filename = \"" + fileName + "\"");

			response = builder.build();

		}catch (Exception e){
			logger.error(getClassName() + ".requestPatrolRoutineExcel() - siteKey=" + siteKeyString + 
					",resultStartDate=" + resultStartDateString + ",resultEndDate=" + resultEndDateString + 
					",routeKeyList=" + routeKeyListString + ",routeLocationList=" + routeLocationListString, e);
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
