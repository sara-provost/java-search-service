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
import com.upmc.isd.galaxyapi.search.model.SearchException;
import com.upmc.isd.galaxyapi.search.model.hl7.HL7Message;
import com.upmc.isd.galaxyapi.search.model.hl7.HL7SearchResponse;
import com.upmc.isd.galaxyapi.search.model.mars.MARSMessage;
import com.upmc.isd.galaxyapi.search.model.mars.MARSSearchResponse;

/**
 * Utility class containing response mapping methods. 
 * @author provos_adm
 *
 */
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
		List<MARSMessage> messages = new ArrayList<MARSMessage>();
		
		List<SolrDocument> docs = response.getResults();
		
		for(SolrDocument d: docs){
			MARSMessage m = new MARSMessage();
			mapMARSSolrDocument(m, d);
			messages.add(m);
		}
		
		marsResponse.setTotal(response.getResults().getNumFound());
		marsResponse.setCursorMark(response.getNextCursorMark());
		marsResponse.setMessages(messages);
		
		return marsResponse;
	}
	
	private static void mapMARSSolrDocument(MARSMessage m, SolrDocument d){
		
		if(d.get("KEY") != null){
			m.setKey((String) d.get("KEY"));
		}
		if(d.get("RECORD_TYPE.DESCRIPTION") != null){
			m.setSubtype((String)d.get("RECORD_TYPE.DESCRIPTION"));
		}
		if(d.get("SOURCE_KEY") != null){
			m.setSPNO((String)d.get("SOURCE_KEY"));
		}
		if(d.get("RECORD_DATE") != null){
			m.setRecordDate((Date)d.get("RECORD_DATE"));
		}
		if(d.get("PQNO") != null){
			m.setPQNO((String)d.get("PQNO"));
		}
		if(d.get("SENDING_APPLICATION.CODE") != null || (d.get("SENDING_APPLICATION.CODE_SYSTEM") != null || d.get("SENDING_APPLICATION.DESCRIPTION") != null)){
			m.setSendingApplication((String) d.get("SENDING_APPLICATION.CODE"), (String) d.get("SENDING_APPLICATION.CODE_SYSTEM"), (String) d.get("SENDING_APPLICATION.DESCRIPTION")); 
		}
		if(d.get("FACILITY.CODE") != null || d.get("FACILTY.CODE_SYSTEM") != null || d.get("FACILTY.DESCRIPTION") != null){
			m.setFacility((String) d.get("FACILITY.CODE"), (String) d.get("FACILTY.CODE_SYSTEM"), (String) d.get("FACILTY.DESCRIPTION"));
		}
		if(d.get("NAME") != null){
			m.setPatientName((String)d.get("NAME"));
		}
		if(d.get("MRN.ID") != null || d.get("MRN.SOURCE") != null){
			m.setMRN((String) d.get("MRN.ID"), (String) d.get("MRN.SOURCE"));
		}
		if(d.get("BODY") != null){
			m.setRecordBody((String)d.get("BODY"));
		}
		 
		  
	}
	
	/**
	 * Map the Solr document from the response to the HL7Message object. 
	 * @param m
	 * @param d
	 */
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
