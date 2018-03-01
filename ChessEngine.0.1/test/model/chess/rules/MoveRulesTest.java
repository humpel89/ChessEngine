package model.chess.rules;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class MoveRulesTest {

	@Test
	void testGetInstance() {
		MoveRules moveRules;
		moveRules = MoveRules.getInstance();
		assertEquals(MoveRules.class, moveRules.getClass()); 
	}
	
	@Test
	void testGetAnotherInstance() {
		MoveRules moveRules1 = MoveRules.getInstance();
		MoveRules moveRules2 = MoveRules.getInstance();
		MoveRules moveRules3 = null;
		
		assertNotEquals(null, moveRules1); 
		assertEquals(moveRules1, moveRules2); 
		assertNotEquals(moveRules3, moveRules2);
	}

}
