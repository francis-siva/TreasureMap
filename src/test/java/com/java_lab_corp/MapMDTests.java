package com.java_lab_corp;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MapMDTests {

	@Test
	void testNbSquaresValueEqualsToExpectedTotalSquares() {
		MapMD mapMD = new MapMD(3, 4);
		assertEquals(12, mapMD.getTotalSquares());
	}

	
}
