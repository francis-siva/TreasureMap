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
	
	private HashMap<Integer, String> map;
	
	public MapMD(int widthSquares, int heightSquares) throws Exception {
		
		this.map = new HashMap<Integer, String>();
		
		if(widthSquares < 0) {
			throw new InvalidSquaresDimensionOfMap("[Error]: Expected widthSquares greather or equal to 0.");
		}
		
		if(heightSquares < 0) {
			throw new InvalidSquaresDimensionOfMap("[Error]: Expected heightSquares greather or equal to 0.");
		}
		
		this.widthSquares = widthSquares;
		this.heightSquares = heightSquares;
		
		int nbSquares = this.widthSquares * this.heightSquares;
		int height = 1;
		
		for(int i = 0; i < nbSquares ; i++) {
			this.map.put(i, "{ Square n° " + i + " in height " + height + "}");
			
			System.out.print("{ Square n° " + i + " in height [" + height + "]}");
			
			if(this.map.size() % this.widthSquares == 0) {
				System.out.println();
				//System.out.println("\nsize(): " + this.map.size());
				++height;
			}
			
			
			//new Square(coordinatesPoint)
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
	
	public HashMap<Integer, String> getMap() {
		return map;
	}

	public void setMap(HashMap<Integer, String> map) {
		this.map = map;
	}

	public int getTotalSquares() {
		return this.getMap().size();
	}
	
}
