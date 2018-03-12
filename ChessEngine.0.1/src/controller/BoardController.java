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

	public boolean move(String string) throws IncorrectStringFormatException, NoValidCoordinateException {
		if (string.length() > 5 || string.charAt(2) != ' ') {
			throw new IncorrectStringFormatException("A move string can only have a max of 5 characters in length and needs a space between coords.");
		}
		else {
			//TODO Test for valid move with moverules....
			NormalMove move = new NormalMove(string);
			if(rules.ifValidMove(board.getFenStringOfBoardState(), move)){
				board.makeMove(move);
				return true;
			}
			else {
				return false;
			}
		}
	}
}
