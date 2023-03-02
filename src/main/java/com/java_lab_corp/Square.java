package com.java_lab_corp;

import com.java_lab_corp.components.Mountain;
import com.java_lab_corp.components.Treasure;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;

@Slf4j
public class Square extends CoordinatesPoint {
	@Getter
	private final int squareNumber;

	@Getter
	private ArrayList<Object> listComponents;

	public Square(int squareNumber, int horizontalAxis, int verticalAxis) {
		super();
		this.horizontalAxis = horizontalAxis;
		this.verticalAxis = verticalAxis;
		this.squareNumber = squareNumber;
	}

	public void addComponent(Object obj) {
		//If listComponents 1st element is a Mountain, so we don't build more Component
		if(this.listComponents.size() > 0 && this.listComponents.get(0) instanceof Mountain) {
			log.error("A Mountain is here !!! Unable to place another Component at this Square {}", this);
			//todo: impl & throw custom exception
		}
		else {
			if(obj instanceof Mountain) {
				Mountain mountain = (Mountain) obj;
				this.listComponents.add(mountain);
			}
			if(obj instanceof Treasure) {

			}
//		if(obj instanceof Adventurer)
		}
	}
	/*public int getSquareNumber() {
		return squareNumber;
	}*/
//	
//	public void setHorizontalAxis(int horizontalAxis) {
//		this.horizontalAxis = horizontalAxis;
//	}
//	
//	public void setVerticalAxis(int verticalAxis) {
//		this.verticalAxis = verticalAxis;
//	}

	@Override
	public String toString() {
		return "Square [squareNumber=" + squareNumber + ", horizontalAxis=" + horizontalAxis + ", verticalAxis="
				+ verticalAxis + "]";
	}
}
