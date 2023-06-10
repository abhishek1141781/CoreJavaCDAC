package com.app.shop;

import java.time.LocalDate;

import com.app.enumsize.Size;

public class Cloth {
	private static int cID=100;
	private LocalDate listingDate;
	private LocalDate stockUpdateDate;
	private int stockQuantity;
	private Size size;
	private double price;
	public Size getSize() {
		return size;
	}
	public void setSize(Size size) {
		this.size = size;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public static int getcID() {
		return cID;
	}
	public LocalDate getListingDate() {
		return listingDate;
	}
	public LocalDate getStockUpdateDate() {
		return stockUpdateDate;
	}
	public int getStockQuantity() {
		return stockQuantity;
	}
	@Override
	public String toString() {
		return "Cloth [listingDate=" + listingDate + ", stockUpdateDate=" + stockUpdateDate + ", stockQuantity="
				+ stockQuantity + ", price=" + price + "]";
	}
	public Cloth(LocalDate listingDate, LocalDate stockUpdateDate, int stockQuantity, Size size, double price) {
		super();
		this.listingDate = listingDate;
		this.stockUpdateDate = stockUpdateDate;
		this.stockQuantity = stockQuantity;
		this.size = size;
		this.price = price;
	}
	
	
	
	
}
