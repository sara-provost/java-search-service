package com.upmc.isd.galaxyapi.search.api;

import java.io.IOException;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.StreamingOutput;

import org.apache.solr.client.solrj.SolrResponse;
import org.apache.solr.client.solrj.SolrServerException;

import javax.ws.rs.core.Response.Status;

import com.upmc.isd.galaxyapi.search.backend.SolrOperation;
import com.upmc.isd.galaxyapi.search.backend.SolrService;
import com.upmc.isd.galaxyapi.search.common.LoggingUtilities;
import com.upmc.isd.galaxyapi.search.model.GalaxyError;
import com.upmc.isd.galaxyapi.search.model.HL7CollectionSearch;
import com.upmc.isd.galaxyapi.search.model.HL7SearchResponse;
import com.upmc.isd.galaxyapi.search.model.SearchException;

@Path("/hl7search")
public class HL7Search {

	@Inject
	private SolrService solrClient;
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response search(HL7CollectionSearch search){
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
					HL7SearchResponse response = solrClient.doHL7Operation(operation);
					
					if(response != null){
						return Response.ok(response, MediaType.APPLICATION_JSON).build();
					}
					return Response.status(500).build();
				} catch (SearchException e) {
					return Response.status(500).entity(e.getGalaxyError()).build();
				}
			
		}	
	}
}
