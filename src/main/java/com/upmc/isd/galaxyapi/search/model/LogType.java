package com.upmc.isd.galaxyapi.search.model;

public enum LogType {
	SEARCH_MARS, SEARCH_HL7, UNKNOWN;
	
	int eventType(){
		switch(this){
			case SEARCH_MARS:
				return 0;
			case SEARCH_HL7:
				return 1;
			default:
				return 2;
		}
	}
}
