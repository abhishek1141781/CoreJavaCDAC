// HashMap

// equals not needed
// hashcode used internally
// single constructor not needed
// CompareTo not needed



package com.app.core;

import java.time.LocalDate;

/*
 * Objective : Accept vehicle details : chasisNo(string) : Unique ID, 
 * color(enum) , basePrice(double) , manufactureDate(LocalDate),
 * company,isAvailable

 */
public class Vehicle implements Comparable<Vehicle> {
	public String getChasisNo() {
		return chasisNo;
	}

	public void setChasisNo(String chasisNo) {
		this.chasisNo = chasisNo;
	}
	private String chasisNo;
	// HAS-A : association , Vehicle HAS-A Color
	private Color vehicleColor;
	private double basePrice;
	private LocalDate manufactureDate;
	private String company;
	private boolean isAvailable;

	public Vehicle(String chasisNo, Color vehicleColor, double basePrice, LocalDate manufactureDate, String company) {
		super();
		this.chasisNo = chasisNo;
		this.vehicleColor = vehicleColor;
		this.basePrice = basePrice;
		this.manufactureDate = manufactureDate;
		this.company = company;
		this.isAvailable = true;
	}
	//add overloaded ctor : based upon Unique ID(PK)
//	public Vehicle(String chasisNo) {
//		super();
//		this.chasisNo = chasisNo;
//	}

	@Override
	public String toString() {
		return "Vehicle [chasisNo=" + chasisNo + ", vehicleColor=" + vehicleColor + ", basePrice=" + basePrice
				+ ", manufactureDate=" + manufactureDate + ", company=" + company + ", isAvailable=" + isAvailable
				+ "]";
	}

	


//	@Override
//	public boolean equals(Object o) {
//		System.out.println("in vehicle 's equals");
//		if (o instanceof Vehicle)
//			return this.chasisNo.equals(((Vehicle) o).chasisNo);
//		return false;
//	}
	
	//implement : compareTo
	
	
	public int compareTo(Vehicle anotherVehicle)
	{
		System.out.println("in compareTo : vehicle");
		return this.chasisNo.compareTo(anotherVehicle.chasisNo);
	}
	
	
	//getter for date
	public LocalDate getManufactureDate() {
		return manufactureDate;
	}
	//getter n setter for price
	public double getBasePrice() {
		return basePrice;
	}
	public void setBasePrice(double basePrice) {
		this.basePrice = basePrice;
	}

//	@Override
//	public int compareTo(Vehicle o) {
//		// TODO Auto-generated method stub
//		return 0;
//	}
	

}
