package model.chess.rules;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import controller.utilities.ChessSquareInterpreter;
import controller.utilities.IncorrectStringFormatException;

class ChessSquareInterpreterTest {

	private ChessSquareInterpreter cInterpreter;
	
	@Test
	void testGetInstance() {
		cInterpreter = ChessSquareInterpreter.getInstance();
		assertEquals(ChessSquareInterpreter.class, cInterpreter.getClass()); 
	}
	
	@Test
	void testGetAnotherInstance() {
		ChessSquareInterpreter cInterpreter1 = ChessSquareInterpreter.getInstance();
		ChessSquareInterpreter cInterpreter2 = ChessSquareInterpreter.getInstance();
		ChessSquareInterpreter cInterpreter3 = null;
		
		assertNotEquals(null, cInterpreter1); 
		assertEquals(cInterpreter1, cInterpreter2); 
		assertNotEquals(cInterpreter3, cInterpreter2);
	}

	@BeforeEach
	void setUp() {
		cInterpreter = ChessSquareInterpreter.getInstance();
	}
	
	@Test
	void testConvertSimpleLetter() throws IncorrectStringFormatException {
		assertEquals(0, cInterpreter.convert("A1"));
	}
	
	@Test
	void testThrowsIncorrectStringFormatException() {    
	    assertThrows(IncorrectStringFormatException.class,
	            ()->{
	            	cInterpreter.convert("A12");
	            });
	    assertThrows(IncorrectStringFormatException.class,
	            ()->{
	            	cInterpreter.convert("A");
	            });
	    /*
	     * Learned new way to test throws from: 
	     * https://stackoverflow.com/questions/40268446/junit-5-how-to-assert-an-exception-is-thrown
	     */
	}
	
	@Test
	void testConvertARow() throws IncorrectStringFormatException {
		assertEquals(0, cInterpreter.convert("A1"));
		assertEquals(1, cInterpreter.convert("B1"));
		assertEquals(2, cInterpreter.convert("C1"));
		assertEquals(3, cInterpreter.convert("D1"));
		assertEquals(4, cInterpreter.convert("E1"));
		assertEquals(5, cInterpreter.convert("F1"));
		assertEquals(6, cInterpreter.convert("G1"));
		assertEquals(7, cInterpreter.convert("H1"));
	}
	
	@Test
	void testConvertColumns() throws IncorrectStringFormatException {
		assertEquals(0, cInterpreter.convert("A1"));
		assertEquals(8, cInterpreter.convert("A2"));
		assertEquals(16, cInterpreter.convert("A3"));
		assertEquals(24, cInterpreter.convert("A4"));
		assertEquals(32, cInterpreter.convert("A5"));
		assertEquals(40, cInterpreter.convert("A6"));
		assertEquals(48, cInterpreter.convert("A7"));
		assertEquals(56, cInterpreter.convert("A8"));
	}
	
	@Test
	void testConvertRowsAndCols() throws IncorrectStringFormatException {
		assertEquals(0, cInterpreter.convert("A1"));
		assertEquals(16, cInterpreter.convert("A3"));
		assertEquals(56, cInterpreter.convert("A8"));
		assertEquals(9, cInterpreter.convert("B2"));
		assertEquals(34, cInterpreter.convert("C5"));
		assertEquals(4, cInterpreter.convert("E1"));
		assertEquals(46, cInterpreter.convert("G6"));
	}
	
}
