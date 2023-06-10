package BankingTester;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import com.app.banking.BankAccount;
import com.app.enums.AccountType;

import utils.ValidationRulesBankAccount;
import utils.ValidationRulesBankAccount.*;

import static utils.ValidationRulesBankAccount.*;

import static com.app.banking.BankAccount.*;

import static utils.BankingUtils.*;

//The static import utils.BankingUtils must be a field or member type
//import static utils.BankingUtils;
public class BankUI {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			boolean exit = false;
			BankAccount bankAccount = new BankAccount();

//		what is wrong here, bankAccountList pointing to an ArrayList and then again reassigned to be pointing at
//		populateBankAccount(a list type of method,right?) or is there anything even wrong here
//		List <BankAccount> bankAccountList = new ArrayList<>();
//		bankAccountList = populateBankAccount();
			List<BankAccount> bankAccountList = populateBankAccount();

			while (!exit) {
				System.out.println("\nWelcome to THE BANK\n" + "1. Funds Transfer\n" + "2. Display Account summary\n"
						+ "3. Withdraw from account\n" + "4. Deposit to account\n" + "5. Add new Account\n" + 
						"6. Natural sorting according to Account Number\n" + "7. Sort according to Date\n" + "8. Delete an account\n");

				try {
					switch (sc.nextInt()) {
					case 1: // funds transfer
						System.out.println("Enter the Sender's account no: ");
						int senderAccountNumber = sc.nextInt();						
//						Sending int senderAccountNumber and wrapping it in ref inside bankAccountExists
						ValidationRulesBankAccount.bankAccountExists(senderAccountNumber, bankAccountList);
						int index = bankAccountList.indexOf(new BankAccount(senderAccountNumber));
						BankAccount transferAccount = bankAccountList.get(index);

						System.out.println("Enter the Reciever's account no: ");
						int recieverAccountNumber = sc.nextInt();
						ValidationRulesBankAccount.bankAccountExists(recieverAccountNumber, bankAccountList);

						System.out.println("Enter the amount to be transferred: ");
						double transferAmount = sc.nextDouble();

						ValidationRulesBankAccount.minimumBalance(transferAccount, transferAmount);

//						BankAccount sender = new BankAccount(senderAccountNumber);
//						BankAccount reciever = new BankAccount(recieverAccountNumber);

//						bankAccount.fundTransferUsingWD(new BankAccount(sc.nextInt()), sc.nextInt());
//						bankAccount.fundTransferUsingWD(new BankAccount(sc.nextInt()) , sc.nextDouble());
//						fundTransferUsingWD(bankAccountList, sender, reciever, transferAmount);
						fundTransferUsingWD(bankAccountList, senderAccountNumber, recieverAccountNumber,
								transferAmount);
						break;

					case 2: // list accounts
						System.out.println("List of Esteemed Accounts: ");
						for (BankAccount b : bankAccountList) {
							System.out.println(b);
						}
						break;
//						bankAccountList.toString();

					case 3: // withdraw
						System.out.println("Enter the account number and the amount to be withdrawn: ");
						int withdrawAccountNumber = sc.nextInt();
						ValidationRulesBankAccount.bankAccountExists(withdrawAccountNumber, bankAccountList);
						int index1 = bankAccountList.indexOf(new BankAccount(withdrawAccountNumber));

						BankAccount withdrawAccountNumberRef = bankAccountList.get(index1);
//						BankAccount withdrawAccountNumberRef = new BankAccount(withdrawAccountNumber);
//						AccountType accType = withdrawAccountNumberRef.getAccountType();
//						getAccountType()

						System.out.println("Enter the amount to be withdrawn: ");
						double withdrawAmount = sc.nextDouble();
//						BankAccount b1 = 
						ValidationRulesBankAccount.minimumBalance(withdrawAccountNumberRef, withdrawAmount);
						withdrawAccountNumberRef.withdraw(bankAccountList, withdrawAccountNumber, withdrawAmount);
//						int withdrawAccountNumber = sc.nextInt();
//						double withdrawAmount = sc.nextDouble();
//						withdrawAccountNumberObject.withdraw(withdrawAccountNumber, withdrawAmount);
//						passing bankAccountList in the withdraw method so as to operate on it inside the method and then also update it inside it
//						withdrawAccountNumberObject.withdraw(bankAccountList, sc.nextInt(), sc.nextDouble());
//						bankAccount.withdraw(bankAccountList, sc.nextInt(), sc.nextDouble());
//						incomi.withdraw(incomingAmount);
//						throw new IllegalArgumentException("Unexpected value: ");
						break;

					case 4: // deposit
						System.out.println("Enter the account no to which amount is to be deposited: ");
						int depositAccountNumber = sc.nextInt();
						ValidationRulesBankAccount.bankAccountExists(depositAccountNumber, bankAccountList);
						System.out.println("Enter funds to be deposited: ");
						double depositAmount = sc.nextDouble();
						bankAccount.deposit(bankAccountList, depositAccountNumber, depositAmount);
						break;

					case 5: // add new account
						int newAccountNumber;
						do {
							System.out.println("Enter a four digit account number to add a new bank account: ");
							newAccountNumber = sc.nextInt();
						} while (newAccountNumber < 1000 || newAccountNumber > 9999);

						ValidationRulesBankAccount.checkForDupAccount(bankAccountList, newAccountNumber);

						System.out.println("Enter your good name please(press enter when done): ");
//						String newName = sc.nextLine(); 	// nextLine() => this is seeming to be problematic
						String newName = sc.next();

						System.out.println("Enter your account type please: ");
//				sending data to AccountType in a all CAPS manner 
						AccountType newAccountType = AccountType.valueOf(sc.next().toUpperCase());

						System.out.println("Enter the account balance: ");
						double newAccountBalance = sc.nextDouble();
						ValidationRulesBankAccount.minimumBalanceNewAccount(newAccountType, newAccountBalance);
						
						
						bankAccountList.add(new BankAccount(newAccountNumber, newName, newAccountType,
								newAccountBalance, LocalDate.now()));
						System.out.println("New Account added !!!!!!!!!");
						
//						BankAccount newAccountOpening = new BankAccount(newAccountNumber, newName, newAccountType,
//								newAccountBalance, LocalDate.now());
						break;

//				default:
					case 6:
						System.out.println("Sorted according to Account Number: ");
						Collections.sort(bankAccountList);
						break;
						
					case 7:
						System.out.println("Sorted using custom sort according to AccountOpeningDate: ");
						Collections.sort(bankAccountList, new Comparator<BankAccount>() {

							@Override
							public int compare(BankAccount o1, BankAccount o2) {
								
								// TODO Auto-generated method stub
								return o1.getAccountOpeningDate().compareTo(o2.getAccountOpeningDate());
							}
							
						});
						
						break;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
