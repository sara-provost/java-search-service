package com.upmc.isd.galaxyapi.search.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrQuery.ORDER;

import com.upmc.isd.galaxyapi.search.model.hl7.HL7CollectionSearch;
import com.upmc.isd.galaxyapi.search.model.mars.MARSCollectionSearch;

/**
 * This class contains helper methods to build a Solr query. 
 * @author provosts
 *
 */
public class QueryUtilities {
	
	private static final String SEND_DATE_TIME = "SENDDATETIME";
	
	/**
	 * Public method to build a valid Solr query from the HL7CollectionSearch Object. 
	 * @param search
	 * @return
	 */
	public static SolrQuery buildQuery(HL7CollectionSearch search){
		SolrQuery query = new SolrQuery();
		
		/*
		 * Build a query from the RECKEYs if present. 
		 */
		if(search.getMessageIds().size() > 0){
			setRecKeys(query, search);
			
		}
		/*
		 * If there are no RECKEYS, build a query from the provided query. 
		 */
		else if(search.getQueryText() != null && !search.getQueryText().isEmpty()){
			query.setQuery(search.getQueryText());
		}
		/*
		 * If there is no queryText, nor RECKEYS, build the default query. 
		 */
		else{
			query.setQuery("*:*");
		}	
		
		
		//add a date filter no matter what
		addDateRange(query, search);
		if(!search.getComponentIds().isEmpty()){
			
		}
		if(search.getIncludeAcks() != null){
			
		}
		if(!search.getAckIncludeFilter().isEmpty()){
			
		}
		setSort(query, search.getSortBy(), search.getSortDir());
		//to support deep paging, this value must always be zero
		query.setStart(0);

		setRows(query, search.getEnd());
		setHL7FL(query, search);
		setCursorMark(query, search.getCursorMark());
		LoggingUtilities.log("********** BUILT QUERY **********");
		LoggingUtilities.log(query.toString());
		
		
		
		return query;
	}
	
	/**
	 * Build a Solr Query from the MARSCollectionSearch object
	 * @param search
	 * @return
	 */
	public static SolrQuery buildQuery(MARSCollectionSearch search){
		SolrQuery query = null;
		
		if(search != null){
			query = new SolrQuery();
			if(search.getKeys() != null && search.getKeys().size() > 0){
				StringBuilder mIds = new StringBuilder();
				mIds.append("KEY:");
				for(int i = 0; i < search.getKeys().size(); i++){

					String m = search.getKeys().get(i);
					mIds.append(m);
					
					if(i == search.getKeys().size() - 1){
						break;
					}
					mIds.append(" OR ");	
					mIds.append("RECKEY:");
					
					
				}	
				query.setQuery(mIds.toString());
				return query;
			}
			query.setQuery(search.getQueryText());
			query.setStart(0); //the start must always be 0. 
			setRows(query, search.getRows());
			setSort(query, search);
			setMARSFL(query, search);
			setCursorMark(query, search.getCursorMark());
			
		}
		LoggingUtilities.log("********** BUILT QUERY **********");
		LoggingUtilities.log(query.toString());
		
		
		
		return query;
	}
	
	public static SolrQuery buildQuery(String q){
		SolrQuery query = new SolrQuery();
		query.setQuery(q);
		return query;
	}
	
