package model.chess.rules;

/*
 * Singleton design pattern
 */
public class MoveRules {
	
	private static MoveRules moveRules;
	
	private MoveRules() {
	}
	
	public static MoveRules getInstance() {
		if(moveRules == null) {
			 moveRules = new MoveRules();
		}
		return moveRules;
	}
}
