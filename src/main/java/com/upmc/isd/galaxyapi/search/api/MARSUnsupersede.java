package com.upmc.isd.galaxyapi.search.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.upmc.isd.galaxyapi.search.backend.SolrOperation;
import com.upmc.isd.galaxyapi.search.model.GalaxyError;
import com.upmc.isd.galaxyapi.search.model.mars.MARSCollectionSearch;

@Path("/marsunsupersede")
public class MARSUnsupersede {

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response doUnSupersede(MARSCollectionSearch search){
		SolrOperation operation = new SolrOperation.Builder(search).build();
		
		if(!operation.getAction().equalsIgnoreCase("UNSUPERSEDE")){
			GalaxyError error = new GalaxyError();
			error.setFriendlyMsg("Incorrect Action for Endpoint");
			error.setDescription("Invalid Action");
			return Response.status(Status.BAD_REQUEST).entity(error).build();
		}
		return Response.ok().build();
	}
}
