package utils;

import utils.BankingUtils;

import java.util.ArrayList;
import java.util.List;

import com.app.banking.BankAccount;
import com.app.enums.AccountType;

import BankingTester.BankUI.*;
import custom_execptions.InvalidInputExceptionBankAccount;
//import custom_exception.InvalidInputException;
//import custom_execptions.InvalidInputExceptionBankAccount;
import custom_execptions.InvalidInputExceptionBankAccount.*;

public class ValidationRulesBankAccount {

//	add a public method to validated if entered account exists in database
//	public static BankAccount checkforDupAcc (int accountNumber, List<BankAccount> bankAccountList) 
//			throws InvalidInputExceptionBankAccount{

	public static void checkForDupAccount(List<BankAccount> bankList, int accountNumber)
			throws InvalidInputExceptionBankAccount {
//		List<BankAccount> validateAccountRef = new ArrayList<BankAccount>();
//		validateAccountRef = 
		BankAccount newbankAccount = new BankAccount(accountNumber);
//		for contains to work properly we should override equals method
		if (bankList.contains(newbankAccount))
			throw new InvalidInputExceptionBankAccount("Please try a different account number, duplicate account");
		else
			System.out.println("New Account number !!!!");
//		senderAccountNumber
	}

	
	
	
//	add a public method to validated if entered account doesn't exist in database

	public static void bankAccountExists(int accountNumber, List<BankAccount> bankAccountList)
			throws InvalidInputExceptionBankAccount {
		BankAccount bnkAccExists = new BankAccount(accountNumber);
		if (!bankAccountList.contains(bnkAccExists)) {
			throw new InvalidInputExceptionBankAccount(
					"Bank Account doesn't exist, paisa kaha dalega beta, chal aaja naya aacount "
							+ "khol le issi account number se");
		} else
			System.out.println("Bank account found !!!! Please continueee !!");
	}

//	why does the compiler force me to write the throws clause for the minimumBalance method
	public static void minimumBalance(BankAccount bankAccount , double amount) throws InvalidInputExceptionBankAccount {

//		check if after withdrawing the given amount, does the new balance fall below the minimum balance of the said accountType
		if(bankAccount.getAccountBalance() - amount < bankAccount.getAccountType().getMinimumBalance())
				throw new InvalidInputExceptionBankAccount("Please let the minimum balance be at least this much for chosen account: " + bankAccount.getAccountType().getName() +
			" with minimum balance of (" +bankAccount.getAccountType().getMinimumBalance() + ") : ");
	}

//	why does the compiler force me to write the throws clause for the minimumBalance method
	public static void minimumBalanceNewAccount(AccountType acctype , double amount) throws InvalidInputExceptionBankAccount {

//		check if after withdrawing the given amount, does the new balance fall below the minimum balance of the said accountType
		if(acctype.getMinimumBalance() > amount )
				throw new InvalidInputExceptionBankAccount("Please enter minimum balance for the chosen account: " + acctype.getName() +
			" with minimum balance of (" +acctype.getMinimumBalance() + ") : ");
	}
}
