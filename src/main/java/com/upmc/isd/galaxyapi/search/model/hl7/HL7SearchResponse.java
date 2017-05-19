package com.upmc.isd.galaxyapi.search.model.hl7;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * @author provos_adm
 *
 */
public class HL7SearchResponse {
	
	public HL7SearchResponse(){}
	
	@JsonProperty("total")
	private long total;
	
	@JsonProperty("totalAcks")
	private int totalAcks;
	
	@JsonProperty("cursorMark")
	private String cursorMark;
	
	@JsonProperty("messages")
	private List<HL7Message> messages;
	
	public long getTotal(){
		return total;
	}
	
	public void setTotal(long total){
		this.total = total;
	}
	
	public int getTotalAcks(){
		return totalAcks;
	}
	
	public void setTotalAcks(int totalAcks){
		this.totalAcks = totalAcks;
	}
	
	public List<HL7Message> getMessages(){
		return messages;
	}
	
	public void setMessages(List<HL7Message> messages){
		this.messages = messages;
	}
	
	public String getCursorMark(){
		return cursorMark;
	}
	
	public void setCursorMark(String cursorMark){
		this.cursorMark = cursorMark;
	}
}
