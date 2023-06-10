package com.app.core;

import java.time.LocalDate;
import java.util.List;

import custom_exception.InvalidInputException;
import utils.ValidationRules;

public class BankAccountCA {
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
		
		ValidationRules.objectGetter(list, this);
		
		System.out.println("Current Account Balance: "+this.accountBalance+"\n");
		this.setAccountBalance(this.getAccountBalance()+depositAmount);
		System.out.println("Account name: "+this.customerName+"\nAccount Number: "+this.accountNumber+"\nUpdate Account Balance: "+this.accountBalance);
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
	public void fundTransfer(List<BankAccountCA> list, BankAccountCA toAccountNumber,double fundtransferAmount) throws InvalidInputException{

		BankAccountCA readyListBankAccountWith = ValidationRules.objectGetter(list, this);
		BankAccountCA readyListBankAccountDep =  ValidationRules.objectGetter(list, toAccountNumber);
		
		System.out.println("Current Balance of Sender Account: "+readyListBankAccountWith.accountBalance+"\nCurrent Balance of Reciever Account: "+readyListBankAccountDep.getAccountBalance());
		
//		int indexWith=list.indexOf(this);
//		BankAccountCA readyListBankAccountWith = list.get(indexWith);
//		readyListBankAccountWith.withdraw(list,fundtransferAmount);
		
//		int indexDep=list.indexOf(toAccountNumber);
//		BankAccountCA readyListBankAccountDep = list.get(indexDep);
//		readyListBankAccountDep.deposit(list,fundtransferAmount);
		
		System.out.println("Updated Balance of Sender Account: "+readyListBankAccountWith.accountBalance+"\nUpdated Balance of Reciever Account: "+readyListBankAccountDep.getAccountBalance());
	}
	
	
}
