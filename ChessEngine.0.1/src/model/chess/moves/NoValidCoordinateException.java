package model.chess.moves;

@SuppressWarnings("serial")
public class NoValidCoordinateException extends Exception {
	
	public NoValidCoordinateException(String message) {
        super(message);
    }
    
    public NoValidCoordinateException(String message, Throwable throwable) {
        super(message, throwable);
    }
    
}
