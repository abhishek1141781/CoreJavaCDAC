package com.app.enums;

public enum AccountType {
	SAVINGS(10000),CURRENT(50000), FD(100000),NRE(60000),NRO(80000),LOAN(150000);
	private int minimumBalance;
	
	private AccountType(int minimumBalance) {
		this.minimumBalance = minimumBalance;
	}
	@Override
	public String toString() {
		return this.name() + "and" + minimumBalance;
	}
	public void setMinimumBalance(int minimumBalance) {
		this.minimumBalance = minimumBalance;
	}	
	public int getMinimumBalance() {
		return minimumBalance;
	}
	public String getName() {
		return this.name();
	}
}
