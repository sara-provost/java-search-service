package com.upmc.isd.galaxyapi.search.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

/**
 * The message class is the return object of this sevice. 
 * The specification for this object can be found here: 
 * https://eti.shp.upmc.com/systemintegration/IIB/_layouts/15/WopiFrame.aspx?sourcedoc=/systemintegration/IIB/Shared%20Documents/Architecture/ETI%20-%20Message%20Router%20Transformation%20-%20Design.docx&action=default
 * @author provosts
 *
 */
public class Message {
	@JsonProperty("id")
	private String id = null;
	
	@JsonProperty("msgType")
	private Integer msgType = null;
	
	@JsonProperty("sendDate")
	private String sendDate = null;
	
	@JsonProperty("component")
	private String component = null;
	
	@JsonProperty("rawText")
	private String rawText = null;
	
	@JsonProperty("receiverFlow")
	private String receiverFlow = null;
	
	@JsonProperty("transformFlow")
	private String transformFlow = null;
	
	public Message id(String id) {
		this.id = id;
		return this;
	}

	   /**
	   * The message id.
	   * @return id
	  **/
	  @JsonProperty("id")
	  @JsonPropertyDescription(value = "The message id.")
	  public String getId() {
	    return id;
	  }

	  public void setId(String id) {
	    this.id = id;
	  }

	  public Message msgType(Integer msgType) {
	    this.msgType = msgType;
	    return this;
	  }

	   /**
	   * 0 means message. 1 means acknowledgement.
	   * @return msgType
	  **/
	  @JsonProperty("msgType")
	  @JsonPropertyDescription(value = "0 means message. 1 means acknowledgement.")
	  public Integer getMsgType() {
	    return msgType;
	  }

	  public void setMsgType(Integer msgType) {
	    this.msgType = msgType;
	  }

	  public Message sendDate(String sendDate) {
	    this.sendDate = sendDate;
	    return this;
	  }

	   /**
	   * date and time the message was sent
	   * @return sendDate
	  **/
	  @JsonProperty("sendDate")
	  @JsonPropertyDescription(value = "date and time the message was sent")
	  public String getSendDate() {
	    return sendDate;
	  }

	  public void setSendDate(String sendDate) {
	    this.sendDate = sendDate;
	  }

	  public Message component(String component) {
	    this.component = component;
	    return this;
	  }

	   /**
	   * The component the message is associated with.
	   * @return component
	  **/
	  @JsonProperty("component")
	  @JsonPropertyDescription(value = "The component the message is associated with.")
	  public String getComponent() {
	    return component;
	  }

	  public void setComponent(String component) {
	    this.component = component;
	  }

	  public Message rawText(String rawText) {
	    this.rawText = rawText;
	    return this;
	  }

	   /**
	   * The textual content of the message.
	   * @return rawText
	  **/
	  @JsonProperty("rawText")
	  @JsonPropertyDescription(value = "The textual content of the message.")
	  public String getRawText() {
	    return rawText;
	  }

	  public void setRawText(String rawText) {
	    this.rawText = rawText;
	  }

	  public Message receiverFlow(String receiverFlow) {
	    this.receiverFlow = receiverFlow;
	    return this;
	  }

	   /**
	   * The path the messsage took when sent.
	   * @return receiverFlow
	  **/
	  @JsonProperty("receiverFlow")
	  @JsonPropertyDescription(value = "The path the messsage took when sent.")
	  public String getReceiverFlow() {
	    return receiverFlow;
	  }

	  public void setReceiverFlow(String receiverFlow) {
	    this.receiverFlow = receiverFlow;
	  }

	  public Message transformFlow(String transformFlow) {
	    this.transformFlow = transformFlow;
	    return this;
	  }

	   /**
	   * The transformations the message underwent.
	   * @return transformFlow
	  **/
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
	    Message message = (Message) o;
	    return Objects.equals(this.id, message.id) &&
	        Objects.equals(this.msgType, message.msgType) &&
	        Objects.equals(this.sendDate, message.sendDate) &&
	        Objects.equals(this.component, message.component) &&
	        Objects.equals(this.rawText, message.rawText) &&
	        Objects.equals(this.receiverFlow, message.receiverFlow) &&
	        Objects.equals(this.transformFlow, message.transformFlow);
	  }

	  @Override
	  public int hashCode() {
	    return Objects.hash(id, msgType, sendDate, component, rawText, receiverFlow, transformFlow);
	  }


	  @Override
	  public String toString() {
	    StringBuilder sb = new StringBuilder();
	    sb.append("class Message {\n");
	    
	    sb.append("    id: ").append(toIndentedString(id)).append("\n");
	    sb.append("    msgType: ").append(toIndentedString(msgType)).append("\n");
	    sb.append("    sendDate: ").append(toIndentedString(sendDate)).append("\n");
	    sb.append("    component: ").append(toIndentedString(component)).append("\n");
	    sb.append("    rawText: ").append(toIndentedString(rawText)).append("\n");
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
		    sb.append("    rawText: ").append(toIndentedString(rawText)).append("\n");
		    sb.append("    receiverFlow: ").append(toIndentedString(receiverFlow)).append("\n");
		    sb.append("    transformFlow: ").append(toIndentedString(transformFlow)).append("\n");
		    sb.append("}");
		    return sb.toString();
	  }

	  /**
	   * Convert the given object to string with each line indented by 4 spaces
	   * (except the first line).
	   */
	  private String toIndentedString(java.lang.Object o) {
	    if (o == null) {
	      return "null";
	    }
	    return o.toString().replace("\n", "\n    ");
	  }
}
