package com.upmc.isd.galaxyapi.search.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.upmc.isd.galaxyapi.search.common.LoggingUtilities;

/**
 * This is a stub class to provide the API specification of this service. 
 * @author provosts
 *
 */

@Path("/docs")
public class APISpecification {
	@GET
	@Produces(MediaType.TEXT_HTML)

	public Response getDocumentation(){
		return Response.ok().build();
	}
}
