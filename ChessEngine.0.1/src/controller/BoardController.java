package controller;

import controller.utilities.ChessSquareInterpreter;
import controller.utilities.IncorrectStringFormatException;
import model.chess.Board;
import model.chess.moves.NoValidCoordinateException;
import model.chess.moves.NormalMove;
import model.chess.rules.MoveRules;

public class BoardController {
	private Board board;
	private ChessSquareInterpreter CSI;
	private MoveRules rules;

	public BoardController() {
		board = new Board();
		CSI = ChessSquareInterpreter.getInstance();
		rules = MoveRules.getInstance();
	}

	public boolean isSquareEmpty(String string) throws IncorrectStringFormatException {
		return board.isEmptySquare(CSI.interpretToInt(string));
	}

	public void move(String string) throws IncorrectStringFormatException, NoValidCoordinateException {
		if (string.length() > 5) {
			throw new IncorrectStringFormatException("A move string can only have a max of 5 characters in length.");
		}
		else {
			//TODO Test for valid move with moverules....
			/*
			 * if validMove(board move);
			 * 		makeMove
			 */
			board.makeMove(new NormalMove(string));
			
		}
	}
}
