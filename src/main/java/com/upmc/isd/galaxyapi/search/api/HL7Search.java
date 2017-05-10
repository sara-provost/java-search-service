package com.upmc.isd.galaxyapi.search.api;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.StreamingOutput;

import com.upmc.isd.galaxyapi.search.backend.SearchResultStream;

@Path("/hl7search")
public class HL7Search {

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	
	public Response search(){
		return Response.ok("Good Response", MediaType.APPLICATION_JSON).build();
		
	}
}
