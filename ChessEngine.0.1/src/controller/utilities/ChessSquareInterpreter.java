package controller.utilities;

public class ChessSquareInterpreter {
	
	private static ChessSquareInterpreter cInterpreter;
	
	private ChessSquareInterpreter() {
		
	}
	
	public int getAxisIntOfChar(char c) {
		return 0;
	}

	public static ChessSquareInterpreter getInstance() {
		if(cInterpreter == null) {
			cInterpreter = new ChessSquareInterpreter();
		}
	return cInterpreter;
	}

	public int convert(String string) throws IncorrectStringFormatException {
		if (string.length() != 2) {
			throw new IncorrectStringFormatException("Converted square location string had a > 2 .length.");
		}
		int xyLocationInSingleDigit = 9;
		if(string.substring(0, 1).matches("A") && string.substring(1, 2).matches("1"))
			xyLocationInSingleDigit = 0;
		return xyLocationInSingleDigit;
		
	}
	
}
