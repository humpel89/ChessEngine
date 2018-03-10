package model.chess;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.chess.pieces.Pawn;

class BoardTest {

	Board board;
	
	@BeforeEach
	void setUp() {
		board = new Board();
	}
	
	@Test
	void testSetUpNewGame() {
		board.makeMove(9, 25);
		board.makeMove(52, 36);
		board.makeMove(6, 21);
		System.out.println(board.toString());
		assertTrue(board.isEmptySquare(6));
		assertTrue(board.isEmptySquare(9));
		board.setUpNewGame();
		System.out.println(board.toString());
		assertFalse(board.isEmptySquare(6));
		assertFalse(board.isEmptySquare(9));
	}

	@Test
	void testSetUpBoard() {
		board.setUpBoard("A2A4 B7B6 B");
	}

	@Test
	void testIsEmptySquareSingleInt() {
		assertTrue(board.isEmptySquare(25));
	}
	
	@Test
	void testIsEmptySquareXYInt() {
		assertTrue(board.isEmptySquare(16));
		assertTrue(board.isEmptySquare(37));
		assertTrue(board.isEmptySquare(41));
		assertTrue(board.isEmptySquare(47));
	}
	
	@Test
	void testGetStringRepOfBoardState() {
		assertTrue(board.isEmptySquare(6));
	}

	@Test
	void testMakeMove() {
		board.makeMove(8, 24);
		System.out.println(board.toString());
		assertEquals(Pawn.class, board.getPieceAt(24).getClass());
		assertTrue(board.isEmptySquare(8));
		assertFalse(board.isEmptySquare(24));
		board.makeMove(52, 36);
		assertEquals(Pawn.class, board.getPieceAt(36).getClass());
		assertTrue(board.isEmptySquare(52));
		assertFalse(board.isEmptySquare(36));
		System.out.println(board.toString());
	}

	@Test
	void testUndoMove() {
		fail("Not yet implemented");
	}

	@Test
	void testRedoMove() {
		fail("Not yet implemented");
	}

	@Test
	void testToString() {
		System.out.println(board.toString());
	}

}
