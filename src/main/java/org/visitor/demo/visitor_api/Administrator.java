package org.visitor.demo.visitor_api;


// api administrator endpoint for searching visitor entry
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.visitor.demo.visitor_store.visit_store;
import org.visitor.demo.visitor_store.visitor;
@Path("admin")
public class Administrator {
	
	visit_store d = new visit_store();
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
    public List<visitor> getAll(@QueryParam("name") String name ,@QueryParam("start") String start_Date ,@QueryParam("end") String end_date,@QueryParam("casetype") int t ) throws SQLException, ParseException
    {
    	switch(t) {
             
    	case 1:
    	 return d.view("visitor_name", name,null,t);	
    	 
    	case 2:
    		return d.view(start_Date,end_date,null, t);
    	
    	case 3:
    	   return d.view(name,start_Date,end_date,t);	
    	default :
    	 String st = null;
    	 return d.view("NULL", st,null,t);
    	
    	
    	}
    }
	

}
