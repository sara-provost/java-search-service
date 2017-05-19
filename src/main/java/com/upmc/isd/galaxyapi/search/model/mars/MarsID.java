package com.upmc.isd.galaxyapi.search.model.mars;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This class is meant to store the MARS mrn field from Solr. 
 * @author provos_adm
 *
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class MarsID {
	
	public MarsID(){}
	
	public MarsID(String id, String source){
		this.id = id;
		this.source = source;
	}
	
	@JsonProperty("id")
	private String id;
		
	@JsonProperty
	private String source;
	
	
	public String getSource(){
		return source;
	}
	
	public String getID(){
		return id;
	}
	
	public void setSource(String source){
		this.source = source;
	}
	
	public void setMRN(String id){
		this.id = id;
	}
}
