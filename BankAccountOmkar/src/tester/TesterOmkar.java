package tester;

import static utils.LoadedDataOmkar.loadedList;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import com.app.banking.BankAccountOmkar;
import com.app.enums.AccountTypeOmkar;

import exception.CustomExceptionOmkar;
//import validation.ValidationRules.*;
import static validation.ValidationRulesOmkar.*;

public class TesterOmkar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<BankAccountOmkar> bank = loadedList();
//bank.forEach(i -> System.out.println(i));

		boolean exit = false;
		try (Scanner sc = new Scanner(System.in)) {
			try {
				while (!exit) {
                    System.out.println("Select the Operation you want to Perform :\n"
                    		+ "1.Add a Bank Account\n"
                    		+ "2.Withdraw the Amount\n"
                    		+ "3.Deposit the Amount\n"
                    		+ "4.Transfer the Amount\n"
                    		+ "5.Display Details of all the Accounts\n"
                    		+ "6.Sort the Details Account to the Account Number\n"
                    		+ "7.Sort the Accounts according to the Date\n"
                    		+ "8.Sort According to the Balance in the Amount\n"
                    		+ "9.Exit");
					switch (sc.nextInt()) {
					case 1:
						System.out.println("Enter the Account Number of ypur Account: ");
						int accNumber=sc.nextInt();
						 validateAccNo(accNumber, bank);
						 System.out.println("Enter your Account type: ");
						 AccountTypeOmkar accType=AccountTypeOmkar.valueOf(sc.next().toUpperCase());
						 System.out.println("Enter your Account Balance:");
						 double balance=sc.nextDouble();
						 validateMinimumAmount(accType, balance);
						 System.out.println("Enter your Name and Date of Account Creation: ");
						 bank.add(new BankAccountOmkar(accNumber, sc.next(), accType, balance, LocalDate.parse(sc.next())));
						 
						break;
					case 2:
                          System.out.println("Enter the Account number of the Account you want to withdraw the Amount");
                          int accNo=sc.nextInt();
                         
                          BankAccountOmkar first= new BankAccountOmkar(accNo);
                          int ans=bank.indexOf(first);
                          if(ans==-1)
                          {
                        	  throw new CustomExceptionOmkar("Account Does not Exist");
                          }
                          else {
                        	  System.out.println("Enter the amount you want to Withdraw");
                        	  bank.get(ans).withdraw(sc.nextDouble());
                          }
						break;
						
					case 3:
						System.out.println("Enter the Account number of the Account you want to deposit the Amount");
                        accNo=sc.nextInt();
                         first= new BankAccountOmkar(accNo);
                         ans=bank.indexOf(first);
                        if(ans==-1)
                        {
                      	  throw new CustomExceptionOmkar("Account Does not Exist");
                        }
                        else {
                      	  System.out.println("Enter the amount you want to Deposit");
                      	  bank.get(ans).deposit(sc.nextDouble());
                        }
						break;
					case 4:
						System.out.println("Enter the Account number of the Sender Account");
                        accNo=sc.nextInt();
                         first= new BankAccountOmkar(accNo);
                         ans=bank.indexOf(first);
                        if(ans==-1)
                        {
                      	  throw new CustomExceptionOmkar("Sender Account Does not Exist");
                        }
                        else {
                        	System.out.println("Enter the Account number of the Receiver Account");
                            int accNo1=sc.nextInt();
                            BankAccountOmkar first1= new BankAccountOmkar(accNo1);
                             int ans1=bank.indexOf(first1);
                            if(ans1==-1)
                            {
                          	  throw new CustomExceptionOmkar("Receiver Account Does not Exist");
                            }
                            else {
                            	BankAccountOmkar b1=bank.get(ans1);
                            	 System.out.println("Both Account Exist Enter the amount you want to Withdraw");
                            	 bank.get(ans).fundsTransfer(b1, sc.nextDouble());
                            }
                      	 
                      	 
                      	 
                        }
						break;
					case 5:
						bank.forEach(i->System.out.println(i));
						break;
					case 6:
                          Collections.sort(bank);
						break;
					case 7:
						Collections.sort(bank, ((b1,b2)-> b2.getDate().compareTo(b1.getDate())   ));
						break;
					case 8:
						Collections.sort(bank, ((b1,b2)-> ((Double)b1.getAccountBalance()).compareTo(b2.getAccountBalance())));
						
						break;
					case 9:
						exit=true;
						
					}
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

}
