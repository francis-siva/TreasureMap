package com.java_lab_corp;

public class Square extends CoordinatesPoint {
	private final int squareNumber;

	public Square(int squareNumber, int horizontalAxis, int verticalAxis) {
		super();
		this.horizontalAxis = horizontalAxis;
		this.verticalAxis = verticalAxis;
		this.squareNumber = squareNumber;
	}

	public int getSquareNumber() {
		return squareNumber;
	}
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
