package com.upmc.isd.galaxyapi.search;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import org.glassfish.jersey.server.ResourceConfig;

import com.upmc.isd.galaxyapi.search.api.APISpecification;
import com.upmc.isd.galaxyapi.search.api.HL7Search;
import com.upmc.isd.galaxyapi.search.api.MARSDelete;
import com.upmc.isd.galaxyapi.search.api.MARSSearch;
import com.upmc.isd.galaxyapi.search.api.MARSSuppress;
import com.upmc.isd.galaxyapi.search.api.MARSUnsupersede;
import com.upmc.isd.galaxyapi.search.backend.SolrBinder;
import com.upmc.isd.galaxyapi.search.filter.requestfilter.TokenValidatorFilter;

@ApplicationPath("/api")
public class SearchApplication extends ResourceConfig{
		
	
	public SearchApplication(){
		packages("com.upmc.isd.galaxyapi.search");
		
		register(new SolrBinder());
	}
	
	/*
	//this is for all request scoped resources and providers
	@Override
	public Set<Class<?>> getClasses(){
		Set<Class<?>> classes = new HashSet<>();
		
		classes.add(TokenValidatorFilter.class);
		
		
		classes.add(HL7Search.class);
		
		
		classes.add(MARSSearch.class);
		classes.add(MARSDelete.class);
		classes.add(MARSSuppress.class);
		classes.add(MARSUnsupersede.class);
		
		
		classes.add(APISpecification.class);
		return classes;
	}
	
	
	@Override
	public Set<Object> getSingletons(){
		Set<Object> singletons = new HashSet<>();
		return singletons;
	}
	*/
	
	
} 
