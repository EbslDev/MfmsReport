package ebsl.mfms.report.resteasy.services;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import javafx.application.Application;
import javafx.stage.Stage;
@ApplicationPath("/generateReportApplication")
public class ReportGeneratorApplication extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub

	}
	   @GET
	   @Path("/books")
	   public String getBooks() {
		   return "Book";
		}
}
