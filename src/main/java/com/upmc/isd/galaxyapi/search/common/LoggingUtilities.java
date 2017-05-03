package com.upmc.isd.galaxyapi.search.common;

import com.upmc.isd.galaxyapi.search.model.GalaxyError;
import com.upmc.isd.galaxyapi.search.model.LogEvent;

/**
 * This is a logging helper class. For now it contains stub methods. 
 * @author provosts
 *
 */
public class LoggingUtilities {
	public static void log(String message){
		System.out.println(message);
	}
	
	public static void logGalaxyEvent(LogEvent event){
		logLocally(event);
	}
	
	public static void log(int message){
		System.out.println(message);
	}
	
	public static void logSearch(String search){
		System.out.println(search);
	}
	
	private static void logToFairWarning(LogEvent logEvent){
		//TODO:implement logging to FairWarning
		//TODO:what happens if a remote log event can't be completed?
	}
	
	/**
	 * Log to a local file
	 * @param logEvent
	 */
	private static void logLocally(LogEvent logEvent){
		System.out.println(logEvent.toString());
	}
	
	/**
	 * Log a galaxy error locally
	 * @param error
	 */
	private static void logLocally(GalaxyError error){
		System.out.println(error.toString());
	}
	
	
	/**
	 * Log to the Logging Server
	 * @param logEvent
	 */
	private static void logToGalaxy(LogEvent logEvent){
		//
		System.out.println(logEvent.toString());
	}
	
	/**
	 * Stub method to log a "Galaxy Error" object. 
	 * @param error
	 */
	public void logGalaxyError(GalaxyError error){
		logLocally(error);
	}
}
