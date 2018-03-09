package model.chess.rules;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import controller.utilities.ChessSquareInterpreter;

class ChessSquareInterpreterTest {

	@Test
	void testGetInstance() {
		ChessSquareInterpreter cInterpreter;
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

}
