package model.chess;

@SuppressWarnings("serial")
public class SquareEmptyException extends Exception {

		public SquareEmptyException(String message) {
	        super(message);
	    }
	    
	    public SquareEmptyException(String message, Throwable throwable) {
	        super(message, throwable);
	    }
	    
}
