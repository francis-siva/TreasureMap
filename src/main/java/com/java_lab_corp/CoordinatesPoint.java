package com.java_lab_corp;

public abstract class CoordinatesPoint {
	protected int horizontalAxis = 0;
	
	protected int verticalAxis = 0;

	public int getHorizontalAxis() {
		return this.horizontalAxis;
	}

	public int getVerticalAxis() {
		return this.verticalAxis;
	}
	
	public String getCoordinates() {
		return "(" + this.getHorizontalAxis() + ", " + this.getVerticalAxis() + ")";
	}
}
