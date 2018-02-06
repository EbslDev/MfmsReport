package ebsl.mfms.report.resteasy.services;
import java.util.HashMap;
import java.util.Map;
import javax.ws.rs.GET;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
//import org.jboss.resteasy.annotations.providers.jackson.Formatted;
@Path("/employee")
public class EmployeeService {
    @GET
    @Path("/detail")
    @Produces("application/json")
//    @Formatted
    public Response detail(@MatrixParam("name") String name, @MatrixParam("age") Integer age) {
    	Map<String,String> map = new HashMap<String,String>();
    	map.put("name", name);
    	map.put("age", String.valueOf(age));
        return Response.ok(map).build();
    }
    @GET
    @Path("/fulldetail")
    @Produces("application/json")
//    @Formatted
    public Response fulldetail(@MatrixParam("name") String name, @MatrixParam("age") Integer age,
    		@QueryParam("location") String location) {
    	Map<String,String> map = new HashMap<String,String>();
    	map.put("name", name);
    	map.put("age", String.valueOf(age));
    	map.put("location", location);
        return Response.ok(map).build();
    }  
}
