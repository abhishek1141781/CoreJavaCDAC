package com.app.core;

public enum Color {
	RED(10000),BLUE(20000),GREEN(30000),WHITE(40000);
	
//	declaring a compulsorily private variable so as to store values for additional cost
	private int additionalCost;
	
//	creating constructor for Color(int) for the enum's own personal understanding that we've given a 
//	Illegal modifier for the enum constructor; only private is permitted.
	private Color(int additionalCost) {
		this.additionalCost=additionalCost;
	}
	
//	creating getter for additonal cost associated with a color of type enum
//	The error java.lang.StackOverflowError is caused by an infinite recursion in the getAdditionalCost method of the Color class. The getAdditionalCost method is calling itself indefinitely, leading to a stack overflow error.
//	To fix this, you should modify the getAdditionalCost method to return the additional cost of the color, instead of calling itself recursively.
//	return this.getAdditionalCost();		// this is not needed
	
	public int getAdditionalCost() {
		return additionalCost;
	}
	

	public void setAdditionalCost(int additionalCost) {
		this.additionalCost=additionalCost;
	}
	
	public String toString() {
		return name().toLowerCase()+"@"+additionalCost;
	}
}
