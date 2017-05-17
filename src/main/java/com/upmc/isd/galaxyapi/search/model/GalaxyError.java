package com.upmc.isd.galaxyapi.search.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * GalaxyError
 * This is the standard error as specifed in the document here: 
 * https://eti.shp.upmc.com/systemintegration/IIB/_layouts/15/WopiFrame.aspx?sourcedoc=/systemintegration/IIB/Shared%20Documents/Architecture/ETI%20-%20Message%20Router%20Transformation%20-%20Design.docx&action=default
 * @author provosts
 *
 */
public class GalaxyError{

	@JsonProperty("friendlyMsg")
	private String friendlyMsg;
	
	@JsonProperty("description")
	private String description;
	
	@JsonProperty("type")
	private String type;
	
	public void setFriendlyMsg(String fMsg){
		this.friendlyMsg = fMsg;
	}
	
	public void setDescription(String description){
		this.description = description;
	}
	
	public void setType(String type){
		this.type = type;
	}
}
