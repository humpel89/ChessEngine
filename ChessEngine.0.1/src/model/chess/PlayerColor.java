package model.chess;

public enum PlayerColor {
	WHITE('w'), BLACK('b');

	private char c;
	
	private PlayerColor(char c) {
		this.c = c;
	}
	
	public char getAbbriviation() {
		return c;
	}
}
