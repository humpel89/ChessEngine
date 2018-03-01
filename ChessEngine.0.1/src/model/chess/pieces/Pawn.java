package model.chess.pieces;

import model.chess.PlayerColor;

public class Pawn extends ChessPiece {

	public Pawn(PlayerColor color) {
		super(color);
		// TODO Auto-generated constructor stub
	}

	public String toString() {
		return getColor().getAbbriviation() + "P";
	}
}
