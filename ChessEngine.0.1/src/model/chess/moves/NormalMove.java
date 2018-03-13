package model.chess.moves;

public class NormalMove implements Move {

	private int from;
	private int to;

	private Direction direction;
	private int distance;

	public NormalMove(String stringOfMove) throws NoValidCoordinateException {
		setMove(stringOfMove);
	}

	@Override
	public void setMove(String stringOfMove) throws NoValidCoordinateException {
		move(stringOfMove.substring(0, 2), stringOfMove.substring(3, 5));
	}

	@Override
	public void move(String from, String to) throws NoValidCoordinateException {
		from = from.toLowerCase();
		to = to.toLowerCase();
		setDirection(from, to);
		this.from = getIntFromCoordinate(from);
		this.to = getIntFromCoordinate(to);	
	}

	private void setDirection(String from, String to) throws NoValidCoordinateException {

		int fromX = from.charAt(0) - 'a' + 1;
		int fromY = Integer.valueOf(from.substring(1));
		int toX = to.charAt(0) - 'a' +1;
		int toY = Integer.valueOf(to.substring(1));
		if (fromY == toY) {
			direction = Direction.HORIZONTAL;
			distance = Math.abs(fromX - toX);
		}
		else {
			if (fromX == toX){
				direction = Direction.VERTICAL;
				distance = Math.abs(fromY - toY);
			}
			else {
				double dy = (double) Math.abs(fromY - toY);
				double dx = (double) Math.abs(fromX - toX);
				if(checkDiagonal(dy, dx)) { //Chans att vara diagonal DERIVATAN FFS
					direction = Direction.DIAGONAL;
					distance = Math.abs(fromY - toY); //Since diagonal, both result from x or y would be correct distance.
				}
				else {
					if(checkKnightMove(dy, dx)) {
						direction = Direction.KNIGHTMOVE;
						distance = 3;
					}
					else
						throw new NoValidCoordinateException(
								"The coordinates had moves that was impossible for a piece to do");
				}
			}
		}


	}

	private boolean checkDiagonal(double dy, double dx) {
		double derivate = dy / dx;
		if(derivate == 1.0)
			return true;
		else
			return false;
	}

	private boolean checkKnightMove(double dy, double dx) {
		double derivate = dy / dx;
		double hypotenusa = Math.sqrt(Math.pow(dy, 2) + Math.pow(dx, 2));
		//Derivate 2 or 0,5 BUT Also remember distance cant be more than 3.
		if((derivate == 2.0 ||derivate == 0.5) && (hypotenusa == Math.sqrt(5.0)))
			return true;
		else
			return false;
	}
	
	
	public Direction getDirection() {
		return direction;
	}

	
	public int getDistance() {
		return distance;
	}

	private int getIntFromCoordinate(String coordinate) throws NoValidCoordinateException {
		int x = getNbrFromChar(coordinate.charAt(0));
		int y = Integer.valueOf(coordinate.substring(1));
		if(0 > 0 || y < 9 ) {
			int f = 8 * (y-1) + x;	//Calc correct 0-63 nbr
			return f;
		}
		else {
			throw new NoValidCoordinateException("Number coord was not valid");
		}
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
