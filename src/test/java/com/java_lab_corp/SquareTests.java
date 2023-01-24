package com.java_lab_corp;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.stream.Stream;

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
	void testEstSquareNumberGreaterThanWestSquareNumberInSameHeight() throws Exception {

		MapMD mapMD = new MapMD(3, 4);
		int middleHeightLineSqr;
		//Even MapMD HeightSquares management
		if(mapMD.getHeightSquares() % 2 == 0) {System.out.println();
			System.out.println("Even HeightSquares management");
			
			middleHeightLineSqr = mapMD.getHeightSquares() / 2;
			System.out.println("middleHeightLineSquares: " + middleHeightLineSqr);
			
			System.out.println("\n\n");/**/
			System.out.println(mapMD.getMap().values().stream()
					.filter(sqr -> sqr.getVerticalAxis() >= 2).findFirst().get().toString());
			//
			System.out.println("Last Square of mapMD : " + mapMD.getMap().get(mapMD.getMap().size()-1));
			
			//northSqr definition
			HashMap<Integer, Square> northSqr = new HashMap<Integer, Square>();
			
			mapMD.getMap().values().stream()
			.filter(sqr -> sqr.getVerticalAxis() < 2)
			.forEach(sqr -> northSqr.put(sqr.getSquareNumber(), sqr));
			
			System.out.println("evenSqr >>>>>");
			System.out.println("TEST >>>>>");
			int firdtOf_northSqr = northSqr.values().stream().findFirst().get().getSquareNumber();
			for(int i = firdtOf_northSqr; i < northSqr.size(); i++) {
				System.out.println("northSqr: " + northSqr.get(i).toString());
			}
			
			//southSqr definition
			HashMap<Integer, Square> southSqr = new HashMap<Integer, Square>();
			mapMD.getMap().values().stream()
			.filter(sqr -> sqr.getVerticalAxis() >= 2)
			.forEach(sqr -> southSqr.put(sqr.getSquareNumber(), sqr));//.count());
			System.out.println("\nsouthSqr: " + southSqr.size());
			int firstOf_southSqr = southSqr.values().stream().findFirst().get().getSquareNumber();
			System.out.println("firstOf_southSqr " + southSqr.size());

			
			/**/
			
			/*
			for(int i = 0; i < mapMD.getMap().size(); i++) {
				
				if(mapMD.getMap().get(i).getVerticalAxis() < middleHeightLineSqr)
					System.out.println(mapMD.getMap().get(i).toString());
			}*/System.out.println("END !!!!!!!!!!!");
		}
		
		fail("Not yet implemented");//TODO:Find middle line in map to separate north & south
	}
}
