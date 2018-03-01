package model.chess;

@SuppressWarnings("serial")
public class StackIsEmptyException extends Exception {

		public StackIsEmptyException(String message) {
	        super(message);
	    }
	    
	    public StackIsEmptyException(String message, Throwable throwable) {
	        super(message, throwable);
	    }
	    
}
