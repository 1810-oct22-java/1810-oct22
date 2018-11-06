package com.rev.logging;

import org.apache.log4j.Logger;

public class LoggingExample {
	/*
	 * Log4j is a reliable, fast, and flexible logging 
	 * framework support by Apache
	 * 
	 * Benefits of logging:
	 * - able to record events that occur during software execution 
	 * - as users execute programs on the client side(browsers), the
	 * system can accumulate log entries for the support team 
	 * - in general, logging allows developers to access information
	 * about applications in which we do not have direct assess
	 * 
	 * LOGGING LEVELS*
	 * - we can set our logger to be at a certain level, which will 
	 * indicate what types of messages we want to see 
	 * - for standard levels we have ALL>DEBUG>INFO>WARN>ERROR>FATAL>OFF
	 * ALL - all levels
	 * DEBUT - designates fine-grained informational events that are most 
	 * useful to debug an application 
	 * INFO - informational messages that highlight the progress of the 
	 * application at the coarse grained level
	 * WARN - potentially harmful situations
	 * ERROR - error events that might still allow the application to 
	 * continue running 
	 * FATAL - severe error events that presumably abort the app 
	 * OFF - highst possible level, intended to turn off logging
	 * TRACE - designates finer-grained informational events than DEBUG
	 */

	final static Logger log = Logger.getLogger(LoggingExample.class);
	
	public static void main(String[] args) {
		System.out.println("Standard System.out");
		log.trace("trace message - very fine grained");
		log.debug("this is a debug message. should be useful for "
				+ "debugging the application");
		log.info("info message");
		log.warn("Warning");
		log.error("Error message!");
		log.fatal("yikes");
	}

}
