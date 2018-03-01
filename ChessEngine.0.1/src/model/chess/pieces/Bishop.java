package model.chess.pieces;

import model.chess.PlayerColor;

/*
 * Bishop, english chess notation for the swedish: "Löpare"
 */
public class Bishop extends ChessPiece {

	public Bishop(PlayerColor color) {
		super(color);
	}
	
	public String toString() {
		return getColor().getAbbriviation() + "B";
	}
}
