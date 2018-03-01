package model.chess;

import model.chess.moves.Move;

public interface ChessBoard {

	public void setUpNewGame();
	
	public void setUpBoard(String boardState);
	
	public String getStringRepOfBoardState();
	
	public void makeMove(Move move);
	
	public void undoMove();
	
	public void redoMove();
	
	
}
