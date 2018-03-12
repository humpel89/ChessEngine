package model.chess.rules;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.chess.moves.NoValidCoordinateException;
import model.chess.moves.NormalMove;

class MoveRulesTest {

	MoveRules moveRules;
	
	@BeforeEach
	void setUp() {
		moveRules = MoveRules.getInstance();

	}
	
	@Test
	void testGetInstance() {
		MoveRules moveRulesX;
		moveRulesX = MoveRules.getInstance();
		assertEquals(MoveRules.class, moveRulesX.getClass()); 
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
	void testPawn1stepMove() throws NoValidCoordinateException {
		assertTrue(moveRules.ifValidMove("FenNotImplemented", new NormalMove("A2 A3")));
	}
	
	@Test
	void testPawn2stepStartMove() throws NoValidCoordinateException {
		assertTrue(moveRules.ifValidMove("FenNotImplemented", new NormalMove("A2 A4")));
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
