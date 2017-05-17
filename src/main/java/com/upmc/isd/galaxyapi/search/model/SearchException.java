package com.upmc.isd.galaxyapi.search.model;

public class SearchException extends Exception{
	
	private GalaxyError error;

	
	public SearchException(){}
	
	public SearchException(GalaxyError error){
		this.error = error;
	}
	
	public void setGalaxyError(GalaxyError error){
		this.error = error;
	}
	
	public GalaxyError getGalaxyError(){
		return error;
	}
}
