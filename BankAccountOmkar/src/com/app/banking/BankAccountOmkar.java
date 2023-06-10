package com.app.banking;

import java.time.LocalDate;
import java.util.Objects;

import com.app.enums.AccountTypeOmkar;

import exception.CustomExceptionOmkar;
import validation.ValidationRulesOmkar;

public class BankAccountOmkar  implements Comparable<BankAccountOmkar>{

	private int accountNumber;
	private String customerName;
	private AccountTypeOmkar accountType;
	private double accountBalance;
	private LocalDate date;
	
	//Constructor
	public BankAccountOmkar(int accountNumber,String customerName,AccountTypeOmkar accountType, double accountBalance, LocalDate date)
	{
		this.accountNumber=accountNumber;
		this.customerName=customerName;
		this.accountType=accountType;
		this.accountBalance=accountBalance;
		this.date=date;
	}
	
	public BankAccountOmkar(int accountNumber) {
		super();
		this.accountNumber = accountNumber;
	}

	@Override
	public String toString() {
		return "BankAccount [accountNumber=" + accountNumber + ", customerName=" + customerName + ", accountType="
				+ accountType + ", accountBalance=" + accountBalance + ", date=" + date + "]";
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
	public AccountTypeOmkar getAccountType() {
		return accountType;
	}
	public void setAccountType(AccountTypeOmkar accountType) {
		this.accountType = accountType;
	}
	public double getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BankAccountOmkar other = (BankAccountOmkar) obj;
		return accountNumber == other.accountNumber;
	}
		
	
	//withdraw
  public void withdraw(double amount) throws CustomExceptionOmkar
  {
	
	 
	  if((this.accountBalance-amount)< this.getAccountType().getMinimunAmount() )
	  {
		  throw new CustomExceptionOmkar("Withdraw Amount is Greater than the Present Amount");
	  }
	  else {
		  this.accountBalance=this.accountBalance-amount;
		  
	  }
  }
  //deposit
  public void deposit(double amount) throws CustomExceptionOmkar
  {
	  this.accountBalance=this.accountBalance+amount;
  }
  
  //fundTransfer
  public void fundsTransfer(BankAccountOmkar receiver ,double amount) throws CustomExceptionOmkar
  { 
	  this.withdraw(amount);
	  receiver.deposit(amount);
  }

@Override
public int compareTo(BankAccountOmkar o) {
	// TODO Auto-generated method stub
	return ((Integer)this.accountNumber).compareTo(o.accountNumber);
}


	
	
}
