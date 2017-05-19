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

@Path("/marsdelete")
public class MARSDelete {
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteAction(MARSCollectionSearch search){
		
		SolrOperation operation = new SolrOperation.Builder(search).build();
		if(!operation.getAction().equalsIgnoreCase("DELETE") || !operation.getAction().equalsIgnoreCase("UNDELETE")){
			GalaxyError error = new GalaxyError();
			error.setFriendlyMsg("Invalid Action for endpoint");
			error.setDescription("Invalid Action");
			return Response.status(Status.BAD_REQUEST).entity(error).build();
		}
		
		return Response.ok().build();
	}
}
