package com.upmc.isd.galaxyapi.search.backend;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.inject.Singleton;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrResponse;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.CloudSolrClient;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.util.NamedList;

import com.upmc.isd.galaxyapi.search.common.LoggingUtilities;
import com.upmc.isd.galaxyapi.search.common.ResponseUtilities;
import com.upmc.isd.galaxyapi.search.model.HL7SearchResponse;
import com.upmc.isd.galaxyapi.search.model.SearchException;

/**
 * 
 * @author provosts
 *
 */


@Resource
public class SolrService extends SolrConnector{
	
	
	public SolrService(){
		super();
	}
	
	public HL7SearchResponse doHL7Operation(SolrOperation operation) throws SearchException{
		HL7SearchResponse response = null;
		
		try {
			QueryResponse queryResponse = super.getClient().query(operation.getCollection().trim(), operation.getSolrQuery());
			if(queryResponse.getStatus() == 404){
				throw new SearchException();
			}
			else{
				response = ResponseUtilities.mapToHL7Response(queryResponse);
				return response;
			}
			//response = super.getClient().query(operation.getSolrQuery());
		} catch (SolrServerException | IOException e) {
			throw new SearchException();
		}
	}
	
	public void doMARSOperation(SolrOperation operation) throws SearchException{
		QueryResponse response = null;
		
		try {
			response = super.getClient().query(operation.getCollection().trim(), operation.getSolrQuery());
			
			if(response.getStatus() == 404){
				throw new SearchException();
			}
			else{
				
			}
		} catch (SolrServerException | IOException e) {
			throw new SearchException();
		}
	}
}
