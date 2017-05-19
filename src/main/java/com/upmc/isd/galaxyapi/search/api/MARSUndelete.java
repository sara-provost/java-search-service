package com.upmc.isd.galaxyapi.search.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.upmc.isd.galaxyapi.search.model.GalaxyError;
import com.upmc.isd.galaxyapi.search.model.mars.MARSCollectionSearch;

@Path("/marsundelete")
public class MARSUndelete {

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response undelete(MARSCollectionSearch search){
		GalaxyError error = new GalaxyError();
		error.setDescription("Test Response");
		error.setFriendlyMsg("This is a test message");
		error.setType("Test Undelete");
		
		return Response.ok(error, MediaType.APPLICATION_JSON).build();
	}
}
