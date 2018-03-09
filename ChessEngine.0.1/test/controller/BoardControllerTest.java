package controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
	void testIsSquareEmpty() {
		assertEquals(false, bc.isSquareEmpty("A1"));
	}

}
