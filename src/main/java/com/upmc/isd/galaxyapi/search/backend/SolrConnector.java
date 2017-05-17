package com.upmc.isd.galaxyapi.search.backend;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.impl.NoOpResponseParser;

public class SolrConnector {
	
	private static final Collection<String> ZKHOSTS = Arrays.asList("z01dev01.isd.upmc.edu:2181/solr");
	private static final String URL_STRING = "http://z01dev00.isd.upmc.edu:8983/solr/";
	
	private SolrClient client;
	
	public SolrConnector(){
		client = new HttpSolrClient.Builder(URL_STRING).build();
	}
	
	public SolrClient getClient(){
		return client;
	}
	
	public void close() throws IOException{
		client.close();
	}
}
