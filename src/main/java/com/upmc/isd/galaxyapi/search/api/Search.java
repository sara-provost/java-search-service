package com.upmc.isd.galaxyapi.search.api;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.StreamingOutput;

import com.upmc.isd.galaxyapi.search.backend.SearchResultStream;

@Path("/search")
public class Search {

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	
	public SearchResultStream search(){
		return new SearchResultStream();
	}
}
