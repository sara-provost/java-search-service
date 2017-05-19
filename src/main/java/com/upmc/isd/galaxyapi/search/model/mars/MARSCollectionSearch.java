package com.upmc.isd.galaxyapi.search.model.mars;

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
	
	@JsonProperty("keys")
	private List<String> keys;
	
	@JsonProperty("sortBy")
	private String sortBy;
	
	@JsonProperty("sortDir")
	private String sortDir;
	
	@JsonProperty("rows")
	private int rows;
	
	@JsonProperty("action")
	private String action; //TODO:move away from the "action"
	
	@JsonProperty("queryText")
	private String queryText;
	
	@JsonProperty("collection")
	private String collection;
	
	@JsonProperty("startDate")
	private String startDate;
	
	@JsonProperty("endDate")
	private String endDate;
	
	@JsonProperty("dateType")
	private String dateType; //The type of date provided. Acceptable values are DATE or PQNO
	
	@JsonProperty("cursorMark")
	private String cursorMark;
	
	/**
	 * Get the sort direction. ASC or DESC
	 * @return
	 */
	public String getSortDir(){
		return sortDir;
	}
	
	/**
	 * Set the sort direction. ASC or DESC. 
	 * @param sortDir
	 */
	public void setSortDir(String sortDir){
		this.sortDir = sortDir;
	}
	
	/**
	 * Get the type of date. 
	 * @return
	 */
	public String getDateType(){
		return dateType;
	}
	
	/**
	 * Set the type of date. 
	 * @param dateType
	 */
	public void setDateType(String dateType){
		this.dateType = dateType;
	}
	
	/**
	 * Get the ending date. 
	 * @return
	 */
	public String getEndDate(){
		return endDate; 
	}
	
	/**
	 * Set the ending date. 
	 * @param endDate
	 */
	public void setEndDate(String endDate){
		this.endDate = endDate;
	}
	
	/**
	 * Get the start date. 
	 * @return
	 */
	public String getStartDate(){
		return startDate;
	}
	
	/**
	 * Set the start date. 
	 * @param startDate
	 */
	public void setStartDate(String startDate){
		this.startDate = startDate; 
	}
	
	/**
	 * Get the number rows.
	 * @return
	 */
	public int getRows(){
		return rows;
	}
	
	/**
	 * Set the number of rows. 
	 * @param rows
	 */
	public void setRows(int rows){
		this.rows = rows;
	}
	
	/**
	 * Get the term by which to sort the results. 
	 * @return
	 */
	public String getSortBy(){
		return sortBy;
	}
	
	/**
	 * Set the term by which to sort the results. 
	 * @param sortBy
	 */
	public void setSortBy(String sortBy){
		this.sortBy = sortBy;
	}
	
	/**
	 * Get the cursor mark. 
	 * If this is empty, begin a new search. 
	 * @return
	 */
	public String getCursorMark(){
		return cursorMark;
	}
	
	/**
	 * Set the cursor mark. 
	 * @param cursorMark
	 */
	public void setCursorMark(String cursorMark){
		this.cursorMark = cursorMark;
	}
	
	/**
	 * Get the record Keys
	 * @return
	 */
	public List<String> getKeys(){
		return keys;
	}
	
	/**
	 * Set the record keys
	 * @param keys
	 */
	public void setKeys(List<String> keys){
		this.keys = keys;
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
	    sb.append("    reckeys: ").append(toIndentedString(keys)).append("\n");
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
