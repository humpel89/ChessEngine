package controller;

public interface UCIEngineReplies {

	public void id(String string);
	
	public void uciOk();
	
	public void readyOk();
	
	public void bestMove(String move);
	
	//public void copyProtection();
	
	//public void registration();
	
	/*
	 * Info can has many many commands, maybe it will need a class
	 * on its own to hold everything in a smooth way.
	 */
	public void info(String string);
	
	
}
