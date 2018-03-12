package model.chess.moves;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import controller.utilities.IncorrectStringFormatException;

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

	@Test
	void testDetermineHorizontalDirection() throws NoValidCoordinateException {
		assertEquals(Direction.HORIZONTAL, new NormalMove ("A4 D4").getDirection());
		assertEquals(Direction.HORIZONTAL, new NormalMove ("D4 A4").getDirection());
		assertEquals(Direction.HORIZONTAL, new NormalMove ("C6 E6").getDirection());
		assertEquals(Direction.HORIZONTAL, new NormalMove ("A5 G5").getDirection());

		assertNotEquals(Direction.HORIZONTAL, new NormalMove ("A5 A6").getDirection());
		assertNotEquals(Direction.HORIZONTAL, new NormalMove ("C1 G5").getDirection());
		assertNotEquals(Direction.HORIZONTAL, new NormalMove ("H7 H4").getDirection());
		assertNotEquals(Direction.HORIZONTAL, new NormalMove ("B1 C2").getDirection());
	}

	@Test
	void testDetermineVerticalDirection() throws NoValidCoordinateException {
		assertEquals(Direction.VERTICAL, new NormalMove ("A4 A2").getDirection());
		assertEquals(Direction.VERTICAL, new NormalMove ("D2 D4").getDirection());
		assertEquals(Direction.VERTICAL, new NormalMove ("C7 C1").getDirection());
		assertEquals(Direction.VERTICAL, new NormalMove ("H1 H8").getDirection());

		assertNotEquals(Direction.VERTICAL, new NormalMove ("A5 B6").getDirection());
		assertNotEquals(Direction.VERTICAL, new NormalMove ("C1 G5").getDirection());
		assertNotEquals(Direction.VERTICAL, new NormalMove ("A2 B4").getDirection());
	}

	@Test
	void testDetermineDiagonalDirection() throws NoValidCoordinateException {
		assertEquals(Direction.DIAGONAL, new NormalMove ("A1 D4").getDirection());
		assertEquals(Direction.DIAGONAL, new NormalMove ("C1 H6").getDirection());
		assertEquals(Direction.DIAGONAL, new NormalMove ("F8 A3").getDirection());
		assertEquals(Direction.DIAGONAL, new NormalMove ("B5 F1").getDirection());

		assertNotEquals(Direction.DIAGONAL, new NormalMove ("A5 A6").getDirection());
		assertNotEquals(Direction.DIAGONAL, new NormalMove ("C1 C5").getDirection());
		assertNotEquals(Direction.DIAGONAL, new NormalMove ("A7 H7").getDirection());
	}

	@Test
	void testDetermineKnightMoveDirection() throws NoValidCoordinateException {
		assertEquals(Direction.KNIGHTMOVE, new NormalMove ("B1 C3").getDirection());
		assertEquals(Direction.KNIGHTMOVE, new NormalMove ("G8 F6").getDirection());
		assertEquals(Direction.KNIGHTMOVE, new NormalMove ("G8 E7").getDirection());
		assertEquals(Direction.KNIGHTMOVE, new NormalMove ("G1 F3").getDirection());

		assertNotEquals(Direction.KNIGHTMOVE, new NormalMove ("B1 C2").getDirection());
		assertNotEquals(Direction.KNIGHTMOVE, new NormalMove ("A7 H7").getDirection());
	}

	@Test
	void testThrowsWhenImpossibleMovesDiscovered() {
		assertThrows(NoValidCoordinateException.class,
				()->{
					new NormalMove ("B1 C4").getDirection();
				});  
		assertThrows(NoValidCoordinateException.class,
				()->{
					new NormalMove ("H7 A4").getDirection();
				});  
	}

	@Test
	void testCharManipulations() {
		char a = 'A';
		char c = 'A';
		int one = 1;
		assertTrue(a - 'A' == 0);
		//a char minus another char results in its number representation. 
		assertTrue(a - 'A' + 1 == one);
		assertTrue(a - 'A' + 1 == one);
		//OBS Case sensitive.
		assertFalse(a - 'a' + 1 == one);
		assertFalse(a - 'a' + 1 == one);

	}

}
