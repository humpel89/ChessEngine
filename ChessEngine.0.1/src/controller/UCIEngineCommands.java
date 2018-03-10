package controller;


/*
 * Constructed with aid of the description of the protocol at:
 * http://wbec-ridderkerk.nl/html/UCIProtocol.html
 */
public interface UCIEngineCommands {

	public String uci();
	
	public void debug();
	
	public String isReady();
	
	/* example strings for setOption:
	 * "setoption name Nullmove value true\n"
      "setoption name Selectivity value 3\n"
	   "setoption name Style value Risky\n"
	   "setoption name Clear Hash\n"
	   "setoption name NalimovPath value c:\chess\tb\4;c:\chess\tb\5\n"
	 */
	public void setOption(String string);
	
	public void register(String string);
	
	public String uciNewGame();
	
	public void position (String fenString);
	
	public void go(String string);
	
	public void stop();
	
	public void ponderHit();
	
	public void quit();
	
	
}
