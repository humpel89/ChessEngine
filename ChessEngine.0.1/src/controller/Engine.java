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

	public String tell(String msg) {
		// TODO Auto-generated method stub

		if(msg.equals("uci")){
			reply("uciok");
			return "uciok";
		}
		else {
			if(msg.equals("isready")){
				reply("ReadyOk");
				return "ReadyOk";
			}
			else {
				if(msg.startsWith("setOption")){
					reply("No options available...");
				}
				else {
					if(msg.equals("uciNewGame")){
						reply("Starting new game...");
					}
					else {
						if(msg.startsWith("position")){
							reply("Fen string set... ");
						}
						else {

							if(msg.startsWith("go")){
								reply("best move found was...");
								//TODO search for best move
								return "best move";
							}
							else {
								if(msg.equals("stop")){
									reply("Searching stopped...");
								}
								else {
									if(msg.equals("stop")){
										reply("Searching stopped...");
									}
									else {
										if(msg.equals("quit")){
											reply("quitting...");
											System.exit(0);
										}
									}
								}
							}
						}
					}
				}
			}
		}
		return msg;


	}

	private void reply(String msg) {
		System.out.println(msg);
	}


}
