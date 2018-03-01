package model.chess.pieces;

import model.chess.PlayerColor;
import model.chess.rules.MoveRules;

/*
 * Rook, english chess notation for "tower" or swedish: "Torn"
 */
public class Rook extends ChessPiece {

	public Rook(PlayerColor color) {
		super(color);
	}
	
	@Override
	public MoveRules getMoveRule() {
		return null;
		
	}
	
	public String toString() {
		return getColor().getAbbriviation() + "R";
	}
}


