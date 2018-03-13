package model.chess.moves;

public interface Move {
	
		public void setMove(String stringRep) throws NoValidCoordinateException;
		
		public void move(String from, String to) throws NoValidCoordinateException;
		
		public int getFrom();
		
		public int getTo();
		
		public Direction getDirection();
		
		public int getDistance();
}
