package com.upmc.isd.galaxyapi.search.model.mars;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This class defines what will be returned by a mars query. 
 * @author provos_adm
 *
 */
public class MARSMessage {
	
	@JsonProperty("key")
	private String key;
	
	@JsonProperty("subtype")
	private String subtype;
	
	@JsonProperty("spno")
	private String spno;
	
	@JsonProperty("recordDate")
	private Date recordDate;
	
	@JsonProperty("pqno")
	private String pqno;
	
	@JsonProperty("sendingApplication")
	private MARSGenericField sendingApplication;
	
	@JsonProperty("facility")
	private MARSGenericField facility;
	
	@JsonProperty("patientName")
	private String patientName;
	
	@JsonProperty("mrn")
	private MarsID mrn;
	
	@JsonProperty("recordBody")
	private String recordBody;
	
	public String getKey(){
		return key;
	}
	
	public void setKey(String key){
		this.key = key;
	}
	
	
	/**
	 * Get type.description. 
	 * @return
	 */
	public String getSubtype(){
		return subtype;
	}
	
	/**
	 * Set the type.description
	 * @param subtype
	 */
	public void setSubtype(String subtype){
		this.subtype = subtype;
	}
	
	/**
	 * Get the spno (unique identifier from the sending application).
	 * @return
	 */
	public String getSPNO(){
		return spno;
	}
	
	public void setSPNO(String spno){
		this.spno = spno;
	}
	
	/**
	 * Get the record date
	 * @return
	 */
	public Date getRecordDate(){
		return recordDate;
	}
	
	public void setRecordDate(Date recordDate){
		this.recordDate = recordDate;
	}
	
	/**
	 * Get the pqno (the parsing time).
	 * @return
	 */
	public String getPQNO(){
		return pqno;
	}
	
	public void setPQNO(String pqno){
		this.pqno = pqno;
	}
	
	/**
	 * Get the sending application.
	 * @return
	 */
	public MARSGenericField getSendingApplication(){
		return sendingApplication;
	}
	
	public void setSendingApplication(String code, String codeSystem, String description){
		this.sendingApplication = new MARSGenericField(code, codeSystem, description);
	}
	
	/**
	 * get the facility.
	 * @return
	 */
	public MARSGenericField getFacility(){
		return facility;
	}
	
	public void setFacility(String code, String codeSystem, String description){
		this.facility = new MARSGenericField(code, codeSystem, description);
	}
	
	/**
	 * Get the patient name.
	 * @return
	 */
	public String getPatientName(){
		return patientName;
	}
	
	public void setPatientName(String name){
		this.patientName = name;
	}
	
	/**
	 * Get the medical record number.
	 * @return
	 */
	public MarsID getMRN(){
		return mrn;
	}
	
	public void setMRN(String id, String source){
		this.mrn = new MarsID(id, source);
	}
	
	/**
	 * Set the mrn. 
	 * @param mrn
	 */
	public void setMRN(MarsID mrn){
		this.mrn = mrn;
	}
	
	/**
	 * Get the record body. 
	 * @return
	 */
	public String getRecordBody(){
		return recordBody;
	}
	
	public void setRecordBody(String recordBody){
		this.recordBody = recordBody;
	}

}
