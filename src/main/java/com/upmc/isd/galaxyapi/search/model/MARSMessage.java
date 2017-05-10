package com.upmc.isd.galaxyapi.search.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This class defines what will be returned by a mars query. 
 * @author provos_adm
 *
 */
public class MARSMessage {
	
	@JsonProperty("subtype")
	private String subtype;
	
	@JsonProperty("spno")
	private String spno;
	
	@JsonProperty("recordDate")
	private String recordDate;
	
	@JsonProperty("pqno")
	private String pqno;
	
	@JsonProperty("sendingApplication")
	private String sendingApplication;
	
	@JsonProperty("facility")
	private String facility;
	
	@JsonProperty("patientName")
	private String patientName;
	
	@JsonProperty("mrn")
	private String mrn;
	
	@JsonProperty("recordBody")
	private String recordBody;
	
	/**
	 * Get type.description. 
	 * @return
	 */
	public String getSubtype(){
		return subtype;
	}
	
	/**
	 * Get the spno (unique identifier from the sending application).
	 * @return
	 */
	public String getSPNO(){
		return spno;
	}
	
	/**
	 * Get the record date
	 * @return
	 */
	public String getRecordDate(){
		return recordDate;
	}
	
	/**
	 * Get the pqno (the parsing time).
	 * @return
	 */
	public String getPQNO(){
		return pqno;
	}
	
	/**
	 * Get the sending application.
	 * @return
	 */
	public String getSendingApplication(){
		return sendingApplication;
	}
	
	/**
	 * get the facility.
	 * @return
	 */
	public String getFacility(){
		return facility;
	}
	
	/**
	 * Get the patient name.
	 * @return
	 */
	public String getPatientName(){
		return patientName;
	}
	
	/**
	 * Get the medical record number.
	 * @return
	 */
	public String getMRN(){
		return mrn;
	}
	
	/**
	 * Get the record body. 
	 * @return
	 */
	public String getRecordBody(){
		return recordBody;
	}
	
}
