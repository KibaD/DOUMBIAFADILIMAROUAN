package com.esiea.log;


public class MaClasse {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Logger logger = new Logger(MaClasse.class);
		
		logger.setLevel(logLevel.DEBUG);
		//logger.setLevel(logLevel.INFO);
		//logger.setLevel(logLevel.ERROR);
		//logger.setLevel(logLevel.WARN);

		logger.setFormateur(new Formateur("Date: %date% - [NAME=%(loggerName)% LEVEL_VAL=%levelVal% LEVEL_NAME=%levelName% MESSAGE= %message%]"));
     	//logger.setFormateur(new Formateur());

		
		logger.debug("Test log ESIEA : DEBUG");
		logger.info("Test log ESIEA : INFO");
		logger.error("Test log ESIEA : ERROR");
		logger.warn("Test log ESIEA : WARN");
		
	}
	

}


