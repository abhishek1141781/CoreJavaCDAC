package com.app.banking;

public enum AccountType {

	SAVING(2000),CURRENT(10000),FD(50000),NRE(1000),LOAN(100000),NRO(2500);
	private double minBalance;

	private AccountType(double minBalance) {
		this.minBalance = minBalance;
	}

	public double getMinBalance() {
		return minBalance;
	}

	public void setMinBalance(double minBalance) {
		this.minBalance = minBalance;
	}
	
	@Override
	public String toString()
	{
		return name().toLowerCase()+"@"+minBalance;
	}
}
