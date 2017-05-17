package com.upmc.isd.galaxyapi.search.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MARSSearchResponse {
	
	public MARSSearchResponse(){}
	
	@JsonProperty("total")
	private int total;
	
	@JsonProperty("cursorMark")
	private String cursorMark;
	
	@JsonProperty("messages")
	private List<MARSMessage> messages;
}
