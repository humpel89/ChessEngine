package model.chess.moves;

public class NormalMove implements Move {

	private int from;
	private int to;
	
	public NormalMove(String stringOfMove) throws NoValidCoordinateException {
		setMove(stringOfMove);
	}
	
	@Override
	public void setMove(String stringOfMove) throws NoValidCoordinateException {
		move(stringOfMove.substring(0, 2), stringOfMove.substring(3, 5));
	}

	@Override
	public void move(String from, String to) throws NoValidCoordinateException {
		this.from = getIntFromCoordinate(from);
		this.to = getIntFromCoordinate(to);	
	}

	private int getIntFromCoordinate(String coordinate) throws NoValidCoordinateException {
		int x = getNbrFromChar(coordinate.charAt(0));
		int y = Integer.valueOf(coordinate.substring(1));
		//Calc correct 0-63 nbr
		int f = 8 * (y-1) + x;
		return f;
	}

	private int getNbrFromChar(char c) throws NoValidCoordinateException {
		switch (c) {
		case 'a': return 0;
		case 'b': return 1;
		case 'c': return 2;
		case 'd': return 3;
		case 'e': return 4;
		case 'f': return 5;
		case 'g': return 6;
		case 'h': return 7;
		default:
			throw new NoValidCoordinateException("Tried to build a move from invalid coordinate");
		}

	}

	@Override
	public int getFrom() {
		return from;
	}

	@Override
	public int getTo() {
		return to;
	}

}
