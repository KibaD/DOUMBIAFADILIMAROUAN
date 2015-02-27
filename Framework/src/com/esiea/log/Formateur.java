package com.esiea.log;

import java.text.DateFormat;
import java.util.Date;



public class Formateur {

	DateFormat date = DateFormat.getDateTimeInstance(DateFormat.MEDIUM,DateFormat.MEDIUM);
	private String pattern;
	
	public Formateur(String pattern){
		this.pattern = pattern;
	}
	
	public String structMsg(Class<?> loggerName, logLevel msgLevel, String msg) {
		
		if(pattern == null) {
			 
			String myDefaultMsg = "" +date.format(new Date())
									 + "  [NAME="+ loggerName.getName()
									 + " LEVEL_Val=" + Integer.toString(msgLevel.getLevelValue())
									 + " LEVEL_Name=" + msgLevel.name() 
									 + " MESSAGE=" + msg +"]";
			
			return  myDefaultMsg;
		}
		
		String customFormatMessage = "";
		customFormatMessage = pattern.replaceAll("%date%", date.format(new Date()));
		customFormatMessage = customFormatMessage.replaceAll("%loggerName%", loggerName.getName());
		customFormatMessage = customFormatMessage.replaceAll("%levelVal%", Integer.toString(msgLevel.getLevelValue()));
		customFormatMessage = customFormatMessage.replaceAll("%levelName%", msgLevel.name());
		customFormatMessage = customFormatMessage.replaceAll("%message%", msg);
		
		return customFormatMessage;
	}
	
}

