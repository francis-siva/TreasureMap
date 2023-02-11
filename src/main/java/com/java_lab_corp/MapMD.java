package com.java_lab_corp;

import java.util.HashMap;
import java.util.HashSet;

import com.java_lab_corp.exceptions.InvalidSquaresDimensionOfMap;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * Map of Madre de Dios
 * @author francis
 *
 */
@Slf4j
public class MapMD {

	@Getter
	private int widthSquares;

	@Getter
	private int heightSquares;

	@Getter @Setter
	private HashMap<Integer, Square> map;
	
	public MapMD(int widthSquares, int heightSquares) throws Exception {
		
		this.map = new HashMap<>();
		
		checkMapWidthSquares(widthSquares);
		checkMapHeightSquares(heightSquares);

		log.info("Madre De Dios Map Initialization:");
		this.widthSquares = widthSquares;
		this.heightSquares = heightSquares;

		// nbSquares to create in Map
		int nbSquares = this.widthSquares * this.heightSquares;

		// Create Square(s) to put on map only if nbSquares > 0
		if(nbSquares > 0) {
			int width = 0, height = 0;

			for (int i = 0; i < nbSquares; i++) {
				this.map.put(i, new Square(i, width, height));

				log.debug("{ Square n° " + this.map.get(i).getSquareNumber() + " with width " + this.map.get(i).getHorizontalAxis() + " & height [" + this.map.get(i).getVerticalAxis() + "]}");
				width++;

				if (this.map.size() % this.widthSquares == 0) {
					log.debug("last Square n°{} at line {}. => [_Line_Break_]", this.map.get(i).getSquareNumber(), (height + 1));
					log.debug("map_size: {}\n", this.map.size());

					width = 0;
					++height;
				}

			}
		}

		if (this.getTotalSquares() > 0) {
			log.debug("Total Squares created on map: {}", this.getTotalSquares());
		}
		else { log.debug("No any Square built on map"); }
	}

	public void setWidthSquares(int widthSquares) {
		checkMapWidthSquares(widthSquares);
		this.widthSquares = widthSquares;
	}

	public void setHeightSquares(int heightSquares) {
		checkMapHeightSquares(heightSquares);
		this.heightSquares = heightSquares;
	}

	private void checkMapWidthSquares(int widthSquares) {
		log.debug("Checking Map Width of squares value: {}", widthSquares);

		if (widthSquares < 0) {
			log.error("Map Width of squares is under 0.");
			throw new InvalidSquaresDimensionOfMap("[Error]: Expected widthSquares greather or equal to 0.");
		}
	}

	private void checkMapHeightSquares(int heightSquares) {
		log.debug("Checking Map Height of squares value: {}", heightSquares);

		if (heightSquares < 0) {
			log.error("Map Height of squares is under 0.");
			throw new InvalidSquaresDimensionOfMap("[Error]: Expected heightSquares greather or equal to 0.");
		}
	}

	/**
	 * Identify heights' middleline(s) of created Map with Squares based on {@code heightSquares} property
	 * @return the middle height(s) line(s)
	 */
	public HashSet<Integer> getMapMiddleHeightLine() {
		HashSet<Integer> mapMiddleHeightLine = new HashSet<>();

		if(this.getHeightSquares() > 0) {
			//Even MapMD HeightSquares management
			if (this.getHeightSquares() % 2 == 0) {
				log.debug("Even HeightSquares management");

				mapMiddleHeightLine.add((this.getHeightSquares() / 2));
				mapMiddleHeightLine.add((this.getHeightSquares() / 2 + 1));
				log.debug("Middle HeightLines of Map: {}", mapMiddleHeightLine);
			}

			//Odd MapMD HeightSquares management
			if (this.getHeightSquares() % 2 != 0) {
				log.debug("Odd HeightSquares management");

				mapMiddleHeightLine.add((this.getHeightSquares() / 2 + 1));
				log.debug("Middle HeightLine of Map: {}", mapMiddleHeightLine);
			}
		}

		return mapMiddleHeightLine;
	}

	public int getTotalSquares() {
		return this.getMap().size();
	}
	
}
