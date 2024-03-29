package com.java_lab_corp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Optional;

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
					// Squares number stored in map
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
	public ArrayList<Integer> getMapMiddleHeightLine() {
		ArrayList<Integer> mapMiddleHeightLine = new ArrayList<>();

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

	/**
	 * Get last index value of mapMiddleHeightLine
	 * @return last index value
	 */
	public int getLastMapMiddleHeightLineIndex() {
		// To evaluate MapMiddleHeightLine mapMD should be > 0
		if (checkMapMiddleHeightLineSizeGreaterThan0()) {
			return this.getMapMiddleHeightLine().get(this.getMapMiddleHeightLine().size() - 1);
		}
		return 0;
	}

	/**
	 * Total Squares from Square 0 (on the north) to the last Square of MiddleHeight Line
	 * @return number of squares until  the last square of MapMiddleHeightLine
	 */
	public int getNbSquaresFromNorthToMiddleLine(){
		if (checkMapMiddleHeightLineSizeGreaterThan0()) {
			return this.getWidthSquares() * this.getLastMapMiddleHeightLineIndex();
		}
		return 0;
	}

	/**
	 * Utility method to check if MapMiddleHeightLine's size is > 0.
	 * It's required to evaluate lastIndex value of MapMiddleHeightLine
	 * @return true if verified else false
	 */
	public boolean checkMapMiddleHeightLineSizeGreaterThan0 () {
		return (this.getMapMiddleHeightLine().size() > 0);
	}

	public int getTotalSquares() {
		return this.getMap().size();
	}

	/**
	 * Search if a given {@code Square} is present in defined {@code MapMD}
	 * @param inputSquare {@code Square}
	 * @return square to reach if found in an {@code Optional<Square>}
	 */
	public Optional<Square> searchSquare(Square inputSquare) {

		// inputSquare argument store in optionalSquare to handle null value
		Optional<Square> optionalSquare = Optional.ofNullable(inputSquare);
		log.debug("Value of Optional optionalSquare : {}", optionalSquare);

		/* If the following statement is true (so inputSquare is a non-null value),
		then we can search if there is a matching Square on map with inputSquare */
		if(optionalSquare.isPresent()) {
			return map.values().stream()
				.filter(square -> square.getHorizontalAxis() == inputSquare.getHorizontalAxis() && square.getVerticalAxis() == inputSquare.getVerticalAxis())
				.findFirst();
		}

		return optionalSquare;
	}
}
