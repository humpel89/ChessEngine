package controller.utilities;

public class ChessSquareInterpreter {

	private static ChessSquareInterpreter cInterpreter;
	private static final int EIGHT = 8;
	private static final int SUBTRACT_ONE = 1;

	private ChessSquareInterpreter() {

	}

	public static ChessSquareInterpreter getInstance() {
		if(cInterpreter == null) {
			cInterpreter = new ChessSquareInterpreter();
		}
		return cInterpreter;
	}

	public int interpretToInt(String string) throws IncorrectStringFormatException {
		if (string.length() != 2) {
			throw new IncorrectStringFormatException("Converted square location string had a > 2 .length.");
		}
		else {
			int x = getDigitForFirstLetter(string.toLowerCase().charAt(0));
			int y = getDigitFrom2ndLetter(string.substring(1, 2));
			return y * EIGHT + x ;
		}
	}

	private int getDigitForFirstLetter(char c) throws IncorrectStringFormatException {
		int digit = c - 'a';
		if(digit < 0 || 7 < digit)
			throw new IncorrectStringFormatException("Invalid letter passed to converter, only A-H accepted");
		return digit;
	}

	private int getDigitFrom2ndLetter(String s) throws IncorrectStringFormatException {
		int y;
		if(isNumeric(s)) {
			y = Integer.valueOf(s) - SUBTRACT_ONE;
			if(0 <= y && y < 8) {
				return y;
			}
		}
		throw new IncorrectStringFormatException("Invalid number representation of letter");

	}

	//https://stackoverflow.com/questions/1102891/how-to-check-if-a-string-is-numeric-in-java
	private boolean isNumeric(String str)  
	{  
		try  
		{  
			double d = Double.parseDouble(str);  
		}  
		catch(NumberFormatException nfe)  
		{  
			return false;  
		}  
		return true;  
	}
}
