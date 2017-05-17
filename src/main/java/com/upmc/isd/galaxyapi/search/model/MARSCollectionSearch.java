package com.upmc.isd.galaxyapi.search.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This class describes the input for a MARS Collection Search Request
 * @author provos_adm
 *
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class MARSCollectionSearch {
	
	public MARSCollectionSearch(){}
	
	@JsonProperty("reckeys")
	private List<String> reckeys;
	
	@JsonProperty("action")
	private String action;
	
	@JsonProperty("queryText")
	private String queryText;
	
	@JsonProperty("collection")
	private String collection;
	
	@JsonProperty("cursorMark")
	private String cursorMark;
	
	
	public String getCursorMark(){
		return cursorMark;
	}
	
	public void setCursorMark(String cursorMark){
		this.cursorMark = cursorMark;
	}
	
	/**
	 * Get the record Keys
	 * @return
	 */
	@JsonGetter("reckeys")
	public List<String> getRecKeys(){
		return reckeys;
	}
	
	/**
	 * Get the action to be performed
	 * @return
	 */
	public String getAction(){
		return action;
	}
	
	/**
	 * Get the text of the query
	 * @return
	 */
	public String getQueryText(){
		return queryText;
	}
	
	/**
	 * Get the collection name
	 * @return
	 */
	public String getCollection(){
		return collection;
	}

	
	 @Override
	  public String toString() {
	    StringBuilder sb = new StringBuilder();
	    sb.append("class MarsCollectionSearch {\n");
	    
	    sb.append("    collection: ").append(toIndentedString(collection)).append("\n");
	    sb.append("    queryText: ").append(toIndentedString(queryText)).append("\n");
	    sb.append("    action: ").append(toIndentedString(action)).append("\n");
	    sb.append("    RECKEYS: ").append(toIndentedString(reckeys)).append("\n");
	    sb.append("}\n");
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
