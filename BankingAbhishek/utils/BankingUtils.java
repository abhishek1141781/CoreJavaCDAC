package utils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.app.banking.BankAccount;

//import com.app.banking.BankAccount;

public class BankingUtils {
//	Adding a static method to return a populated list (hard coded data of list) of bank accounts
//	Btw why is this method static
	public static List<BankAccount> populateBankAccount() {		// is public that's written here, implicit?
		List<BankAccount> bankAccount = new ArrayList<>();
		
//int accountNumber, String customerName, String accountType, double accountBalance, LocalDate accountOpeningDate)
//int accountNumber, String customerName, String accountType, double accountBalance, LocalDate accountOpeningDate)
//		bankAccount.add(new BankAccount(1141781,"Arshavin","FD",340000,"2020-02-02"));
		bankAccount.add(new BankAccount(1141780,"Arshavin","FD",340000,LocalDate.of(2003, 02, 01)));
		bankAccount.add(new BankAccount(1141781,"Andrey","SAVINGS",340000,LocalDate.of(2012, 03, 01)));
		bankAccount.add(new BankAccount(1141782,"Ballack","CURRENT",340000,LocalDate.of(2021, 04, 01)));
		bankAccount.add(new BankAccount(1141783,"Drogba","SAVINGS",340045,LocalDate.of(2020, 05, 01)));
		bankAccount.add(new BankAccount(1141784,"Lampard","SAVINGS",770000,LocalDate.of(2021, 07, 01)));
		bankAccount.add(new BankAccount(1141785,"Gerrard","SAVINGS",380000,LocalDate.of(2004, 05, 01)));
		
		return bankAccount;
	}
	
//	@Override
//	public static toString() {
//		for(Bank  )
//	}
	
}