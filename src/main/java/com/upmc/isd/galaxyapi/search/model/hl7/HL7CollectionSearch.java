package com.upmc.isd.galaxyapi.search.model.hl7;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

/**
 * This class represents the search object. 
 * The specification for this object can be found here: 
 * https://eti.shp.upmc.com/systemintegration/IIB/_layouts/15/WopiFrame.aspx?sourcedoc=/systemintegration/IIB/Shared%20Documents/Architecture/ETI%20-%20Message%20Router%20Transformation%20-%20Design.docx&action=default
 * @author provosts
 *
 */



@JsonIgnoreProperties(ignoreUnknown=true)
public class HL7CollectionSearch {
	
	public HL7CollectionSearch(){}
	
	@JsonProperty("collection")
	private String collection = null;
	
	@JsonProperty("queryText")
	private String queryText = null;
	  
	@JsonProperty("messageIds")
	private List<String> messageIds = new ArrayList<String>();
	
	@JsonProperty("sendDateFrom")
	private String sendDateFrom = null;
	
	@JsonProperty("sendDateTo")
	private String sendDateTo = null;
	
	@JsonProperty("componentIds")
	private List<String> componentIds = new ArrayList<String>();
	
	@JsonProperty("includeAcks")
	private Boolean includeAcks = null;
	
	@JsonProperty("ackIncludeFilter")
	private String ackIncludeFilter = null;
	
	@JsonProperty("sortBy")
	private String sortBy = null;
	
	@JsonProperty("sortDir")
	private Integer sortDir = null;
	
	@JsonProperty("end")
	private Integer end = null;
	
	@JsonProperty("cursorMark")
	private String cursorMark = null;
	  
	public void setCursorMark(String cursorMark){
		this.cursorMark = cursorMark;
	}
	
	public String getCursorMark(){
		return cursorMark;
	}
	
	 /**
	  * Setters
	 */
	public void setCollection(String collection) {
		this.collection = collection;
	}
	  
	public void setQueryText(String queryText){
		this.queryText = queryText;
	}
	  
	public HL7CollectionSearch sendDateFrom(String sendDateFrom) {
		this.sendDateFrom = sendDateFrom;
		return this;
	}
	public HL7CollectionSearch queryText(String queryText){
		  this.queryText = queryText;
		  return this;
	}
	
	public HL7CollectionSearch messageIds(List<String> messageIds) {
	    this.messageIds = messageIds;
	    return this;
	 }

	public HL7CollectionSearch addMessageIdsItem(String messageIdsItem) {
		this.messageIds.add(messageIdsItem);
		return this;
	}
	
	/**
	 * Get the search Collection
	 * @return
	 */
	public String getCollection(){
		return collection;
	}
	   /**
	   * Ids of messages. If present other criteria is ignored.
	   * @return messageIds
	  **/
	  @JsonProperty("messageIds")
	  @JsonPropertyDescription(value = "Ids of messages. If present other criteria is ignored.")
	  public List<String> getMessageIds() {
	    return messageIds;
	  }

	  public void setMessageIds(List<String> messageIds) {
	    this.messageIds = messageIds;
	  }
	  
	  /**
	   * The Solr syntax search query
	   * @return queryText
	   */
	  @JsonProperty("queryText")
	  @JsonPropertyDescription(value = "The Solr syntax search query")
	  public String getQueryText(){
		  return queryText;
	  }

	   /**
	   * Start send date in UTC format. 1000th of a second accuracy.
	   * @return sendDateFrom
	  **/
	  @JsonProperty("sendDateFrom")
	  @JsonPropertyDescription(value = "Start send date in UTC format. 1000th of a second accuracy.")
	  public String getSendDateFrom() {
	    return sendDateFrom;
	  }

	  public void setSendDateFrom(String sendDateFrom) {
	    this.sendDateFrom = sendDateFrom;
	  }

	  public HL7CollectionSearch sendDateTo(String sendDateTo) {
	    this.sendDateTo = sendDateTo;
	    return this;
	  }

	   /**
	   * End sent date in UTC format. 1000th of a second accuracy.
	   * @return sendDateTo
	  **/
	  @JsonProperty("sendDateTo")
	  @JsonPropertyDescription(value = "End sent date in UTC format. 1000th of a second accuracy.")
	  public String getSendDateTo() {
	    return sendDateTo;
	  }

	  public void setSendDateTo(String sendDateTo) {
	    this.sendDateTo = sendDateTo;
	  }

	  public HL7CollectionSearch componentIds(List<String> componentIds) {
	    this.componentIds = componentIds;
	    return this;
	  }

	  public HL7CollectionSearch addComponentIdsItem(String componentIdsItem) {
	    this.componentIds.add(componentIdsItem);
	    return this;
	  }

	   /**
	   * HL7Message components.
	   * @return componentIds
	  **/
	  @JsonProperty("componentIds")
	  @JsonPropertyDescription(value = "HL7Message components.")
	  public List<String> getComponentIds() {
	    return componentIds;
	  }

	  public void setComponentIds(List<String> componentIds) {
	    this.componentIds = componentIds;
	  }

