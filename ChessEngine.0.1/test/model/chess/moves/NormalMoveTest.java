package model.chess.moves;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NormalMoveTest {

	NormalMove move;
	
	@BeforeEach
	void setUp() throws NoValidCoordinateException {
		move = new NormalMove("a2 a4");
	}

	@Test
	void testSetMove() {
		fail("Not yet implemented");
	}

	@Test
	void testMove() {
		fail("Not yet implemented");
	}

	@Test
	void testGetFrom() {
		assertEquals(8, move.getFrom());
	}

	@Test
	void testGetTo() {
		assertEquals(24, move.getTo());
	}

}
