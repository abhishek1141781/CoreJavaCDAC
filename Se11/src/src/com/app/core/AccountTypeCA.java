package com.app.core;

public enum AccountTypeCA {
	FD(20000),CURRENT(50000),SAVINGS(10000);
	private int minimiumAccountBal;
	
//	AccountTypeCA(int i) {
//		// TODO Auto-generated constructor stub
//	}

	private AccountTypeCA(int minAccountBal){
		this.minimiumAccountBal=minAccountBal;
	}
	
	@Override
	public String toString() {
		return name()+"@"+minimiumAccountBal;
	}

	public int getMinimiumAccountBal() {
		return minimiumAccountBal;
	}
	
}
