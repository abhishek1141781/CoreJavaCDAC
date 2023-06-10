package com.app.banking;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sound.midi.Receiver;

import com.app.enums.AccountType;

import utils.BankingUtils;
//import static utils.BankingUtils.populateBankAccount;

public class BankAccount {
	private int accountNumber;
	private String customerName;
	private AccountType accountType;
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
	public AccountType getAccountType() {
		return accountType;
	}
	public void setAccountType(AccountType accountType) {
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
	
	
//	public BankAccount(int accountNumber) {
//		super();
//		this.accountNumber = accountNumber;
//	}
	
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
	
	public void withdraw(Map<Integer, BankAccount> map, int accountNumber, double withdrawAmount) {
		
		BankAccount useracc =  map.get(accountNumber);

//		useracc.accountNumber = BankingUtils.populateBankAccount().get(BankingUtils.populateBankAccount().indexOf(accountNumber)).getAccountNumber();
		System.out.println("Withdraw in process from account: " + useracc.customerName + " : Account number: " + useracc.accountNumber);
		System.out.println("Current balance of withdrawee account: " + useracc.accountBalance);	
		useracc.setAccountBalance(useracc.getAccountBalance()-withdrawAmount); 
		System.out.println("Updated account balance after withdrawal is : " + useracc.accountBalance);
//		return;
//		accountBalance -=
//		return thisetAccountBalance(this.getAccountBalance()-withdrawAmount);
//		List<BankAccount> list = BankingUtils.populateBankAccount(); 
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


//		public void deposit(List<BankAccount> list,  int accountNumber, double depositAmount) {
		public void deposit(Map<Integer,BankAccount> map, int accountNumber, double depositAmount) {
//		BankingUtils.populateBankAccount().indexOf(accountNumber);		
//		import utils.BankingUtils;
		BankAccount useracc = map.get(accountNumber);
//		BankAccount useracc = list.get(list.indexOf(new BankAccount(accountNumber)));

//		anything wrong with this approach: this.accountNumber as opp to just accountNumber
//		this.accountNumber = BankingUtils.populateBankAccount().get(BankingUtils.populateBankAccount().indexOf(accountNumber)).getAccountNumber();
//		this.accountNumber = BankingUtils.populateBankAccount().get(BankingUtils.populateBankAccount().indexOf(accountNumber)).getAccountNumber();
		System.out.println("Deposit in process in account: " + useracc.customerName + " : Account number: " + useracc.accountNumber);
		System.out.println("Current balance of depositor account: " + useracc.accountBalance);
		useracc.setAccountBalance(useracc.getAccountBalance() + depositAmount); 
//		return accountBalance;
		System.out.println("Updated account balance after deposit in the account" + useracc.accountNumber +" is : " + useracc.accountBalance);
//		accountBalance -=
//		return thisetAccountBalance(this.getAccountBalance()-withdrawAmount);
	}

	public static void fundTransferUsingWD(Map<Integer, BankAccount> map,int senderAccountNumber, int recieverAccountNumber, double transferAmount) {
		BankAccount srcacc =  map.get(senderAccountNumber);
		BankAccount tgtacc =  map.get(recieverAccountNumber);
		
//		System.out.println("Current balance of Sender's account: " + srcacc.accountBalance);
		System.out.println("Current balance of Sender's account: " + srcacc.getAccountBalance());
		System.out.println("Current balance of Sender's account: " + tgtacc.getAccountBalance());
//		withdraw from invokee account
		srcacc.withdraw(map, senderAccountNumber, transferAmount);
//		deposit to said account
		tgtacc.deposit(map, recieverAccountNumber, transferAmount);

		System.out.println("Funds of amount: "+ transferAmount + "\n transfered from Sender Acc number: " + srcacc.getAccountNumber() + "\n to the reciever acc number: " + tgtacc.getAccountNumber());
		System.out.println("Updated balance of Sender's account: " + srcacc.accountBalance);
		System.out.println("Updated balance of Reciever's account: " + tgtacc.accountBalance);
	}

//	@Override
//	public boolean  equals (Object o) {
//		System.out.println("Mai equal aaya");
//		if (o instanceof BankAccount)
//			return this.accountNumber == (((BankAccount)o).accountNumber);
//		return false;
//	}
//	@Override
//	public int compareTo(BankAccount o) {
//		return ((Integer)this.accountNumber).compareTo(o.accountNumber);
//	}

//	public double
//	
//		
//	}
	
//	@Override
//	public String toString() {
//		return 
	}

