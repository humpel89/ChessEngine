package controller;

import model.chess.Board;

public class BoardController {
	private Board board;
	
	public BoardController() {
		board = new Board();
	}

	public boolean isSquareEmpty(String string) {
		
		return board.isEmptySquare(0);
	}
}
