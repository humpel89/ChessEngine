package model.chess.rules;

import model.chess.Board;
import model.chess.moves.Move;

public interface MoveSets {

	public boolean validPawnMove(Board board, Move move);
	
	public boolean validRookMove(Board board, Move move);
	
	public boolean validKnightMove(Board board, Move move);
	
	public boolean validBishopMove(Board board, Move move);
	
	public boolean validQueenMove(Board board, Move move);
	
	public boolean validKingMove(Board board, Move move);
	
}
