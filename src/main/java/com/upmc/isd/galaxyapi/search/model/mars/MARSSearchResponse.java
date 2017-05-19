package com.upmc.isd.galaxyapi.search.model.mars;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MARSSearchResponse {
	
	public MARSSearchResponse(){}
	
	@JsonProperty("total")
	private long total;
	
	@JsonProperty("cursorMark")
	private String cursorMark;
	
	@JsonProperty("messages")
	private List<MARSMessage> messages;
	
	
	public void setTotal(long total){
		this.total = total;
	}
	
	public void setCursorMark(String cursorMark){
		this.cursorMark = cursorMark;
	}
	
	public void setMessages(List<MARSMessage> messages){
		this.messages = messages;
	}
	
	public long getTotal(){
		return total;
	}
	
	public String getCursorMark(){
		return cursorMark;
	}
	
	public List<MARSMessage> getMessages(){
		return messages;
	}
	
}
