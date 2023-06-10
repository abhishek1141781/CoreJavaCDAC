package com.app.banking;

import java.time.LocalDate;
import java.util.List;

import utils.BankingUtils;
//import static utils.BankingUtils.populateBankAccount;

public class BankAccount {
	private int accountNumber;
	private String customerName;
	private String accountType;
	private double accountBalance;
	private LocalDate accountOpeningDate;
	
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
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
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
	
	
	public BankAccount(int accountNumber) {
		super();
		this.accountNumber = accountNumber;
	}
	
	@Override
	public String toString() {
		return "BankAccount [accountNumber=" + accountNumber + ", customerName=" + customerName + ", accountType="
				+ accountType + ", accountBalance=" + accountBalance + ", accountOpeningDate=" + accountOpeningDate
				+ "]";
	}
	public BankAccount(int accountNumber, String customerName, String accountType, double accountBalance,
			LocalDate accountOpeningDate) {
		super();
		this.accountNumber = accountNumber;
		this.customerName = customerName;
		this.accountType = accountType;
		this.accountBalance = accountBalance;
		this.accountOpeningDate = accountOpeningDate;
	}
	
	
	
//	public BankAccount(int accountNumber, String customerName, String accountType, double accountBalance,
//			LocalDate accountOpeningDate) {
//		how did this work the other time
//		super(accountNumber,customerName,accountType,accountBalance,accountOpeningDate);	

//		this.accountNumber = accountNumber;
//		this.customerName = customerName;
//		this.accountType = accountType;
//		this.accountBalance = accountBalance;
//		this.accountOpeningDate = accountOpeningDate;
//	}
	
	
	
	
	
	public BankAccount() {
		super();
	}
	
	public void withdraw(double withdrawAmount) {
		System.out.println("Withdraw in process from account: " + this.customerName + " : Account number: " + this.accountNumber);
		System.out.println("Current balance of withdrawee account: " + this.accountBalance);	
		this.setAccountBalance(this.getAccountBalance()-withdrawAmount); 
		System.out.println("Updated account balance after withdrawal is : " + this.accountBalance);
//		return;
//		accountBalance -=
//		return thisetAccountBalance(this.getAccountBalance()-withdrawAmount);
	}
	
	
//	public void withdrawUsingTwoArgs(List<BankAccount> bankAccountList, int accountNumber, double withdrawAmount) {
//		System.out.println("Withdraw in process from account: " + this.customerName + " : Account number: " + this.accountNumber);
//		System.out.println("Current balance of withdrawee account: " + this.accountBalance);
//		
//		bankAccountList.indexOf(new )
//		this.setAccountBalance(this.getAccountBalance()-withdrawAmount);
//		System.out.println("Updated account balance after withdrawal is : " + this.accountBalance);
////		return;
////		accountBalance -=
////		return thisetAccountBalance(this.getAccountBalance()-withdrawAmount);
//	}


	public void deposit(int accountNumber, double depositAmount) {

//		BankingUtils.populateBankAccount().indexOf(accountNumber);

		
//		import utils.BankingUtils;
		BankingUtils.populateBankAccount().get(BankingUtils.populateBankAccount().indexOf(accountNumber));

//		anything wrong with this approach: this.accountNumber as opp to just accountNumber
//		this.accountNumber = BankingUtils.populateBankAccount().get(BankingUtils.populateBankAccount().indexOf(accountNumber)).getAccountNumber();
		this.accountNumber = BankingUtils.populateBankAccount().get(BankingUtils.populateBankAccount().indexOf(accountNumber)).getAccountNumber();

		System.out.println("Deposit in process in account: " + this.customerName + " : Account number: " + this.accountNumber);
		System.out.println("Current balance of depositor account: " + this.accountBalance);
		this.setAccountBalance(this.getAccountBalance() + depositAmount); 
//		return accountBalance;
		System.out.println("Updated account balance after deposit in the account" + this.accountNumber +" is : " + this.accountBalance);
//		accountBalance -=
//		return thisetAccountBalance(this.getAccountBalance()-withdrawAmount);
	}

	public void fundTransferUsingWD(BankAccount recieverAccount, double transferAmount) {
		System.out.println("Current balance of Sender's account: " + this.accountBalance);
		System.out.println("Current balance of Reciever's account: " + recieverAccount.accountBalance);
//		withdraw from invokee account
		this.withdraw(transferAmount);
		recieverAccount.deposit(accountNumber, transferAmount);
		
		System.out.println("Funds of amount: "+ transferAmount + "\n transfered from Sender Acc number: " + this.accountNumber + "\n to the reciever acc number: " + recieverAccount);
		System.out.println("Updated balance of Sender's account: " + this.accountBalance);
		System.out.println("Updated balance of Reciever's account: " + recieverAccount.accountBalance);
	}
	
//	public double
//	
//		
//	}

}