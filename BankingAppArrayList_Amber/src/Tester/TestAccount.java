package Tester;

import static utils.populateBankDetails.populateDetails;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.app.banking.AccountType;
import com.app.banking.BankAccount;

import static utils.ValidationRules.*;
import custom_exception.InvalidInputException;

public class TestAccount {

	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in)) {

			List<BankAccount> bankAccount = populateDetails();

			boolean exit = false;
			while (!exit) {
				System.out
						.println("1.Accept account holder details from user\n" + "2.Display \n" + "3.Account summary\n"
								+ "4.Perform : Withdraw\n" + "5.Deposit\n" + "6.Funds Transfer\n" + "0.EXIT");
				System.out.println("Select the task to be performed : ");

				switch (sc.nextInt()) {
				case 1:// Accept account holder details from the user
					System.out.println("Enter details of Account Holder as follow :" + "Account Number,"
							+ "Account Type," + "Account Balance," + "AccountOpeningDate(YYYY-MM-DD)");

					int AccNo = sc.nextInt();
					checkForDupAccount(bankAccount, AccNo);
					AccountType validateAccType = checkAccountType(sc.next());
					double accBalance = sc.nextDouble();
					LocalDate date = LocalDate.parse(sc.next());
					String name = sc.next();
					if (validateAccType.getMinBalance() < accBalance) {
						bankAccount.add(new BankAccount(AccNo, name, validateAccType, accBalance, date));
					} else {
						throw new InputMismatchException("Account Balance is low ");
					}
					break;

				case 2:// Display the list of users
					for (BankAccount b : bankAccount) {
						if (b != null)
							System.out.println(b);
					}
					break;

				case 3:// Account Summary of the given account
					System.out.println("Enter the Account Number of whose summary user required:");
					int accNum = sc.nextInt();
					int index = bankAccount.indexOf(new BankAccount(accNum));
					if (index == -1)
						throw new InvalidInputException("Invalid account number entered!!");
					// --->Account Exist
					System.out.println("Details " + bankAccount.get(index));
					break;

				case 4:// Perform : Withdraw
					System.out.println("Enter the account number for whose withdraw operation is performed:");
					int accNo = sc.nextInt();
					for (BankAccount b : bankAccount) {
						if (b.getAccountNumber() == accNo) {
							System.out.println("Enter the amount??");
							b.withdraw(sc.nextDouble());
							break;
						} else
							throw new InvalidInputException("Invalid account number entered!!");

					}
					break;

				case 5:// Deposit
					System.out.println("Enter the account number for whose deposit operation is performed!!");
					accNo = sc.nextInt();

					for (BankAccount b : bankAccount) {
						if (b.getAccountNumber() == accNo) {
							System.out.println("Enter the amount??");
							b.deposit(sc.nextDouble());
							break;
						} else
							throw new InvalidInputException("Invalid account number entered!!");

					}
					break;

				case 6:// Funds Transfer
					System.out.println("Enter the bank account index from whom tranfer has to be made :");
					int ftw = sc.nextInt();
					System.out.println("Enter the bank account index to whom tranfer has to be done :");
					int ftd = sc.nextInt();

					int creditorIndex = bankAccount.indexOf(new BankAccount(ftw));
					BankAccount creditor = bankAccount.get(creditorIndex);
					int debitorIndex = bankAccount.indexOf(new BankAccount(ftd));
					BankAccount depositor = new BankAccount(debitorIndex);
					System.out.println("Enter the amount to be transfered :");
					double fta = sc.nextDouble();

					depositor.fundTransfer(creditor, fta);

					break;
				case 7://natural sorting based on account number
					
					break;
				case 8://custom sorting based on date
					break;
				case 9://custom sorting based on balance in desc
				break;
				
				case 0:
					exit = true;
					break;
				}
			}
		} catch (InvalidInputException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
