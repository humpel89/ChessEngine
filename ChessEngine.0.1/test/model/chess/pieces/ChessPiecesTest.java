package model.chess.pieces;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.chess.PlayerColor;
import model.chess.rules.MoveRules;

class ChessPiecesTest {
	
	ChessPiece whiteKing;
	ChessPiece blackKing;
	ChessPiece whiteKnight;
	ChessPiece whiteKnight2;
	ChessPiece blackKnight;
	ChessPiece pawn1;
	ChessPiece pawn2;
	ChessPiece pawn3;
	ChessPiece bishop;
	ChessPiece rook;
	ChessPiece queen;
	
	@BeforeEach
	void setUp() throws Exception {
		whiteKing = new King(PlayerColor.WHITE);
		blackKing = new King(PlayerColor.BLACK);
		whiteKnight = new Knight(PlayerColor.WHITE);
		whiteKnight2 = new Knight(PlayerColor.WHITE);
		blackKnight = new Knight(PlayerColor.BLACK);
		pawn1 = new Pawn(PlayerColor.WHITE);
		pawn2 = new Pawn(PlayerColor.WHITE);
		pawn3 = new Pawn(PlayerColor.WHITE);
		bishop = new Bishop(PlayerColor.WHITE);
		rook = new Rook(PlayerColor.WHITE);
		queen = new Rook(PlayerColor.WHITE);
	}

	@Test
	void testCorrectColorOnPiece() {
		assertEquals(PlayerColor.WHITE, whiteKing.getColor());
		assertEquals(PlayerColor.BLACK, blackKing.getColor());
		assertEquals(PlayerColor.WHITE, whiteKnight.getColor());
		assertEquals(PlayerColor.WHITE, whiteKnight2.getColor());
		assertEquals(PlayerColor.BLACK, blackKnight.getColor());
		assertTrue(whiteKing.getColor() == PlayerColor.WHITE);
		assertTrue(whiteKing.getColor() != PlayerColor.BLACK);
		assertTrue(blackKing.getColor() == PlayerColor.BLACK);
		assertTrue(whiteKnight.getColor()!= null);
		assertTrue(blackKnight.getColor()!= null);
	}
	
	@Test
	void testComparePieces() {
		
		assertEquals(whiteKing, whiteKing);
		assertNotEquals(whiteKing, blackKing);
		
		ChessPiece refToKnight = whiteKnight;
		assertEquals(refToKnight, whiteKnight);
		assertNotEquals(refToKnight, whiteKnight2);
		assertTrue(refToKnight.equals(whiteKnight));
		assertFalse(refToKnight.equals(whiteKnight2));
		
		assertNotEquals(whiteKnight, whiteKnight2);
		
		assertTrue(blackKing != whiteKing);
		assertFalse(blackKing == whiteKing);
	}
	
	@Test
	void testCompareClass() {
		assertEquals(King.class, whiteKing.getClass());
		assertEquals(Rook.class, rook.getClass());
		assertEquals(Pawn.class, pawn1.getClass());
		assertEquals(Pawn.class, pawn2.getClass());
		assertEquals(Pawn.class, pawn3.getClass());
		
		assertNotEquals(pawn2, pawn1);
		assertEquals(pawn2.getClass(), pawn1.getClass());
		assertEquals(pawn3.getClass(), pawn2.getClass());
		assertEquals(pawn3.getClass(), pawn3.getClass());
	}

	@Test
	void testGetMoveRule() {
		MoveRules kingMove = whiteKing.getMoveRule();
		
		
	}
}
