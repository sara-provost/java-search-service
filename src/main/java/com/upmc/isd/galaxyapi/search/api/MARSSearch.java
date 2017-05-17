package com.upmc.isd.galaxyapi.search.api;

import java.io.IOException;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.solr.client.solrj.SolrServerException;

import com.upmc.isd.galaxyapi.search.backend.SolrOperation;
import com.upmc.isd.galaxyapi.search.backend.SolrService;
import com.upmc.isd.galaxyapi.search.common.LoggingUtilities;
import com.upmc.isd.galaxyapi.search.model.GalaxyError;
import com.upmc.isd.galaxyapi.search.model.MARSCollectionSearch;
import com.upmc.isd.galaxyapi.search.model.SearchException;

@Path("/marssearch")
public class MARSSearch {
	
	@Inject
	private SolrService solrClient;
	
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response search(MARSCollectionSearch search){
		
		LoggingUtilities.log(search.toString());
		
		SolrOperation operation = new SolrOperation.Builder(search).build();
		
		if(!operation.getAction().equalsIgnoreCase("SEARCH")){
			GalaxyError error = new GalaxyError();
			error.setDescription("Invalid Action");
			
			return Response.status(Status.BAD_REQUEST).entity(error).build();
		}
		else{
			solrClient = new SolrService();
			
			try {
				solrClient.doMARSOperation(operation);
				return Response.ok("{'Response':'ok'}", MediaType.APPLICATION_JSON).build();
			} catch (SearchException e) {
				GalaxyError error = new GalaxyError();
				error.setDescription("Request could not be completed.");
				error.setFriendlyMsg(e.getMessage());
				return Response.status(500).entity(error).build();
			}
		}
		
	}
}


