package tester;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import com.app.core.AccountTypeCA;
import com.app.core.BankAccountCA;

import utils.PopulateBankAccount;
import utils.ValidationRules;

public class BankTester {
	
	public static void main(String[] args) {
		
		try {Scanner sc = new Scanner(System.in);
		
		List<BankAccountCA> bankingList = PopulateBankAccount.populateBankAccount();
		boolean exit=false;
		
		while(!exit) {
			System.out.println("1. Display all accounts\n"
					+ "2. Add new account\n"
					+ "3. Withdraw\n"
					+ "4. Deposit\n"
					+ "5. Fund Transfer\n"
					+ "6. Natural Sorting based on Account Number\n"
					+ "7. Reverse Sorting based on Account Number\n"
					+ "8. Ascending sorting based on account balance\n"
					+ "9. Compound sort based on Account Number and Account Balance\n");
			System.out.println("Choose an option: ");
			try {
				
			switch (sc.nextInt()) {
			case 1:
				System.out.println("Following it the list of all acoount: ");
				for(BankAccountCA b: bankingList) {
					System.out.println(b);
				}
				break;
				
			case 2:
				System.out.println("Add new account: ");
				
				System.out.println("Enter the account number: ");
				int intAccNo = sc.nextInt();
				BankAccountCA accNo = new BankAccountCA(intAccNo);
				ValidationRules.checkForDupAcc(accNo, bankingList);
				
				System.out.println("Enter the account type: ");
				String accType=sc.next().toUpperCase();

//				no validationrule req for enum
				AccountTypeCA accTypeEnumRef = AccountTypeCA.valueOf(accType);
				
				System.out.println("Enter Opening balance: ");
				int accBal=sc.nextInt();
				ValidationRules.checkOpeningMinimumBal(accBal, accTypeEnumRef);
				
//				why is there no new for local date. is no instance created here
				LocalDate accOpenDate = LocalDate.now();
				
				System.out.println("Enter customer name");
				String custName = sc.next();
				
				bankingList.add(new BankAccountCA(intAccNo, accBal, accTypeEnumRef, accOpenDate, custName));
				System.out.println("New Bank Account Added!!!!!!!!!!");
				

				break;

			case 3://Withdraw
				System.out.println("Withdraw: ");
				
				System.out.println("Please enter your acc number: ");
				int accountNum=sc.nextInt();
				BankAccountCA accountNumWithRef = new BankAccountCA(accountNum);
				ValidationRules.checkIfAccountExists(accountNumWithRef, bankingList);
				
				System.out.println("Pls enter withdrawl ammount: ");
				double withdrawAmt = sc.nextDouble();
				
				accountNumWithRef.withdraw(bankingList, withdrawAmt);
				
				System.out.println("Withdrawl success!!!!!");
				
				
				break;
				
			case 4://Deposit
				System.out.println("Deposit: ");

				System.out.println("Please enter your acc number: ");
				int accountNumDep=sc.nextInt();
				BankAccountCA accountNumDepRef = new BankAccountCA(accountNumDep);
				ValidationRules.checkIfAccountExists(accountNumDepRef, bankingList);

				System.out.println("Pls enter deposit ammount: ");
				double depositAmt = sc.nextDouble();
				
				accountNumDepRef.deposit(bankingList, depositAmt);
				
				System.out.println("Deposit success!!!!!");
			
				
				break;
				
			case 5://Fund Transfer
				System.out.println("Fund Transfer: ");
				System.out.println("Please enter your acc number: ");
				int accountNumSend=sc.nextInt();
				BankAccountCA accountNumSendRef = new BankAccountCA(accountNumSend);
//				ValidationRules.checkForDupAcc(accountNumSendRef, bankingList);
				
				System.out.println("Enter the fund transfer amount: ");
				double fundTransferAmount = sc.nextDouble();
				
				System.out.println("Please enter the reciever acc number: ");
				int accountNumRec=sc.nextInt();
				BankAccountCA accountNumRecRef = new BankAccountCA(accountNumRec);
//				ValidationRules.checkForDupAcc(accountNumRecRef, bankingList);
				
				accountNumSendRef.fundTransfer(bankingList,accountNumSendRef,accountNumRecRef,fundTransferAmount);
				
				break;
				
			case 6://Natural Sorting based on Account Number
				Collections.sort(bankingList);
				
				for(BankAccountCA b:bankingList) {
					System.out.println(b);
				}
				break;
				
			case 7://Reverse Sorting based on Account Number
				ArrayList<BankAccountCA> reverseSortAccNum = new ArrayList<BankAccountCA>(bankingList);
				Collections.sort(reverseSortAccNum, new Comparator<BankAccountCA>() {

					@Override
					public int compare(BankAccountCA o1, BankAccountCA o2) {
						return ((Integer)o2.getAccountNumber()).compareTo(o1.getAccountNumber());
//						return o2.getAccountNumber()-o1.getAccountNumber();
					}				
				});
				
				for(BankAccountCA b:reverseSortAccNum) {
					System.out.println(b);
				}
				
				break;
				
			case 8://Decending sorting based on account balance
				ArrayList<BankAccountCA> reverseSortAccBal = new ArrayList<BankAccountCA>(bankingList);
				Collections.sort(reverseSortAccBal, new Comparator<BankAccountCA>() {
					public int compare(BankAccountCA o1, BankAccountCA o2) {
						return ((Double)o1.getAccountBalance()).compareTo(o2.getAccountBalance());
//						return (int) (o2.getAccountBalance()- o1.getAccountBalance());
					}
				});
				
				for(BankAccountCA b:reverseSortAccBal) {
					System.out.println(b);
				}
				
				break;
				
			case 9://Compound sort based on Account Number and Account Balance
				ArrayList<BankAccountCA> reverseSortAccNumBal = new ArrayList<BankAccountCA>(bankingList);
				Collections.sort(reverseSortAccNumBal, new Comparator<BankAccountCA>() {

					@Override
					public int compare(BankAccountCA o1, BankAccountCA o2) {
						
						if(((Double)o1.getAccountBalance()).compareTo(o2.getAccountBalance())==0) {
							return ((Integer)o1.getAccountNumber()).compareTo(o2.getAccountNumber());
						}
						else
							return ((Double)o1.getAccountBalance()).compareTo(o2.getAccountBalance());
//						
//						if(((Double)o1.getAccountBalance()).compareTo(o2.getAccountBalance())==0){
//					
//							return ((Integer)o1.getAccountNumber()).compareTo(o2.getAccountNumber();
//						}
//						return (((Double)o1.getAccountBalance()).compareTo(o2.getAccountBalance());
					}
				});
				
				for(BankAccountCA b:reverseSortAccNumBal) {
					System.out.println(b);
				}
				break;

			default:
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
