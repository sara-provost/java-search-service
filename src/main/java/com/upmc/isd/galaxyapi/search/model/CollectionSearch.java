package com.upmc.isd.galaxyapi.search.model;

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
public class CollectionSearch {
	
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
	
	@JsonProperty("start")
	private Integer start = null;
	
	@JsonProperty("end")
	private Integer end = null;
	  
	  
	  
	 /**
	  * Setters
	 */
	public void setCollection(String collection) {
		this.collection = collection;
	}
	  
	public void setQueryText(String queryText){
		this.queryText = queryText;
	}
	  
	public CollectionSearch sendDateFrom(String sendDateFrom) {
		this.sendDateFrom = sendDateFrom;
		return this;
	}
	public CollectionSearch queryText(String queryText){
		  this.queryText = queryText;
		  return this;
	}
	
	public CollectionSearch messageIds(List<String> messageIds) {
	    this.messageIds = messageIds;
	    return this;
	 }

	public CollectionSearch addMessageIdsItem(String messageIdsItem) {
		this.messageIds.add(messageIdsItem);
		return this;
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

	  public CollectionSearch sendDateTo(String sendDateTo) {
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

	  public CollectionSearch componentIds(List<String> componentIds) {
	    this.componentIds = componentIds;
	    return this;
	  }

	  public CollectionSearch addComponentIdsItem(String componentIdsItem) {
	    this.componentIds.add(componentIdsItem);
	    return this;
	  }

	   /**
	   * Message components.
	   * @return componentIds
	  **/
	  @JsonProperty("componentIds")
	  @JsonPropertyDescription(value = "Message components.")
	  public List<String> getComponentIds() {
	    return componentIds;
	  }

	  public void setComponentIds(List<String> componentIds) {
	    this.componentIds = componentIds;
	  }

	  public CollectionSearch includeAcks(Boolean includeAcks) {
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

	  public CollectionSearch ackIncludeFilter(String ackIncludeFilter) {
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

	  public CollectionSearch sortBy(String sortBy) {
	    this.sortBy = sortBy;
	    return this;
	  }

	   /**
	   * Message field to sort by.
	   * @return sortBy
	  **/
	  @JsonProperty("sortBy")
	  @JsonPropertyDescription(value = "Message field to sort by.")
	  public String getSortBy() {
	    return sortBy;
	  }

	  public void setSortBy(String sortBy) {
	    this.sortBy = sortBy;
	  }

	  public CollectionSearch sortDir(Integer sortDir) {
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

	  public CollectionSearch start(Integer start) {
	    this.start = start;
	    return this;
	  }

	   /**
	   * Used for paging. Result range to start with.
	   * @return start
	  **/
	  @JsonProperty("start")
	  @JsonPropertyDescription(value = "Used for paging. Result range to start with.")
	  public Integer getStart() {
	    return start;
	  }

	  public void setStart(Integer start) {
	    this.start = start;
	  }

	  public CollectionSearch end(Integer end) {
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
	    CollectionSearch queryInfo = (CollectionSearch) o;
	    return Objects.equals(this.collection, queryInfo.collection) &&
	        Objects.equals(this.messageIds, queryInfo.messageIds) &&
	        Objects.equals(this.sendDateFrom, queryInfo.sendDateFrom) &&
	        Objects.equals(this.sendDateTo, queryInfo.sendDateTo) &&
	        Objects.equals(this.componentIds, queryInfo.componentIds) &&
	        Objects.equals(this.includeAcks, queryInfo.includeAcks) &&
	        Objects.equals(this.ackIncludeFilter, queryInfo.ackIncludeFilter) &&
	        Objects.equals(this.sortBy, queryInfo.sortBy) &&
	        Objects.equals(this.sortDir, queryInfo.sortDir) &&
	        Objects.equals(this.start, queryInfo.start) &&
	        Objects.equals(this.end, queryInfo.end);
	  }

	  @Override
	  public int hashCode() {
	    return Objects.hash(collection, messageIds, sendDateFrom, sendDateTo, componentIds, includeAcks, ackIncludeFilter, sortBy, sortDir, start, end);
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
	    sb.append("    start: ").append(toIndentedString(start)).append("\n");
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
