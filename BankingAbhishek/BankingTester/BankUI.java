package BankingTester;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.app.banking.BankAccount;

import static utils.BankingUtils.*;

//The static import utils.BankingUtils must be a field or member type
//import static utils.BankingUtils;

public class BankUI {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		boolean exit = false;
		BankAccount bankAccount = new BankAccount();

//		what is wrong here, bankAccountList pointing to an ArrayList and then again reassigned to be pointing at
//		populateBankAccount(a list type of method,right?) or is there anything even wrong here
//		List <BankAccount> bankAccountList = new ArrayList<>();
//		bankAccountList = populateBankAccount();

		List<BankAccount> bankAccountList = populateBankAccount();

		while (!exit) {
			System.out.println("Welcome to THEBANK\n" + "1. Funds Transfer\\n\"\n" + "2. Display Account summary\n"
					+ "3. Withdraw from account\n" + "4. Deposit to account\n");

			switch (sc.nextInt()) {
			case 1:
				System.out.println("Enter the Sender's account no: ");
//					bankAccount.fundTransferUsingWD(new BankAccount(sc.nextInt()), sc.nextInt());

				break;

			case 2:
				System.out.println("List of Esteemed Accounts: ");
				populateBankAccount().toString();

			case 4:
				System.out.println("Enter the account no and funds to be deposited: ");
				bankAccount.deposit(sc.nextInt(), sc.nextDouble());
				break;

			case 3:
				System.out.println("Enter the account number and the amount to be withdrawn: ");
				BankAccount withdrawAccountNumberObject = null;
				int withdrawAccountNumber = sc.nextInt();
				double withdrawAmount = sc.nextDouble();
				withdrawAccountNumberObject.withdraw(withdrawAmount);
//					incomi.withdraw(incomingAmount);
				break;
			default:
				throw new IllegalArgumentException("Unexpected value: ");
			}
		}

	}

}
