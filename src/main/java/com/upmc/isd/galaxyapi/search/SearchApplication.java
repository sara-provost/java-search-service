package com.upmc.isd.galaxyapi.search;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import com.upmc.isd.galaxyapi.search.api.HL7Search;
import com.upmc.isd.galaxyapi.search.api.MARSSearch;
import com.upmc.isd.galaxyapi.search.filter.requestfilter.TokenValidatorFilter;

@ApplicationPath("/api")
public class SearchApplication extends Application{
	
	//this is for all request scoped resources and providers
	@Override
	public Set<Class<?>> getClasses(){
		Set<Class<?>> classes = new HashSet<>();
		classes.add(TokenValidatorFilter.class);
		classes.add(HL7Search.class);
		classes.add(MARSSearch.class);
		
		return classes;
	}
	
	
	@Override
	public Set<Object> getSingletons(){
		Set<Object> singletons = new HashSet<>();
		return singletons;
	}
} 
