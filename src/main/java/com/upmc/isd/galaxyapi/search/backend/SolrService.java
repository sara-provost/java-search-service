package com.upmc.isd.galaxyapi.search.backend;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.impl.CloudSolrClient;
import org.apache.solr.client.solrj.impl.HttpSolrClient;

/**
 * 
 * @author provosts
 *
 */
public class SolrService {
	
	
	private static final Collection<String> ZKHOSTS = Arrays.asList("z01dev01.isd.upmc.edu:2181/solr");
	private static final String URL_STRING = "http://z01dev01.isd.upmc.edu:8983/solr/";
	
	private SolrClient client;
	private CloudSolrClient cloudClient;
	
	/**
	 * initialize the connection to Solr.
	 */
	private void initializeClient(){
		client = new HttpSolrClient.Builder(URL_STRING).build();
	}
	
	/**
	 * initialize the connection to Solr Cloud. 
	 */
	private void initializeCloudClient(){
		cloudClient = new CloudSolrClient.Builder().withZkHost(ZKHOSTS).build();
		cloudClient.setIdField("RECKEY");		
		cloudClient.setZkConnectTimeout(300000);
		cloudClient.setRetryExpiryTime(5);
		cloudClient.connect();
	}
	
	/**
	 * Return the CloudSolrClient instance
	 * @return
	 */
	public CloudSolrClient getCloudClient(){
		if(this.cloudClient != null){
			initializeCloudClient();
		}
		
		return cloudClient;
	}
	
	/**
	 * Return the Solr Client instance. 
	 * @return
	 */
	public SolrClient getClient(){
		if(this.client != null){
			initializeCloudClient();
		}
		
		return client;
	}
	
	/**
	 * Close the connection to Solr
	 * @throws IOException
	 */
	public void close() throws IOException{
		cloudClient.close();
		client.close();
	}
}
