package com.app.core;

import java.time.LocalDate;
import java.util.Objects;

public class Vehicle implements Comparable<Vehicle>{
	private String chasisNo;
	private LocalDate manufacturingDate;
	private double basePrice;
	private String company;
	private boolean isAvailable;
	private Color vehicleColor;

	@Override
	public String toString() {
		return "Vehicle [chasisNo=" + chasisNo + ", manufacturingDate=" + manufacturingDate + ", basePrice=" + basePrice
				+ ", company=" + company + ", isAvailable=" + isAvailable + ", vehicleColor=" + vehicleColor + "]";
	}

	public Vehicle(String chasisNo, LocalDate manufacturingDate, double basePrice, String company, boolean isAvailable,
			Color vehicleColor) {
		super();
		this.chasisNo = chasisNo;
		this.manufacturingDate = manufacturingDate;
		this.basePrice = basePrice;
		this.company = company;
		this.isAvailable = true;
		this.vehicleColor = vehicleColor;
	}
	
//	single constructor based on chasisNo
	public Vehicle (String chasisNo) {
		this.chasisNo=chasisNo;
	}

	public double getBasePrice() {
		return basePrice;
	}

	public void setBasePrice(double basePrice) {
		this.basePrice = basePrice;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getChasisNo() {
		return chasisNo;
	}

	public LocalDate getManufacturingDate() {
		return manufacturingDate;
	}

	public Color getVehicleColor() {
		return vehicleColor;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

//	@Override
//	public int hashCode() {
//		return Objects.hash(chasisNo);
//	}

//	Using equals of object class and thus we need to downcast it to Vehicle class
	@Override
	public boolean equals(Object obj) {
		System.out.println("in vehicle's equals");
		if(obj instanceof Vehicle)
			return this.chasisNo.equals(((Vehicle)obj).chasisNo);
		return false;
	}

//	The method compareTo(Vehicle) of type Vehicle must override or implement a supertype method
//	@Override
	public int compareTo(Vehicle anotherVehicle) {
		System.out.println("in compareTo: vehicle");
		return this.chasisNo.compareTo(anotherVehicle.chasisNo);
	}
}
