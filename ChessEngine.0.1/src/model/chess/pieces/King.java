package model.chess.pieces;

import model.chess.PlayerColor;

public class King extends ChessPiece {

	public King(PlayerColor color) {
		super(color);
	}

	public String toString() {
		return getColor().getAbbriviation() + "K";
	}
}