	  public HL7CollectionSearch includeAcks(Boolean includeAcks) {
	    this.includeAcks = includeAcks;
	    return this;
	  }

	   /**
	   * Get includeAcks
	   * @return includeAcks
	  **/
	  @JsonProperty("includeAcks")
	  @JsonPropertyDescription(value = "")
	  public Boolean getIncludeAcks() {
	    return includeAcks;
	  }

	  public void setIncludeAcks(Boolean includeAcks) {
	    this.includeAcks = includeAcks;
	  }

	  public HL7CollectionSearch ackIncludeFilter(String ackIncludeFilter) {
	    this.ackIncludeFilter = ackIncludeFilter;
	    return this;
	  }

	   /**
	   * Include acknowledgements that include this statement.
	   * @return ackIncludeFilter
	  **/
	  @JsonProperty("ackIncludeFilter")
	  @JsonPropertyDescription(value = "Include acknowledgements that include this statement.")
	  public String getAckIncludeFilter() {
	    return ackIncludeFilter;
	  }

	  public void setAckIncludeFilter(String ackIncludeFilter) {
	    this.ackIncludeFilter = ackIncludeFilter;
	  }

	  public HL7CollectionSearch sortBy(String sortBy) {
	    this.sortBy = sortBy;
	    return this;
	  }

	   /**
	   * HL7Message field to sort by.
	   * @return sortBy
	  **/
	  @JsonProperty("sortBy")
	  @JsonPropertyDescription(value = "HL7Message field to sort by.")
	  public String getSortBy() {
	    return sortBy;
	  }

	  public void setSortBy(String sortBy) {
	    this.sortBy = sortBy;
	  }

	  public HL7CollectionSearch sortDir(Integer sortDir) {
	    this.sortDir = sortDir;
	    return this;
	  }

	   /**
	   * Direction to sort results by. O is asc 1 is desc
	   * @return sortDir
	  **/
	  @JsonProperty("sortDir")
	  @JsonPropertyDescription(value = "Direction to sort results by. O is asc 1 is desc")
	  public Integer getSortDir() {
	    return sortDir;
	  }

	  public void setSortDir(Integer sortDir) {
	    this.sortDir = sortDir;
	  }


	  public HL7CollectionSearch end(Integer end) {
	    this.end = end;
	    return this;
	  }

	   /**
	   * Used for paging. Result range to end with.
	   * @return end
	  **/
	  @JsonProperty("end")
	  @JsonPropertyDescription(value = "Used for paging. Result range to end with.")
	  public Integer getEnd() {
	    return end;
	  }

	  public void setEnd(Integer end) {
	    this.end = end;
	  }


	  @Override
	  public boolean equals(java.lang.Object o) {
	    if (this == o) {
	      return true;
	    }
	    if (o == null || getClass() != o.getClass()) {
	      return false;
	    }
	    HL7CollectionSearch queryInfo = (HL7CollectionSearch) o;
	    return Objects.equals(this.collection, queryInfo.collection) &&
	        Objects.equals(this.messageIds, queryInfo.messageIds) &&
	        Objects.equals(this.sendDateFrom, queryInfo.sendDateFrom) &&
	        Objects.equals(this.sendDateTo, queryInfo.sendDateTo) &&
	        Objects.equals(this.componentIds, queryInfo.componentIds) &&
	        Objects.equals(this.includeAcks, queryInfo.includeAcks) &&
	        Objects.equals(this.ackIncludeFilter, queryInfo.ackIncludeFilter) &&
	        Objects.equals(this.sortBy, queryInfo.sortBy) &&
	        Objects.equals(this.sortDir, queryInfo.sortDir) &&
	        Objects.equals(this.end, queryInfo.end);
	  }

	  @Override
	  public int hashCode() {
	    return Objects.hash(collection, messageIds, sendDateFrom, sendDateTo, componentIds, includeAcks, ackIncludeFilter, sortBy, sortDir, end);
	  }


	  @Override
	  public String toString() {
	    StringBuilder sb = new StringBuilder();
	    sb.append("class QueryInfo {\n");
	    
	    sb.append("    collection: ").append(toIndentedString(collection)).append("\n");
	    sb.append("    queryText: ").append(toIndentedString(queryText)).append("\n");
	    sb.append("    messageIds: ").append(toIndentedString(messageIds)).append("\n");
	    sb.append("    sendDateFrom: ").append(toIndentedString(sendDateFrom)).append("\n");
	    sb.append("    sendDateTo: ").append(toIndentedString(sendDateTo)).append("\n");
	    sb.append("    componentIds: ").append(toIndentedString(componentIds)).append("\n");
	    sb.append("    includeAcks: ").append(toIndentedString(includeAcks)).append("\n");
	    sb.append("    ackIncludeFilter: ").append(toIndentedString(ackIncludeFilter)).append("\n");
	    sb.append("    sortBy: ").append(toIndentedString(sortBy)).append("\n");
	    sb.append("    sortDir: ").append(toIndentedString(sortDir)).append("\n");
	    sb.append("    end: ").append(toIndentedString(end)).append("\n");
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
