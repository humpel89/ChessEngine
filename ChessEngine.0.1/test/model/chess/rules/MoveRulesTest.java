package model.chess.rules;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import model.chess.Board;

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
	
	@Test
	void testGetAllMovesForPieceAt() {
		fail("Not implemented");
	}
	
	@Test
	void testPawnMove() {
		fail("Not implemented");
	}
	
	@Test
	void testRookMove() {
		fail("Not implemented");
	}
	
	@Test
	void testKnightMove() {
		fail("Not implemented");
	}
	
	@Test
	void testBishopMove() {
		fail("Not implemented");
	}
	
	@Test
	void testQueenMove() {
		fail("Not implemented");
	}
	
	@Test
	void testKingMove() {
		fail("Not implemented");
	}
	

}
