package com.upmc.isd.galaxyapi.search.model;

import java.util.Date;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

/**
 * The message class is the HL7 message return object for this service.  
 * The specification for this object can be found here: 
 * https://eti.shp.upmc.com/systemintegration/IIB/_layouts/15/WopiFrame.aspx?sourcedoc=/systemintegration/IIB/Shared%20Documents/Architecture/ETI%20-%20Message%20Router%20Transformation%20-%20Design.docx&action=default
 * @author provosts
 *
 */

@JsonIgnoreProperties(ignoreUnknown=true)
public class HL7Message{
	
	
	@JsonProperty("reckey")
	private String reckey = null;
	
	@JsonProperty("messageId")
	private String messageId;
	
	/*
	@JsonProperty("msgType")
	private Integer msgType = null;
		
	@JsonProperty("component")
	private String component = null;

	@JsonProperty("receiverFlow")
	private String receiverFlow = null;
	
	@JsonProperty("transformFlow")
	private String transformFlow = null;
	*/
	
	@JsonProperty("sendDate")
	private Date sendDate = null;
	
	
	@JsonSetter("SENDDATETIME")
	public void setSendDate(Date date){
		this.sendDate = date;
	}
	
	@JsonGetter("sendDate")
	public Date getSendDate(){
		return sendDate;
	}
	
	@JsonSetter("reckey")
	public void setRECKEY(String reckey){
		this.reckey = reckey;
	}
	
	@JsonGetter("reckey")
	public String getRecKey(){
		return reckey;
	}
	
	public void setMessageId(String messageId){
		this.messageId = messageId;
	}
	
	@JsonGetter("messageId")
	public String getMessageId(){
		return messageId;
	}
	
	
	
	
	
	
	/*
	public HL7Message id(String id) {
		this.id = id;
		return this;
	}
	
	
	

	  @JsonProperty("id")
	  @JsonPropertyDescription(value = "The message id.")
	  public String getId() {
	    return id;
	  }

	  public void setId(String id) {
	    this.id = id;
	  }

	  public HL7Message msgType(Integer msgType) {
	    this.msgType = msgType;
	    return this;
	  }


	  @JsonProperty("msgType")
	  @JsonPropertyDescription(value = "0 means message. 1 means acknowledgement.")
	  public Integer getMsgType() {
	    return msgType;
	  }

	  public void setMsgType(Integer msgType) {
	    this.msgType = msgType;
	  }

	  public HL7Message sendDate(String sendDate) {
	    this.sendDate = sendDate;
	    return this;
	  }

	  @JsonProperty("sendDate")
	  @JsonPropertyDescription(value = "date and time the message was sent")
	  public String getSendDate() {
	    return sendDate;
	  }

	  public void setSendDate(String sendDate) {
	    this.sendDate = sendDate;
	  }

	  public HL7Message component(String component) {
	    this.component = component;
	    return this;
	  }


	  @JsonProperty("component")
	  @JsonPropertyDescription(value = "The component the message is associated with.")
	  public String getComponent() {
	    return component;
	  }

	  public void setComponent(String component) {
	    this.component = component;
	  }
	  
	  public HL7Message receiverFlow(String receiverFlow) {
	    this.receiverFlow = receiverFlow;
	    return this;
	  }


	  @JsonProperty("receiverFlow")
	  @JsonPropertyDescription(value = "The path the messsage took when sent.")
	  public String getReceiverFlow() {
	    return receiverFlow;
	  }

	  public void setReceiverFlow(String receiverFlow) {
	    this.receiverFlow = receiverFlow;
	  }

	  public HL7Message transformFlow(String transformFlow) {
	    this.transformFlow = transformFlow;
	    return this;
	  }


	  @JsonProperty("transformFlow")
	  @JsonPropertyDescription(value = "The transformations the message underwent.")
	  public String getTransformFlow() {
	    return transformFlow;
	  }

	  public void setTransformFlow(String transformFlow) {
	    this.transformFlow = transformFlow;
	  }


	  @Override
	  public boolean equals(java.lang.Object o) {
	    if (this == o) {
	      return true;
	    }
	    if (o == null || getClass() != o.getClass()) {
	      return false;
	    }
	    HL7Message message = (HL7Message) o;
	    return Objects.equals(this.id, message.id) &&
	        Objects.equals(this.msgType, message.msgType) &&
	        Objects.equals(this.sendDate, message.sendDate) &&
	        Objects.equals(this.component, message.component) &&
	        Objects.equals(this.receiverFlow, message.receiverFlow) &&
	        Objects.equals(this.transformFlow, message.transformFlow);
	  }

	  @Override
	  public int hashCode() {
	    return Objects.hash(id, msgType, sendDate, component, receiverFlow, transformFlow);
	  }


	  @Override
	  public String toString() {
	    StringBuilder sb = new StringBuilder();
	    sb.append("class HL7Message {\n");
	    
	    sb.append("    id: ").append(toIndentedString(id)).append("\n");
	    sb.append("    msgType: ").append(toIndentedString(msgType)).append("\n");
	    sb.append("    sendDate: ").append(toIndentedString(sendDate)).append("\n");
	    sb.append("    component: ").append(toIndentedString(component)).append("\n");
	    sb.append("    receiverFlow: ").append(toIndentedString(receiverFlow)).append("\n");
	    sb.append("    transformFlow: ").append(toIndentedString(transformFlow)).append("\n");
	    sb.append("}");
	    return sb.toString();
	  }
	  
	  
	  public String toJsonString(){
		  StringBuilder sb = new StringBuilder();
		    sb.append("{\n");
		    
		    sb.append("    id: ").append(toIndentedString(id)).append("\n");
		    sb.append("    msgType: ").append(toIndentedString(msgType)).append("\n");
		    sb.append("    sendDate: ").append(toIndentedString(sendDate)).append("\n");
		    sb.append("    component: ").append(toIndentedString(component)).append("\n");
		    sb.append("    receiverFlow: ").append(toIndentedString(receiverFlow)).append("\n");
		    sb.append("    transformFlow: ").append(toIndentedString(transformFlow)).append("\n");
		    sb.append("}");
		    return sb.toString();
	  }


	  private String toIndentedString(java.lang.Object o) {
	    if (o == null) {
	      return "null";
	    }
	    return o.toString().replace("\n", "\n    ");
	  }
	  
	  */
}
