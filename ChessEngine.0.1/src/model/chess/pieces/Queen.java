package model.chess.pieces;

import model.chess.PlayerColor;

public class Queen extends ChessPiece {

	public Queen(PlayerColor color) {
		super(color);
	}
	
	public String toString() {
		return getColor().getAbbriviation() + "Q";
	}
}
