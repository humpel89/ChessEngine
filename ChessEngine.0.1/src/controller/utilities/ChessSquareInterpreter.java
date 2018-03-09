package controller.utilities;

import model.chess.rules.MoveRules;

public class ChessSquareInterpreter {
	
	private static ChessSquareInterpreter cInterpreter;
	
	private ChessSquareInterpreter() {
		
	}
	
	public int getAxisIntOfChar(char c) {
		return 0;
	}

	//SKriv kod för att returnera klassens instance
	public static ChessSquareInterpreter getInstance() {
		if(cInterpreter == null) {
			cInterpreter = new ChessSquareInterpreter();
		}
	return cInterpreter;
	}
	
}
