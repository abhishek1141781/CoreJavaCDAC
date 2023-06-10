package utils;


import java.util.List;

import com.app.banking.AccountType;
import com.app.banking.BankAccount;

import custom_exception.InvalidInputException;

public class ValidationRules {

//	1. User should not be able to add dup accounts (PK : account no)

	public static void checkForDupAccount(List<BankAccount> bankList, int accountNumber)
			throws InvalidInputException {
		BankAccount newAccount = new BankAccount(accountNumber);
		if (bankList.contains(newAccount))
			throw new InvalidInputException("Duplicate account!!!");

		System.out.println("No duplicate Found!!!");
	}
//2. min balance while creating the account or in any withdrawl : should not be < min balance 
	public static AccountType checkAccountType(String type)
	{
		return AccountType.valueOf(type.toUpperCase());
	}

//	public static AccountType checkMinBal()
	
//public static AccountType checkMinBal(Double withdrawnAmount) {
//		if (withdrawnAmount > 0 && withdrawnAmount <  acc )
//return AccountType.valueOf;
//		
}

