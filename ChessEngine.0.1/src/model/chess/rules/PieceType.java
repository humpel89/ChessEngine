package model.chess.rules;

public enum PieceType {
	KING('K'), QUEEN('Q'), BISHOP('B'), KNIGHT('N'), ROOK('R'), PAWN('P'), NONE(' ');

	private char pieceLetter;
	
	private PieceType(char c) {
		this.pieceLetter = c;
	}
	
	public char getSingleLetter() {
		return pieceLetter;
	}

}


