package com.upmc.isd.galaxyapi.search.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This class describes the input for a MARS Collection Search Request
 * @author provos_adm
 *
 */
public class MARSCollectionSearch {
	
	@JsonProperty("action")
	private String action;
	
	@JsonProperty("queryText")
	private String queryText;
	
	@JsonProperty("collection")
	private String collection;
	

	/**
	 * Get the action to be performed
	 * @return
	 */
	public String getAction(){
		return action;
	}
	
	/**
	 * Get the text of the query
	 * @return
	 */
	public String getQueryText(){
		return queryText;
	}
	
	/**
	 * Get the collection name
	 * @return
	 */
	public String getCollection(){
		return collection;
	}
	
	
	@Override
	public String toString(){
		return "";
	}
}
