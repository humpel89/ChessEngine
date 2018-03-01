package model.chess.pieces;

import model.chess.PlayerColor;

public class Knight extends ChessPiece {

	public Knight(PlayerColor color) {
		super(color);
	}
	
	public String toString() {
		return getColor().getAbbriviation() + "N";
	}
}
