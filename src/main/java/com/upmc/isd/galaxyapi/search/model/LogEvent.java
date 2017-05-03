package com.upmc.isd.galaxyapi.search.model;


public class LogEvent {
	private Integer logType;
	private String user; //TODO:add a real user object 
	private String value;
	private Boolean FairWarning;
	
	/**
	 * Set the logType ie the search type
	 * TODO:handle unknown collection?
	 * @param collection
	 * @throws Exception
	 */
	public void setLogType(String collection){
		if(collection.equals("UPMC_hl7")){
			this.logType = LogType.SEARCH_HL7.eventType();
		}
		else if(collection.equals("UPMC_mars")){
			this.logType = LogType.SEARCH_MARS.eventType();
		}
		else{
			this.logType = LogType.UNKNOWN.eventType();
		}
	}
	
	/**
	 * Set the user of the event
	 * @param user
	 */
	public void setUser(String user){
		this.user = user;
	}
	
	/**
	 * Value: string - a description of what happened or what changed in the event
	 * @param value
	 */
	public void setValue(String value){
		this.value = value;
	}
	
	/**
	 * FairWarning: boolean - whether to also log the event in the Fair Warning system
	 * @param b
	 */
	public void setFairWarning(boolean b){
		this.FairWarning = b;
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("type:" + logType + "\n");
		sb.append("user:" + user + "\n");
		sb.append("value:" + value + "\n");
		sb.append("FairWarning:" + FairWarning.booleanValue() + "\n");
		return sb.toString();
	}
	
	//TODO: add formatting for logging to FairWarning
	public String toFairWarningString(){
		StringBuilder sb = new StringBuilder();
		
		return sb.toString();
	}
}
