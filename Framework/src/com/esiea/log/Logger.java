package com.esiea.log;

import java.util.ArrayList;
import java.util.Properties;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;




public class Logger {
	
	private Class<?> loggerName;
	private logLevel level = null;
	private Formateur formateur = null;
	private ArrayList<Cible> listCibles;
	
	public Logger(Class<?> loggerName) {
		this.loggerName = loggerName;
		listCibles = new ArrayList<Cible>();
		handleProperties();
	}

	public void setLevel(logLevel level) {
		if(true) {
			this.level = level;
		}
	}
	
	public void setFormateur(Formateur formateur) {
		if(true) {
			this.formateur = formateur;
		}
	}
	
	public void addCible(Cible cible) {
		if(true) {
			listCibles.add(cible);
		}
	}
	
	/*public void removeHandler(Handler handler){
		handlers.remove(handler);
	}
	*/
	
	private void handleMsg(logLevel msgLevel, String msg){
		
		if(level == null) {
			System.out.println("\n Veuillez renseigner le niveau du logger avec logger.setLevel(Level.niveau)\n");
		}
		
		if(formateur == null) {
			System.out.println("\n Veuillez renseigner le formateur du logger avec la ligne de commande suivante: logger.setFormatter(Voir doc pour format)\n");
		}
		
		if(listCibles.size() == 0) {
			listCibles.add(new ConsoleCible());

		}
		
		msg = formateur.structMsg(loggerName, msgLevel, msg);
		repartitionCible(msgLevel, msg);
	}
	
	public void warn(String msg) {
		handleMsg(logLevel.WARN, msg);
	}
	
	public void error(String msg) {
		handleMsg(logLevel.ERROR, msg);
	}
	
	public void info(String msg) {
		handleMsg(logLevel.INFO, msg);
	}
	
	public void debug(String msg) {
		handleMsg(logLevel.DEBUG, msg);
	}
	
	

	private void repartitionCible(logLevel msgLevel, String msg) {
		
		int i=0;
		
		if(msgLevel.getLevelValue() >= level.getLevelValue()){
			while(i < listCibles.size()) {
				listCibles.get(i).submit(msg);
				i++;
			
			}
		}
		
	}
	
	private void handleProperties() {
		FileInputStream input = null;

		Properties properties = new Properties();

		try {
			input = new FileInputStream(new File("logging.properties"));
			
			
				//Level
				if(properties.getProperty("logger.level").equals("DEBUG")) {
					level = logLevel.DEBUG;
				}
				
				else if(properties.getProperty("logger.level").equals("INFO")) {
					level = logLevel.INFO;
				}
			 
				else if(properties.getProperty("logger.level").equals("ERROR")) {
					level = logLevel.ERROR;
				
				}
				
				else if(properties.getProperty("logger.level").equals("WARN")) {
						level = logLevel.WARN;
				}
				else {
					System.out.println("\"\n Veuillez renseigner le niveau du logger avec logger.setLevel(Level.niveau)\n");
				}
				
				//
				if((properties.getProperty("logger.formateur")).contains(",")) {
					String[] formateurInfos = (properties.getProperty("logger.formateur")).split(" *, *");
					if(formateurInfos.length == 2 && (formateurInfos[0]).equals("Formateur")) {
						formateur = new Formateur(formateurInfos[1]);
					}
					else {
						System.out.println("\nVeuillez renseigner le formateur du logger avec la ligne de commande suivante: logger.setFormatter(Voir doc pour format)\n");
					}
				
				}
				
				
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
	}
		}
		
	}
}
		