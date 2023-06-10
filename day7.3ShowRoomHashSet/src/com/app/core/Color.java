package com.app.core;

public enum Color{
//set of related constants
	RED(20000),BLACK(15000),SILVER(17000),WHITE(5000),BLUE(12000);
	private int additionalCost;
	private Color(int cost) {
		this.additionalCost=cost;
	}
	
	public int getAdditionalCost() {
		return additionalCost;
	}

	public void setAdditionalCost(int additionalCost) {
		this.additionalCost = additionalCost;
	}

	@Override
	public String toString()
	{
		return name().toLowerCase()+"@"+additionalCost;
	}
}
