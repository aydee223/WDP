package uts.polsys.rest;

import javax.servlet.ServletContext;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import javax.xml.bind.JAXBException;
import uts.polsys.*;

import java.io.*;
import java.util.ArrayList;



//
// my url for rest
// http://localhost:8080/PolSys/rest/polSysApp/ 
//
@Path("/polSysApp")
public class PolSysService {
	@Context
	private ServletContext application;
	
	private PolSysApp getPolSysApp() throws JAXBException, IOException{
		synchronized (application) {
			PolSysApp polSysApp = (PolSysApp)application.getAttribute("polSysApp");
			if(polSysApp == null){
				polSysApp = new PolSysApp();
				polSysApp.setFilePath(application.getRealPath("WEB-INF/polling.xml"));
				application.setAttribute("polSysApp", polSysApp);
			}
			return polSysApp;
		}
	}
	
	@Path("polls")
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public PollResponder getPolls() throws JAXBException, IOException{
		return new PollResponder(getPolSysApp().getAllPolls());
	}
	
	//example request path http://localhost:8080/PolSys/rest/polSysApp/getPollsByUser?id=2
	@Path("pollsByUser")
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public PollResponder getPollsByUser(@QueryParam("id") String id) throws JAXBException, IOException{
		//System.out.println(creatorid);
		return new PollResponder(getPolSysApp().getPollsByUser(id));
	}
	
	@Path("pollsByStatus")
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public PollResponder getPollsByStatus(@QueryParam("status") String status) throws JAXBException, IOException{
		//System.out.println(creatorid);
		return new PollResponder(getPolSysApp().getPollsByStatus(status));
	}
	
	
}
