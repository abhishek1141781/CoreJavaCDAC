package utils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.app.banking.AccountType;
import com.app.banking.BankAccount;

import custom_exception.InvalidInputException;

public class populateBankDetails {
// Add a static method to return populated list(sample hard coded data) of bank account details
	public static List<BankAccount> populateDetails() throws InvalidInputException {
		List<BankAccount> bAccount = new ArrayList<>();
		// String chasisNo, Color vehicleColor, double basePrice, LocalDate
		// manufactureDate, String company
		bAccount.add(new BankAccount(123400, "Cust2", AccountType.SAVING, 123456, LocalDate.parse("2021-12-12")));
		bAccount.add(new BankAccount(123401, "Cust3", AccountType.NRO, 1023456, LocalDate.parse("2023-01-12")));
		bAccount.add(new BankAccount(123402, "Cust4", AccountType.NRE, 1374236, LocalDate.parse("2000-12-12")));
		bAccount.add(new BankAccount(123403, "Cust5", AccountType.FD, 12347956, LocalDate.parse("2021-12-14")));
		bAccount.add(new BankAccount(123404, "Cust6", AccountType.CURRENT, 1550456, LocalDate.parse("2021-12-12")));
		bAccount.add(new BankAccount(123600, "Cust7", AccountType.FD, 1230343, LocalDate.parse("2011-01-15")));
		return bAccount;
	}
}