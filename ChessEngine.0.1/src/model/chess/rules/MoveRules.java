package model.chess.rules;

import java.util.ArrayList;

import model.chess.Board;
import model.chess.PlayerColor;
import model.chess.moves.Direction;
import model.chess.moves.Move;
import model.chess.pieces.ChessPiece;
import model.chess.pieces.Pawn;

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
		Board board = new Board();
		ChessPiece piece = board.getPieceAt(move.getFrom());

		if(piece.getClass().equals(Pawn.class)) {
			return checkPawnMove(piece.getColor(), board, move);
		}
		//TODO
//		if(piece.getClass().isInstance(Rook.class)) {
//
//		}
//		if(piece.getClass().isInstance(Knight.class)) {
//
//		}
		// etc

		return true;
	}

	private boolean checkPawnMove(PlayerColor color, Board board, Move move) {
		if(move.getDirection() != Direction.VERTICAL){
			return false;
		}
		//TODO Implement pawn capture for 1 diagonal square.
		
		if(color.equals(PlayerColor.WHITE)) {
			if(move.getFrom() < 16 && move.getDistance() == 2) {
				//Add check for blocking pieces
				return true;
			}
			else {
				if(move.getDistance() == 1);
					return true;
			}
				
		}
		
		move.getFrom();
		return false;
	}


	private boolean allowedLengthOf(Move move, int length ) {
		if (true) {
			move.getFrom();
		}
		return false;
	}

	public ArrayList<Move> getAllMovesForPieceAt(String from, Board board){
		return null;
	}

}
