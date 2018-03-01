package model.chess;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.chess.pieces.ChessPiece;
import model.chess.pieces.King;
import model.chess.pieces.Pawn;

class SquareTest {

	Square square;
	ChessPiece king;
	ChessPiece pawn;
	
	@BeforeEach
	void setUp() {
		square = new Square();
		king = new King(PlayerColor.BLACK);
		pawn = new Pawn(PlayerColor.BLACK);
	}

	@Test
	void testPlacePiece() {
		square.placePiece(king);
		assertEquals(king, square.occupatedBy());
	}

	@Test
	void testGetPiece() {
		square.isEmpty();
		square.placePiece(king);
		assertEquals(king, square.occupatedBy());
		square.placePiece(pawn);
		assertEquals(pawn, square.occupatedBy());
	}

	@Test
	void testRemovePiece() {
		square.placePiece(king);
		ChessPiece piece = square.removePiece();
		assertTrue(square.isEmpty());
		assertTrue(piece.equals(king));
	}

	@Test
	void testIsEmpty() {
		assertTrue(square.isEmpty());
		square.placePiece(pawn);
		assertFalse(square.isEmpty());
	}

}
