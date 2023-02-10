package com.java_lab_corp;

import static org.junit.jupiter.api.Assertions.*;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import com.java_lab_corp.exceptions.InvalidSquaresDimensionOfMap;

@Slf4j
class MapMDTests {

	@Test
	void testNbSquaresValueEqualsToExpectedTotalSquares() throws Exception {
		MapMD mapMD = new MapMD(3, 4);
		assertEquals(12, mapMD.getTotalSquares());
	}

	@Test
	void testWidthAndHeightSquaresNumberOfMapShouldBe0OrPositive() throws Exception {
		MapMD mapMD = new MapMD(3, 4);
		
		assertAll(new Executable() {
			@Override
			public void execute() throws Throwable {
				assertEquals(3, mapMD.getWidthSquares());				
			}
		}, () -> assertEquals(4, mapMD.getHeightSquares()));

		/* *** Specific Test case *** */
		log.debug("\n=>MapMD creation test with a WidthSquares to 0:<=");
		MapMD mapMDEmpty = new MapMD(0, 4);

		assertAll(() -> assertEquals(0, mapMDEmpty.getTotalSquares()),
				() -> assertEquals(0, mapMDEmpty.getWidthSquares()),
				() -> assertEquals(4, mapMDEmpty.getHeightSquares()));

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
