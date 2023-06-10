package com.app.banking;

import java.time.LocalDate;

public class BankAccount implements Comparable<BankAccount>{
	private Integer accountNumber;
	private String customerName;
	private AccountType accountType;
	public AccountType getAccountType() {
		return accountType;
	}

	private double accountBalance;
	private LocalDate accountOpeningDate;

	@Override
	public String toString() {
		return "BankAccount [accountNumber=" + accountNumber + ", customerName=" + customerName + ", accountType="
				+ accountType + ", accountBalance=" + accountBalance + ", accountOpeningDate=" + accountOpeningDate
				+ "]";
	}

	public BankAccount(int accountNumber, String customerName, AccountType accountType, double accountBalance,
		LocalDate accountOpeningDate) {
	super();
	this.accountNumber = accountNumber;
	this.customerName = customerName;
	this.accountType = accountType;
	this.accountBalance = accountBalance;
	this.accountOpeningDate = accountOpeningDate;
}
	
//	PK for accountNumber for duplicate bank account check
//	public BankAccount() {
//		
//	}

	//add overloaded ctor: based upon Unique AccountNumber(PK)
	public BankAccount(int accountNumber) {
		super();
		this.accountNumber = accountNumber;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	

	public double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}

	public LocalDate getAccountOpeningDate() {
		return accountOpeningDate;
	}

	public void setAccountOpeningDate(LocalDate accountOpeningDate) {
		this.accountOpeningDate = accountOpeningDate;
	}

	public void withdraw(double amount) {
	if((this.accountBalance-amount) >= (this.accountType.getMinBalance()))
			{
		this.accountBalance=this.accountBalance-amount;
		System.out.println("Amount "+amount+"withdrawn successfully, current balance is "+this.accountBalance);
			}
	
		
	}

	public void deposit(double amount) {
		this.accountBalance = this.accountBalance + amount;
		System.out.println("Amount "+  amount + " deposit successfully, current balance is " + this.accountBalance);
		
		//return accountBalance=accountBalance+amount ;
	}

	public void fundTransfer(BankAccount anotherAccount, double amount) {
		this.withdraw(amount);
		anotherAccount.deposit(amount);
		System.out.println(amount+"transferred successfully");
		
//		this.accountBalance = accountBalance - amount;
//		anotherAccount.accountBalance = anotherAccount.accountBalance + amount;
	}

	@Override
	public int compareTo(BankAccount o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
//	@Override
//	public int compareTo(BankAccount anotherBankAccount)
//	{
//		System.out.println("in compareTo : Bank Account");
//		return this.accountNumber.compareTo(anotherBankAccount.accountNumber);
//	}
//	
	public boolean equals(Object o) {
//		System.out.println("in bankAccount equals");
		if(o instanceof BankAccount)
			return this.accountNumber.equals(((BankAccount)o).accountNumber);
		return false;
	
	}
//	public boolean contains(Object o) {
//		System.out.println("in bankAccount equals");
//		if(o instanceof BankAccount)
//			return this.accountNumber.equals(((BankAccount)o).accountNumber);
//		return false;
//	
//	}
	
}