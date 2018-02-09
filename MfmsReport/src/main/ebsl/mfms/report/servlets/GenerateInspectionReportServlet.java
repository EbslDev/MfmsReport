package ebsl.mfms.report.servlets;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ebsl.mfms.report.models.sos.ExportPatrolRoutineSo;
import ebsl.mfms.report.models.vos.ExportPatrolRoutineVo;
import ebsl.mfms.report.services.PatrolExcelMgr;
import ebsl.mfms.report.services.TblPatrolresultMgr;

public class GenerateInspectionReportServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	   private String message;

	   public void init() throws ServletException {
	      // Do required initialization
	      message = "Hello World";
	   }

	   public void doGet(HttpServletRequest request, HttpServletResponse response)
	      throws ServletException, IOException {
           ServletOutputStream os = null;
		   try {
			   response.setContentType("application/vnd.ms-excel");

				TblPatrolresultMgr manager = new TblPatrolresultMgr();
				ExportPatrolRoutineSo so = new ExportPatrolRoutineSo();
				so.setSiteKey(2);
				List<ExportPatrolRoutineVo> voList =  manager.readByExportPatrolRoutineSo(so);
				PatrolExcelMgr mgr = new PatrolExcelMgr();

				ByteArrayOutputStream baos = new ByteArrayOutputStream();	
				mgr.generateExcel(voList, baos);		
			   
				byte [] byteArray = baos.toByteArray();
				response.setContentLength(byteArray.length);
                os = response.getOutputStream();
                
                baos.writeTo(os);
                
                baos.close();
                os.flush();
                os.close();
			   response.setHeader("Content-Disposition", "inline; filename=download.xlsx");

		   } catch (Exception e) {
			   
		   }
	   }

	   public void destroy() {
	      // do nothing.
	   }
}
