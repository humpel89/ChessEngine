package controller.utilities;

@SuppressWarnings("serial")
public class IncorrectStringFormatException extends Exception {
		
		public IncorrectStringFormatException(String message) {
	        super(message);
	    }
	    
	    public IncorrectStringFormatException(String message, Throwable throwable) {
	        super(message, throwable);
	    }
	    
}
