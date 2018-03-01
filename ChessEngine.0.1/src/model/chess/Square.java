package model.chess;

import model.chess.pieces.ChessPiece;

public class Square {

	private ChessPiece piece;
	private boolean hasPiece;;
	
	public Square() {
		hasPiece = false;
	}
	
	public Square(ChessPiece piece) {
		placePiece(piece);
	}
	
	public void placePiece(ChessPiece piece) {
		this.piece = piece;
		hasPiece = true;
	}
	
	public ChessPiece occupatedBy() {
		return piece;
	}
	
	public ChessPiece removePiece() {
		ChessPiece removedPiece = piece;
		piece = null;
		hasPiece = false;
		return removedPiece;
	}
	
	public boolean isEmpty() {
		return !hasPiece;
	}
	
	public String toString() {
		if (isEmpty())
			return "[  ]";
		else
			return "[" + piece.toString() + "]";
	}
	
}
