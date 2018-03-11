package controller;

import java.io.IOException;

public class Engine {

	private static Engine engine; 

	private Engine()  {
		
	}

	public static Engine getInstance() throws IOException {
		if(engine == null) {
			engine = new Engine();
		}
		return engine;
	}

	public String tell(String msgFromGui) {
		// TODO Auto-generated method stub
		
		if(msgFromGui.equals("uci")){
			
		}
		
		return msgFromGui;
		
	}


}
