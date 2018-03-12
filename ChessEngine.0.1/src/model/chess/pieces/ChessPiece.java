package model.chess.pieces;

import model.chess.PlayerColor;
import model.chess.rules.MoveRules;

public abstract class ChessPiece {
	
	private PlayerColor color;
	private MoveRules moveRule;
	
	public ChessPiece(PlayerColor color) {
		this.color = color;;
	}
	
	public PlayerColor getColor() {
		return color;
	}

	public MoveRules getMoveRule() {
		return moveRule;
	}

	public boolean checkMoveToPossible(int to) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
