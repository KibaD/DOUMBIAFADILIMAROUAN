package com.esiea.log;

public interface MaClasse  {
	
	abstract public void debug(String message);
    abstract public void info(String message);
    abstract public void warn(String message);
    abstract public void error(String message);

    abstract public void  setLogLevel(int i);
    abstract public void setConsoleOut(boolean b);
    abstract public boolean CloseLog();
    abstract public boolean OpenLog();

    abstract public boolean bDebug();

}
