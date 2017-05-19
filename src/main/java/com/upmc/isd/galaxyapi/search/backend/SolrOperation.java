package com.upmc.isd.galaxyapi.search.backend;

import org.apache.solr.client.solrj.SolrQuery;

import com.upmc.isd.galaxyapi.search.common.QueryUtilities;
import com.upmc.isd.galaxyapi.search.model.hl7.HL7CollectionSearch;
import com.upmc.isd.galaxyapi.search.model.mars.MARSCollectionSearch;

/**
 * This class defines the action that will be done against Solr. 
 * @author provos_adm
 *
 */
public class SolrOperation {
	
	private final String action;
	private final SolrQuery query;
	private final String collection;
	
	/**
	 * 
	 * @param action The action to perform against the Solr Index
	 * @param query The query to submit to a Solr Collection
	 * @param collection The Solr collection
	 */
	private SolrOperation(final String action, final SolrQuery query, final String collection){
		this.action = action;
		this.query = query;
		this.collection = collection;
	}
	
	public String getAction(){
		return action;
	}
	
	public SolrQuery getSolrQuery(){
		return query;
	}
	
	public String getCollection(){
		return collection;
	}
	
	
	public static class Builder{
		
		private String builderAction;
		private SolrQuery builderQuery;
		private String builderCollection;
		
		/**
		 * Construct a Solr Operation from the HL7CollectionSearch Object. 
		 * This kind of search can only have 1 operation type (search)
		 * @param search
		 */
		public Builder(HL7CollectionSearch search){
			this.builderAction = "SEARCH";
			this.builderQuery = QueryUtilities.buildQuery(search);
			this.builderCollection = search.getCollection();
		}
		
		/**
		 * Construct a Solr Operation from the MARSCollectionSearch Object.
		 * This kind of search can have more than 1 operation type.
		 * If the operation type is not specified in the request object default to search. 
		 * @param search
		 */
		public Builder(MARSCollectionSearch search){
			this.builderAction = search.getAction();
			this.builderQuery = QueryUtilities.buildQuery(search);
			this.builderCollection = search.getCollection();
		}
		
		
		public Builder action(final String action){
			this.builderAction = action;
			return this;
			
		}
		
		public Builder query(final String query){
			this.builderQuery = QueryUtilities.buildQuery(query);
			return this;
		}
		
		public Builder collection(final String collection){
			this.builderCollection = collection;
			return this;
		}
		
		/**
		 * Build a new SolrOperation
		 * @return
		 */
		public SolrOperation build(){
			return new SolrOperation(builderAction, builderQuery, builderCollection);
		}
		
	}
	
	
	
}
