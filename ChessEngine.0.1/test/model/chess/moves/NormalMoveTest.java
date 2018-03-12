package model.chess.moves;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NormalMoveTest {

	NormalMove move1;
	NormalMove move2;
	
	@BeforeEach
	void setUp() throws NoValidCoordinateException {
		move1 = new NormalMove("a2 a4");
		move2 = new NormalMove("A2 A4");
	}

	@Test
	void testSetMove() throws NoValidCoordinateException {
	
		move1.setMove("b7 b5");
		assertEquals(49, move1.getFrom());
		assertEquals(33, move1.getTo());
		move2.setMove("C2 C4");
		assertEquals(10, move2.getFrom());
		assertEquals(26, move2.getTo());
	}

	@Test
	void testMove() throws NoValidCoordinateException {
		move1.move("b7", "b5");
		assertEquals(49, move1.getFrom());
		assertEquals(33, move1.getTo());
	}
	
	@Test
	void testGetFrom() {
		assertEquals(8, move1.getFrom());
		assertEquals(24, move1.getTo());
	}

	@Test
	void testGetTo() {
		assertEquals(8, move2.getFrom());
		assertEquals(24, move2.getTo());
	}

}
