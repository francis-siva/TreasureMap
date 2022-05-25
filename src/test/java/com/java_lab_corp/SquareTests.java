package com.java_lab_corp;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class SquareTests {

	@Test
	void testSouthSquareNumberIsBiggerThanNorthSquareNumber() throws Exception {
		MapMD mapMD = new MapMD(3, 4);		
		Square northSqr = mapMD.getMap().get(2);
		Square southSqr = mapMD.getMap().get(6);

		assertAll("SouthSquareN° > NorthSquareN°",
				() -> assertEquals("(2, 0)", northSqr.getCoordinates()),
				() -> assertEquals("(0, 2)", southSqr.getCoordinates()),
				() -> assertTrue(southSqr.getSquareNumber() > northSqr.getSquareNumber()));
	}

	@Test
	@Disabled("Treat this test case once previous one will be done")
	void testEstSquareNumberGreaterThanWestSquareNumberInSameHeight() {
		fail("Not yet implemented");
	}
}
