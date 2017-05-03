package com.upmc.isd.galaxyapi.search.filter.requestfilter;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.ext.Provider;

import com.upmc.isd.galaxyapi.search.common.LoggingUtilities;
import com.upmc.isd.galaxyapi.search.common.TokenUtilities;


@Provider
@PreMatching
public class TokenValidatorFilter implements ContainerRequestFilter{

	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		String authHeader = requestContext.getHeaderString(HttpHeaders.AUTHORIZATION);
		
		if(authHeader == null){
			//TODO: throw authorization exception
			LoggingUtilities.log("Unauthorized user");
		}
		
		//TODO:parse and verify the token
		try{
			String token = TokenUtilities.parseToken(authHeader);
			Boolean b = TokenUtilities.verifyToken(token);
		}catch(Exception e){
			
		}	
		
	}

}