	/*
	 * Does this really need to be a facet?
	 */
	private static void addDateRangeFacet(SolrQuery query, HL7CollectionSearch queryInfo){
		Date startDate, endDate;
		
		try {
			startDate = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'").parse(queryInfo.getSendDateFrom());
			endDate = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'").parse(queryInfo.getSendDateTo());
			
			query.addDateRangeFacet(SEND_DATE_TIME, startDate, endDate, TimeUnit.NANOSECONDS.toString());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	/**
	 * Build a date range  
	 * @param query
	 * @param search
	 */
	private static void addDateRange(SolrQuery query, HL7CollectionSearch search){

		StringBuilder dateRangeBuilder = new StringBuilder();
		
		//set the to and from senddate values
		dateRangeBuilder.append("SENDDATETIME:[");
		//if the FROM value is blank assume *
		//* is an arbitrary time in the past. 
		if(search.getSendDateFrom().isEmpty()){
			dateRangeBuilder.append("*");
		}
		else{
			dateRangeBuilder.append(search.getSendDateFrom());
		}
		dateRangeBuilder.append(" TO ");
		//if the TO value is blank assume NOW
		if(search.getSendDateTo().isEmpty()){
			dateRangeBuilder.append("NOW]");
		}
		else{
			dateRangeBuilder.append(search.getSendDateTo());
			dateRangeBuilder.append("]");
		}
		
		//if both values are blank assume the range is from * to now
		query.addFilterQuery(dateRangeBuilder.toString());

	}
	
	/**
	 * Set the fields to be returned an HL7 collection request.  
	 * @param query
	 * @param search
	 */
	private static void setHL7FL(SolrQuery query, HL7CollectionSearch search){ //TODO:some fields are still missing
		query.setParam("fl", "SENDDATETIME", "RECKEY", search.getSortBy().trim(), "MESSAGEID");
	}
	
	/**
	 * Set the fields to be returned on a MARS collection request. 
	 * @param query
	 * @param search
	 */
	private static void setMARSFL(SolrQuery query, MARSCollectionSearch search){
		query.setParam("fl", "KEY", "RECORD_TYPE.DESCRIPTION", "SOURCE_KEY", "RECORD_DATE", "PQNO", "SENDING_APPLICATION.CODE", "SENDING_APPLICATION.CODE_SYSTEM", "SENDING_APPLICATION.DESCRIPTION", "FACILITY.CODE", "FACILTY.CODE_SYSTEM", "FACILITY.DESCRIPTION", "NAME", "MRN.ID", "MRN.SOURCE", "BODY");
	}
	
	/**
	 * Set the cursorMark on the Solr query.
	 * If there is no cursorMark assume it is a new search. 
	 * @param query
	 * @param cursorMark
	 */
	private static void setCursorMark(SolrQuery query, String cursorMark){
		if(cursorMark == null || cursorMark.equals("")){
			query.set("cursorMark", "*");
		}
		else{
			query.set("cursorMark", cursorMark);
		}
	}
	
	/**
	 * Build a query from the RECKEYs in the request. 
	 * @param query
	 * @param search
	 */
	private static void setRecKeys(SolrQuery query, HL7CollectionSearch search){
		StringBuilder mIds = new StringBuilder();
		mIds.append("RECKEY:");
		for(int i = 0; i < search.getMessageIds().size(); i++){

			String m = search.getMessageIds().get(i);
			mIds.append(m);
			
			if(i == search.getMessageIds().size() - 1){
				break;
			}
			mIds.append(" OR ");	
			mIds.append("RECKEY:");
			
			
		}
		
		query.setQuery(mIds.toString());
	}
	
	/**
	 * Build a query from the RECKEYs in the request.
	 * @param query
	 * @param search
	 */
	private static void setRecKeys(SolrQuery query, MARSCollectionSearch search){
		StringBuilder mIds = new StringBuilder();
		mIds.append("KEY:");
		for(int i = 0; i < search.getKeys().size(); i++){

			String m = search.getKeys().get(i);
			mIds.append(m);
			
			if(i == search.getKeys().size() - 1){
				break;
			}
			mIds.append(" OR ");	
			mIds.append("KEY:");
			
			
		}
		
		query.setQuery(mIds.toString());
	}
	
	/**
	 * Set the sort of the query. There must always be a sort parameter. 
	 * @param query
	 * @param sort
	 * @param direction
	 */
	private static void setSort(SolrQuery query, String sort, int direction){
		if(sort == null || sort.isEmpty()){
			query.setSort("RECKEY", ORDER.desc);			
		}
		else{
			if(direction == 0){
				query.setSort(sort, ORDER.asc);
			}
			else{
				query.setSort(sort, ORDER.desc);
			}
		}
	}
	
	/**
	 * Set the sort parameter of a MARSCollectionSearch. 
	 * @param query
	 * @param search
	 */
	private static void setSort(SolrQuery query, MARSCollectionSearch search){
		//default to descending order on the record key. 
		if(search.getSortBy() == null || search.getSortBy().isEmpty()){
			query.setSort("KEY", ORDER.desc);			
		}
		else{
			if(search.getSortDir().equals("ASC")){
				query.setSort(search.getSortBy(), ORDER.asc);
			}
			else{
				query.setSort(search.getSortBy(), ORDER.desc);
			}
		}
	}
	/**
	 * Set the number of rows to return
	 * @param query
	 * @param rows
	 */
	private static void setRows(SolrQuery query, int rows){
		if(rows > 0){
			query.setRows(rows);
		}
		
	}
}
