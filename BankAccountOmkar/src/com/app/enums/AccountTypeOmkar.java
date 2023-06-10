package com.app.enums;

public enum AccountTypeOmkar {
SAVING(10000),CURRENT(5000),FD(4000),NRE(5000),LOAN(70000),NRO(12000);
	public int minimunAmount;
	private AccountTypeOmkar(int minimumAmount)
	{
		this.minimunAmount=minimumAmount;
	}
	public String toString()
	{
		return this.name()+"and "+minimunAmount; 
	}
	public int getMinimunAmount() {
		return minimunAmount;
	}
	public void setMinimunAmount(int minimunAmount) {
		this.minimunAmount = minimunAmount;
	}

}
