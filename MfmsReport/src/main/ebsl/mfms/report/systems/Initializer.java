package ebsl.mfms.report.systems;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings("serial")
public class Initializer extends HttpServlet{
	private final Logger logger = LoggerFactory.getLogger(getClassName());
	private String getClassName(){
		return this.getClass().getName();
	}
	public void init() throws ServletException{
		try{

		} catch (Exception e){
			logger.error("InitializerImpl.init()", e);
		}
	}
}
