package com.java_lab_corp;

import static java.lang.System.out;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;
import java.util.stream.Stream;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

@Slf4j
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


		/* *** Check South Square Number with a Random North Square Number *** */
		MapMD map2MD = new MapMD(3, 4);
		log.debug("MapMiddleHeightLine: " + map2MD.getMapMiddleHeightLine());

		// Initialize last index value of mapMiddleHeightLine in lastIndex
		int lastIndex = map2MD.getLastMapMiddleHeightLineIndex();
		log.debug("lastIndex value of mapMiddleHeightLine: {}", lastIndex);

		// Total Squares from Square 0 (on the north) to the last Square of MiddleHeight Line
		int nbSquaresFromNorthToMiddleLine = map2MD.getNbSquaresFromNorthToMiddleLine();
		log.debug("maximum squares until MapMiddleHeightLine: " + nbSquaresFromNorthToMiddleLine);

		/* To evaluate a randomNorthSquare lastIndex & nbSquaresFromNorthToMiddleLine values should be > 0 */
		if(lastIndex > 0 && nbSquaresFromNorthToMiddleLine > 0) {

			Random rand = new Random();

			/* nextInt() returns random int between 0 (inclusive) and the specified value (exclusive, N-1).
			=> nextInt() returns random int between 0 and (nbSquaresFromNorthToMiddleLine-1)
			Square starts at 0 on map !!! */
			Square randomNorthSquare = map2MD.getMap().get(rand.nextInt(nbSquaresFromNorthToMiddleLine));
			log.debug("Random northSquare: {}", randomNorthSquare);

			Square bottomSouthSqr = map2MD.getMap().get(10);
			assertTrue(bottomSouthSqr.getSquareNumber() > randomNorthSquare.getSquareNumber());


			/* *** Check Random map bottom_line South Square Number with a Random North Square Number *** */
			int bottomLineSquareIndex = nbSquaresFromNorthToMiddleLine + rand.nextInt(map2MD.getTotalSquares() - nbSquaresFromNorthToMiddleLine);
			log.debug("bottomLineSquareIndex: {}", bottomLineSquareIndex);

			Square randomBottomSouthSqr = map2MD.getMap().get(bottomLineSquareIndex);
			log.debug("randomBottomSouthSqr: {}", randomBottomSouthSqr);

			assertTrue(randomBottomSouthSqr.getSquareNumber() > randomNorthSquare.getSquareNumber());
		}
	}

	@Test
	void testEastSquareNumberGreaterThanWestSquareNumberInSameHeight() throws Exception {
		MapMD mapMD = new MapMD(5, 3);
		Square mapLastSquare = mapMD.getMap().get(mapMD.getMap().size() - 1);
		log.debug("mapLastSquare's coordinates (Horizon, Vertical) : {}", mapLastSquare);

		mapMD.getMap().values()
				.stream().filter(square -> square.getHorizontalAxis() == 0)
				.forEach(sqrHorizon0 -> {
					log.debug("Test sqrHorizon0 width is lower than last Square number of map for: " + sqrHorizon0);

					assertTrue(sqrHorizon0.getSquareNumber() < mapLastSquare.getSquareNumber());
				});


		Random rand = new Random();
		log.debug("getWidthSquares: " + mapMD.getWidthSquares());

		/* *** Evaluate HorizontalAxis value between Random West Square & East Square *** */

		mapMD.getMap().values()
				.stream() //mapMD.getWidthSquares() will return the last square from East, to avoid it we set getWidthSquares() to -1
				.filter(square -> square.getHorizontalAxis() <= rand.nextInt(mapMD.getWidthSquares()-1))
				.forEach(westSqr -> {
					log.debug("Test Random West Square Width if it's less than last Square number of map for: " + westSqr);

					assertTrue(westSqr.getSquareNumber() < mapLastSquare.getSquareNumber());
				});
	}
}
