package com.java_lab_corp;

import java.util.HashMap;

import com.java_lab_corp.exceptions.InvalidSquaresDimensionOfMap;

/**
 * Map of Madre de Dios
 * @author francis
 *
 */
public class MapMD {
	
	private int widthSquares;
	
	private int heightSquares;
	
	private HashMap<Integer, Square> map;
	
	public MapMD(int widthSquares, int heightSquares) throws Exception {
		
		this.map = new HashMap<Integer, Square>();
		
		if(widthSquares < 0) {
			throw new InvalidSquaresDimensionOfMap("[Error]: Expected widthSquares greather or equal to 0.");
		}
		
		if(heightSquares < 0) {
			throw new InvalidSquaresDimensionOfMap("[Error]: Expected heightSquares greather or equal to 0.");
		}
		
		this.widthSquares = widthSquares;
		this.heightSquares = heightSquares;
		
		int nbSquares = this.widthSquares * this.heightSquares;
		int width = 0, height = 0;
		
		for(int i = 0; i < nbSquares ; i++) {
			this.map.put(i, new Square(i, width, height));

			System.out.print("{ Square n° " + this.map.get(i).getSquareNumber() + " with width " + this.map.get(i).getHorizontalAxis() + " & height [" + this.map.get(i).getVerticalAxis() + "]}");
			width++;
			
			if(this.map.size() % this.widthSquares == 0) {
				System.out.println();
				//System.out.println("\nsize(): " + this.map.size());
				width=0;
				++height;
			}

		}

	}

	public int getWidthSquares() {
		return widthSquares;
	}

	public void setWidthSquares(int widthSquares) {
		this.widthSquares = widthSquares;
	}

	public int getHeightSquares() {
		return heightSquares;
	}

	public void setHeightSquares(int heightSquares) {
		this.heightSquares = heightSquares;
	}
	
	public HashMap<Integer, Square> getMap() {
		return map;
	}

	public void setMap(HashMap<Integer, Square> map) {
		this.map = map;
	}

	public int getTotalSquares() {
		return this.getMap().size();
	}
	
}
