package com.app.core;

import java.time.LocalDate;
import java.util.List;

import custom_exception.InvalidInputException;
import utils.ValidationRules;

public class BankAccountCA implements Comparable<BankAccountCA>{
	private int accountNumber;
	private double accountBalance;
	private AccountTypeCA accountType;
	private LocalDate accountOpeningDate;
	private String customerName;
	

	
	
	public BankAccountCA(int accountNumber, double accountBalance, AccountTypeCA accountType,
			LocalDate accountOpeningDate, String customerName) {
		super();
		this.accountNumber = accountNumber;
		this.accountBalance = accountBalance;
		this.accountType = accountType;
		this.accountOpeningDate = accountOpeningDate;
		this.customerName = customerName;
	}
	
	public BankAccountCA(int accountNumber) {
		this.accountNumber=accountNumber;
	}
	
	public double getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}
	public int getAccountNumber() {
		return accountNumber;
	}
	public AccountTypeCA getAccountType() {
		return accountType;
	}
	public LocalDate getAccountOpeningDate() {
		return accountOpeningDate;
	}
	public String getCustomerName() {
		return customerName;
	}
	@Override
	public String toString() {
		return "BankAccountCA [accountNumber=" + accountNumber + ", accountBalance=" + accountBalance + ", accountType="
				+ accountType + ", accountOpeningDate=" + accountOpeningDate + ", customerName=" + customerName + "]";
	}
//	@Override
//	public int hashCode() {
//		return Objects.hash(accountNumber);
//	}
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		BankAccountCA other = (BankAccountCA) obj;
//		return accountNumber == other.accountNumber;
//	}
	
	@Override
	public boolean equals(Object o) {
		System.out.println("custom equals");
		if(o instanceof BankAccountCA)
			return this.accountNumber == ((BankAccountCA)o).accountNumber;
		return false;
	}
	
	
	
//	deposit logic
	public void deposit(List<BankAccountCA> list, double depositAmount) {
		
		BankAccountCA depositRef = ValidationRules.objectGetter(list, this);
		
		System.out.println("Current Account Balance: "+depositRef.accountBalance+"\n");
		depositRef.setAccountBalance(depositRef.getAccountBalance()+depositAmount);
		System.out.println("Account name: "+depositRef.customerName+"\nAccount Number: "+depositRef.accountNumber+"\nUpdated Account Balance: "+depositRef.accountBalance);
	}
	
	
	
//	withdraw logic
	public void withdraw(List<BankAccountCA> list, double withdrawAmount) throws InvalidInputException{
		
		BankAccountCA withdrawRef = ValidationRules.objectGetter(list, this);
		
		System.out.println("Current Account Balance: "+withdrawRef.accountBalance+"\n");
		if((withdrawRef.accountBalance-withdrawAmount) < (withdrawRef.getAccountType().getMinimiumAccountBal())) {
			throw new InvalidInputException("Can't withdraw, minimum balance exceeded");
		}
		else
//			this.accountBalance = this.accountBalance-withdrawAmount;
			withdrawRef.setAccountBalance(withdrawRef.accountBalance-withdrawAmount);
		System.out.println("Updated Account Balance: "+withdrawRef.accountBalance+"\n");
	}

//	fundtransfer
	public void fundTransfer(List<BankAccountCA> list, BankAccountCA fromAccountNumber,BankAccountCA toAccountNumber,double fundtransferAmount) throws InvalidInputException{

//		BankAccountCA readyListBankAccountFromWith = ValidationRules.objectGetter(list, this);
		BankAccountCA readyListBankAccountFromWith = ValidationRules.objectGetter(list, fromAccountNumber);
		BankAccountCA readyListBankAccountToDep =  ValidationRules.objectGetter(list, toAccountNumber);
		
		System.out.println("Current Balance of Sender Account: "+readyListBankAccountFromWith.accountBalance+"\nCurrent Balance of Reciever Account: "+readyListBankAccountToDep.accountBalance);

//		int indexWith=list.indexOf(this);
//		BankAccountCA readyListBankAccountWith = list.get(indexWith);
		readyListBankAccountFromWith.withdraw(list,fundtransferAmount);
		
//		int indexDep=list.indexOf(toAccountNumber);
//		BankAccountCA readyListBankAccountDep = list.get(indexDep);
		readyListBankAccountToDep.deposit(list,fundtransferAmount);
		
		System.out.println("Updated Balance of Sender Account: "+readyListBankAccountFromWith.accountBalance+"\nUpdated Balance of Reciever Account: "+readyListBankAccountToDep.accountBalance);
	}

@Override
public int compareTo(BankAccountCA o) {
//	return this.accountNumber.compareTo(o.accountNumber);
	return ((Integer)(this.accountNumber)).compareTo(o.accountNumber);
}
	
	
}
