package controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import controller.utilities.IncorrectStringFormatException;
import model.chess.moves.NoValidCoordinateException;

class BoardControllerTest {

	BoardController bc;
	
	@BeforeEach
	void setUp() {
		bc = new BoardController();
	}
	
	@Test
	void testBoardController() {
		assertEquals(BoardController.class, bc.getClass());
	}
	
	
	@Test
	void testIsSquareEmpty() throws IncorrectStringFormatException {
		assertFalse(bc.isSquareEmpty("A1"));
		assertFalse(bc.isSquareEmpty("H7"));
		assertTrue(bc.isSquareEmpty("A3"));
		assertTrue(bc.isSquareEmpty("C3"));
		assertTrue(bc.isSquareEmpty("B6"));
		assertTrue(bc.isSquareEmpty("G3"));
	}

	@Test
	void testMove() throws IncorrectStringFormatException, NoValidCoordinateException {
		assertTrue(bc.isSquareEmpty("A4"));
		bc.move("A2 A4");
		assertFalse(bc.isSquareEmpty("A4"));
	}
}
