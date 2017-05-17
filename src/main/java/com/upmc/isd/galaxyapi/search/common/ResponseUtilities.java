package com.upmc.isd.galaxyapi.search.common;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.upmc.isd.galaxyapi.search.model.HL7Message;
import com.upmc.isd.galaxyapi.search.model.HL7SearchResponse;
import com.upmc.isd.galaxyapi.search.model.MARSSearchResponse;
import com.upmc.isd.galaxyapi.search.model.SearchException;

public class ResponseUtilities {
	
	public static HL7SearchResponse mapToHL7Response(QueryResponse response) throws SearchException{
		HL7SearchResponse HL7response = new HL7SearchResponse();
		List<HL7Message> messages = new ArrayList<HL7Message>();
		
		ObjectMapper mapper = new ObjectMapper();
		
		List<SolrDocument> docs = response.getResults();
		
		for(SolrDocument d: docs){
			HL7Message m = new HL7Message();
			mapHL7SolrDocument(m, d);
			messages.add(m);
		}
		
		/*
		for(SolrDocument d : docs){
			try {
				LoggingUtilities.log(d.toString());
				HL7Message m = mapper.readValue(d.toString(), HL7Message.class);
			} catch (IOException e) {
				GalaxyError error = new GalaxyError();
				error.setDescription(e.getMessage());
				throw new SearchException(error);
			}
		}
		*/
		HL7response.setTotal(response.getResults().getNumFound());
		HL7response.setTotalAcks(0); //TODO:add real number of acks
		HL7response.setCursorMark(response.getNextCursorMark());
		HL7response.setMessages(messages);
		return HL7response;
	}
	
	public static MARSSearchResponse mapToMARSMessage(QueryResponse response){
		MARSSearchResponse marsResponse = new MARSSearchResponse();
		
		
		return marsResponse;
	}
	
	
	private static void mapHL7SolrDocument(HL7Message m, SolrDocument d){
		
		if(d.get("MESSAGEID") != null){
			m.setMessageId((String)d.get("MESSAGEID"));
		}
		
		if(d.get("RECKEY") != null){
			m.setRECKEY((String)d.get("RECKEY"));
		}
		
		if(d.get("SENDDATETIME") != null){
			m.setSendDate((Date)d.get("SENDDATETIME"));
		}
		
		
	}
}
