package view.gui;

import java.io.IOException;
import controller.Engine;

public class EngineCommunicator {

	private Engine engine;
	
	public EngineCommunicator() throws IOException {
		engine = Engine.getInstance();
	}
	
	public boolean move(String move) {
		return engine.makeMove(move);
	}

	public void uci() {
		engine.tell("uci");
	}

	public void debug() {
		engine.tell("debug");

	}

	public boolean isReady() {
		return "ReadyOk".equals(engine.tell("isready"));
	}

	public void setOption(String string) {
		engine.tell("setoption " + string);

	}

	public void uciNewGame() {
		engine.tell("ucinewgame");
	}

	public void position(String fenString) {
		engine.tell("position " + fenString);

	}

	public String go(String string) {
		return engine.tell("go " + string);

	}

	public void stop() {
		engine.tell("stop");

	}

	public void ponderHit() {
		engine.tell("ponderhit");
	}

	public void quit() {
		engine.tell("quit");

	}


}
