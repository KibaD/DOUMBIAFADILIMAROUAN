package com.esiea.log;

import java.io.IOException;


public class execute {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		/* Test Logger */
		Logger logger = new Logger(execute.class);
		
		/* Test Level */
		logger.setLevel(logLevel.DEBUG);
		//logger.setLevel(Level.INFO);
		//logger.setLevel(Level.ERROR);
		
		/* Test Formatter */
		//logger.setFormatter(new Formatter());
		logger.setFormateur(new Formateur("DATE=%(acstime)% - [LOGGER_NAME=%(loggerName)% LEVEL_NUM=%(levelNum)% LEVEL_NAME=%(levelName)% MESSAGE= %(message)%]"));
		//logger.setFormatter(new Formatter("[LOGGER_NAME=%(loggerName)% LEVEL_NUM=%(levelNum)% LEVEL_NAME=%(levelName)% MESSAGE= %(message)%]"));
		//logger.setFormatter(new Formatter("DATE=%(acstime)% - [LEVEL_NUM=%(levelNum)% LEVEL_NAME=%(levelName)% MESSAGE= %(message)%]"));
		//logger.setFormatter(new Formatter("DATE=%(acstime)% - [LOGGER_NAME=%(loggerName)% LEVEL_NAME=%(levelName)% MESSAGE= %(message)%]"));
		//logger.setFormatter(new Formatter("DATE=%(acstime)% - [LOGGER_NAME=%(loggerName)% LEVEL_NUM=%(levelNum)% MESSAGE= %(message)%]"));
		//logger.setFormatter(new Formatter("DATE=%(acstime)% - [LOGGER_NAME=%(loggerName)% LEVEL_NUM=%(levelNum)% LEVEL_NAME=%(levelName)%]"));
		
		
		/* Execution des tests */
		logger.debug("Test log ESIEA : DEBUG");
		logger.info("Test log ESIEA : INFO");
		logger.error("Test log ESIEA : ERROR");
		logger.warn("Test log ESIEA : WARN");
		/*/* Test RotatingFileHandler 
		logger.debug("Test log ESIEA : DEBUG");
		logger.info("Test log ESIEA : INFO");
		logger.error("Test log ESIEA : ERROR");
		logger.debug("Test log ESIEA : DEBUG");
		logger.info("Test log ESIEA : INFO");
		logger.error("Test log ESIEA : ERROR");
		logger.debug("Test log ESIEA : DEBUG");
		logger.info("Test log ESIEA : INFO");
		logger.error("Test log ESIEA : ERROR");*/
		
	}
	

	}


