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
	void testConvertSimplePosition() throws IncorrectStringFormatException {
		assertEquals(0, cInterpreter.interpretToInt("A1"));
	}
	
	
		/*
	     * Learned new way to test throws from: 
	     * https://stackoverflow.com/questions/40268446/junit-5-how-to-assert-an-exception-is-thrown
	     */
	@Test
	void testThrowsIncorrectStringFormatException() {    
	    assertThrows(IncorrectStringFormatException.class,
	            ()->{
	            	cInterpreter.interpretToInt("A12");
	            });
	    assertThrows(IncorrectStringFormatException.class,
	            ()->{
	            	cInterpreter.interpretToInt("A");
	            });
	    assertThrows(IncorrectStringFormatException.class,
	            ()->{
	            	cInterpreter.interpretToInt("eA");
	            });
	    assertThrows(IncorrectStringFormatException.class,
	            ()->{
	            	cInterpreter.interpretToInt("B9");
	            });
	    assertThrows(IncorrectStringFormatException.class,
	            ()->{
	            	cInterpreter.interpretToInt("E10");
	            });
	    assertThrows(IncorrectStringFormatException.class,
	            ()->{
	            	cInterpreter.interpretToInt("10");
	            });

	}
	
	@Test
	void testConvertARow() throws IncorrectStringFormatException {
		assertEquals(0, cInterpreter.interpretToInt("A1"));
		assertEquals(1, cInterpreter.interpretToInt("B1"));
		assertEquals(2, cInterpreter.interpretToInt("C1"));
		assertEquals(3, cInterpreter.interpretToInt("D1"));
		assertEquals(4, cInterpreter.interpretToInt("E1"));
		assertEquals(5, cInterpreter.interpretToInt("F1"));
		assertEquals(6, cInterpreter.interpretToInt("G1"));
		assertEquals(7, cInterpreter.interpretToInt("H1"));
	}
	
	@Test
	void testConvertColumns() throws IncorrectStringFormatException {
		assertEquals(0, cInterpreter.interpretToInt("A1"));
		assertEquals(8, cInterpreter.interpretToInt("A2"));
		assertEquals(16, cInterpreter.interpretToInt("A3"));
		assertEquals(24, cInterpreter.interpretToInt("A4"));
		assertEquals(32, cInterpreter.interpretToInt("A5"));
		assertEquals(40, cInterpreter.interpretToInt("A6"));
		assertEquals(48, cInterpreter.interpretToInt("A7"));
		assertEquals(56, cInterpreter.interpretToInt("A8"));
	}
	
	@Test
	void testConvertRowsAndCols() throws IncorrectStringFormatException {
		assertEquals(0, cInterpreter.interpretToInt("A1"));
		assertEquals(16, cInterpreter.interpretToInt("A3"));
		assertEquals(56, cInterpreter.interpretToInt("A8"));
		assertEquals(9, cInterpreter.interpretToInt("B2"));
		assertEquals(34, cInterpreter.interpretToInt("C5"));
		assertEquals(4, cInterpreter.interpretToInt("E1"));
		assertEquals(46, cInterpreter.interpretToInt("G6"));
	}
	
}
