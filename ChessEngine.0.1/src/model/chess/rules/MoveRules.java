package model.chess.rules;

import java.util.ArrayList;

import model.chess.Board;
import model.chess.moves.Move;

/*
 * Singleton design pattern
 */
public class MoveRules {
	
	private static MoveRules moveRules;
	
	private MoveRules() {
	}
	
	public static MoveRules getInstance() {
		if(moveRules == null) {
			 moveRules = new MoveRules();
		}
		return moveRules;
	}
	
	public boolean ifValidMove(String fen, Move move) {
		
		
		
		return false;
	}
	
	public ArrayList<Move> getAllMovesForPieceAt(String from, Board board){
		return null;
	}
	
}
