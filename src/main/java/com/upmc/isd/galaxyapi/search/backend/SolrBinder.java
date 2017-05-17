package com.upmc.isd.galaxyapi.search.backend;

import org.glassfish.hk2.utilities.binding.AbstractBinder;

import com.upmc.isd.galaxyapi.search.api.MARSSearch;
import com.upmc.isd.galaxyapi.search.common.LoggingUtilities;

public class SolrBinder extends AbstractBinder{

	@Override
	protected void configure() {
		LoggingUtilities.log("Binding Solr Service");
		bind(SolrService.class).to(SolrService.class);
	}

}
