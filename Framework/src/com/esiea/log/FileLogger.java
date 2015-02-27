package com.esiea.log;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

	public class FileLogger extends Cible {
		
		public File File;
		
		public FileLogger(String strLogPath){
			File = new File(strLogPath);
		}
		
		public void submit(String msg) {

			FileWriter writer = null;
			
			try{
				writer = new FileWriter(File, true);
				writer.write(msg, 0, msg.length());
				
			} catch(IOException e) {
				e.printStackTrace();
			} finally {
				if(writer != null){
					try {
						writer.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
		
	}
	
