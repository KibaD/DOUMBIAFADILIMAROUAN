package com.esiea.log;

import java.io.*;
import java.util.Date;

public class  MessageWriter implements MaClasse {

	 
	    public int m_iLogLevel = e_LogLevel.e_log_error;
	    public String m_strLogFile = new String();
	    public String m_strLogPath = new String();
	    public boolean m_bConsoleOut = true;
	    PrintStream m_ps;
	    public boolean m_bLogOpen = false;
	    private static Date dt= new Date();

	   
	    public void info(String strMess)
	    {
	        if ((m_iLogLevel & e_LogLevel.e_log_info) == e_LogLevel.e_log_info)
	        {
	            dt.setTime(System.currentTimeMillis());
	            String strOut = dt.toString() + " inf: " + strMess;
	            if (m_bConsoleOut) System.out.println(strOut);
	            if (m_bLogOpen) m_ps.println(strOut);
	        }
	    }
	    public boolean bInfo(){return ((m_iLogLevel & e_LogLevel.e_log_info) == e_LogLevel.e_log_info);}
	
	    
	    public void debug(String strMess)
	    {
	        if ((m_iLogLevel & e_LogLevel.e_log_debug) == e_LogLevel.e_log_debug)
	        {
	            dt.setTime(System.currentTimeMillis());
	            String strOut = dt.toString() + " dbg: " + strMess;
	            if (m_bConsoleOut) System.out.println(strOut);
	            if (m_bLogOpen) m_ps.println(strOut);
	        }
	    }
	    public boolean bDebug(){return ((m_iLogLevel & e_LogLevel.e_log_debug) == e_LogLevel.e_log_debug);}
	  
	    
	    public void warn(String strMess)
	    {
	        if ((m_iLogLevel & e_LogLevel.e_log_warn) == e_LogLevel.e_log_warn)
	        {
	            dt.setTime(System.currentTimeMillis());
	            String strOut = dt.toString() + " warn: " + strMess;
	            if (m_bConsoleOut) System.out.println(strOut);
	            if (m_bLogOpen) m_ps.println(strOut);
	        }
	    }
	    public boolean bWarn(){return ((m_iLogLevel & e_LogLevel.e_log_warn) == e_LogLevel.e_log_warn);}
	   
	    
	    public void error(String strMess)
	    {
	        if ((m_iLogLevel & e_LogLevel.e_log_error) == e_LogLevel.e_log_error)
	        {
	            dt.setTime(System.currentTimeMillis());
	            String strOut = dt.toString() + " err: " + strMess;
	            if (m_bConsoleOut) System.out.println(strOut);
	            if (m_bLogOpen) m_ps.println(strOut);
	        }
	    }
	    public boolean bError(){return ((m_iLogLevel & e_LogLevel.e_log_error) == e_LogLevel.e_log_error);}

	  
	    public String GetLogFileName()
	    {
	        return m_strLogPath + m_strLogFile + ".log";
	    }

	
	    public boolean OpenLog()
	    {
	        try
	        {
	            m_ps = new PrintStream(new FileOutputStream(GetLogFileName()));
	            m_bLogOpen = true;
	        }
	        catch (FileNotFoundException e)
	        {
	            // this means that the folder doesn't exist
	            if (MakeFolder(m_strLogPath))
	            {
	                m_bLogOpen = true;
	                try
	                {
	                    m_ps = new PrintStream(new FileOutputStream(GetLogFileName()));
	                }
	                catch (IOException e1)
	                {
	                    e.printStackTrace();
	                    m_bLogOpen = false;
	                }
	            }
	        }
	        return m_bLogOpen;
	    }

	    public static boolean MakeFolder(String strFolder)
	    {
	        try
	        {
	            java.io.File f = new File(strFolder);
	            if (!f.mkdirs())
	            {
	                return false;
	            }
	        }
	        catch (SecurityException e)
	        {
	            e.printStackTrace();
	            return false;
	        }
	        return true;
	    }

	 
	    public boolean CloseLog()
	    {
	        if (m_ps != null)
	        {
	            m_ps.flush();
	            m_ps.close();
	        }
	        m_bLogOpen = false;
	        return m_bLogOpen;
	    }

	    public void setConsoleOut(boolean b)
	    {
	        m_bConsoleOut = b;
	    }
	    public void setLogLevel(int i)
	    {
	        m_iLogLevel = i;
	    }

	}

