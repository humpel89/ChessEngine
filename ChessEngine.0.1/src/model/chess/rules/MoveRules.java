package model.chess.rules;

import java.util.ArrayList;

import model.chess.Board;
import model.chess.PlayerColor;
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

		if(piece.getClass().isInstance(Pawn.class)) {
			return checkPawnMove(piece.getColor(), board, move);
		}
		if(piece.getClass().isInstance(Pawn.class)) {

		}
		if(piece.getClass().isInstance(Pawn.class)) {

		}

		return false;
	}

	private boolean checkPawnMove(PlayerColor color, Board board, Move move) {
		int distance = 1;
		if(color.equals(PlayerColor.WHITE)) {
			if(move.getFrom() < 16) {
				distance = 2;
			}
				
		}
		
		move.getFrom();
		return false;
	}


	private boolean allowedLengthOf(Move move, int length ) {
		if (moveIsRightHorizontal(move)) {
			move.getFrom();
		}
		return false;
	}

	private boolean moveIsRightHorizontal(Move move) {
		// TODO Auto-generated method stub
		return false;
	}

	private int differenceOf(int x, int y) {
		return x - y;
	}

	public ArrayList<Move> getAllMovesForPieceAt(String from, Board board){
		return null;
	}

}
