package com.upmc.isd.galaxyapi.search.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrQuery.ORDER;

import com.upmc.isd.galaxyapi.search.model.CollectionSearch;

/**
 * This class contains helper methods to build a Solr query. 
 * @author provosts
 *
 */
public class QueryUtilities {
	
private static final String SEND_DATE_TIME = "SENDDATETIME";
	
	/**
	 * Public method to build a valid Solr query from the Collection Search Object. 
	 * @param search
	 * @return
	 */


	/*
	public static SolrQuery buildQuery(CollectionSearch search){
		SolrQuery query = new SolrQuery();
		
		
		if(search.getMessageIds().size() > 0){
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
		else{
			if(!search.getQueryText().isEmpty()){
				query.setQuery(search.getQueryText());
			}
			//add a date filter no matter what
			addDateRange(query, search);
			if(!search.getComponentIds().isEmpty()){
				
			}
			if(search.getIncludeAcks() != null){
				
			}
			if(!search.getAckIncludeFilter().isEmpty()){
				
			}
			//the default in solr is descending
			if(search.getSortDir() == 0 && !search.getSortBy().isEmpty()){
				query.addOrUpdateSort(search.getSortBy(), ORDER.asc);
			}
			if(search.getStart() != null){
				query.setStart(search.getStart());
			}
			if(search.getEnd() != null){
				query.setRows(search.getEnd());
			}
	
		}
		//query.setRequestHandler("/select");
		
		LoggingUtilities.log("********** BUILT QUERY **********");
		LoggingUtilities.log(query.toString());
		
		
		return query;
	}
	*/
	/*
	 * Does this really need to be a facet?
	 */
/*
	private static void addDateRangeFacet(SolrQuery query, CollectionSearch queryInfo){
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
*/
	/**
	 * Build a date range  
	 * @param query
	 * @param search
	 */
	private static void addDateRange(SolrQuery query, CollectionSearch search){
		/*
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
		*/
	}
	
}
