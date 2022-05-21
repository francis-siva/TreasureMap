package com.java_lab_corp;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import com.java_lab_corp.exceptions.InvalidSquaresDimensionOfMap;

class MapMDTests {

	@Test
	void testNbSquaresValueEqualsToExpectedTotalSquares() throws Exception {
		MapMD mapMD = new MapMD(3, 4);
		assertEquals(12, mapMD.getTotalSquares());
	}

	@Test
	void testWidthAndHeightSquaresNumberOfMapShouldBe0OrPositive() throws Exception {
		MapMD mapMD = new MapMD(3, 4);

		assertEquals(3, mapMD.getWidthSquares());
		assertEquals(4, mapMD.getHeightSquares());
		
		assertAll(new Executable() {			
			@Override
			public void execute() throws Throwable {
				assertEquals(3, mapMD.getWidthSquares());				
			}
		}, () -> assertEquals(3, mapMD.getWidthSquares()));
			
		
		/* *** Exception Expected *** */
		assertThrows(InvalidSquaresDimensionOfMap.class, new Executable() {			
			@Override
			public void execute() throws Throwable {
				MapMD mapMD2 = new MapMD(-3, 4);				
			}
		}, "[Error]: Expected widthSquares greather or equal to 0.");
		
		Exception exception = assertThrows(InvalidSquaresDimensionOfMap.class, new Executable() {			
			@Override
			public void execute() throws Throwable {
				MapMD mapMD3 = new MapMD(3, -4);				
			}
		});
		
		assertEquals("[Error]: Expected heightSquares greather or equal to 0.", exception.getMessage());
	}
}
