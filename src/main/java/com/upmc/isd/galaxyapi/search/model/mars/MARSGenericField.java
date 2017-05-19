package com.upmc.isd.galaxyapi.search.model.mars;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This class is meant to a generic object to store any field from Solr 
 * that has the code, codeSystem, and description fields. 
 * @author provos_adm
 *
 */

@JsonIgnoreProperties(ignoreUnknown=true)
public class MARSGenericField {
	
	public MARSGenericField(){}
	
	public MARSGenericField(String code, String codeSystem, String description){
		this.code = code;
		this.codeSystem = codeSystem;
		this.description = description;
	}
	
	@JsonProperty("code")
	private String code;
	
	@JsonProperty("codeSystem")
	private String codeSystem;
	
	@JsonProperty("description")
	private String description;
	
	public String getCode(){
		return code;
	}
	
	public String getCodeSystem(){
		return codeSystem;
	}
	
	public String getDescription(){
		return description;
	}
	
	
	public void setCode(String code){
		this.code = code;
	}
	
	public void setCodeSystem(String codeSystem){
		this.codeSystem = codeSystem;
	}
	
	public void setDescription(String description){
		this.description = description;
	}
}
