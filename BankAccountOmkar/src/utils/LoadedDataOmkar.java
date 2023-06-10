package utils;

import java.time.LocalDate;
import java.util.ArrayList;

import com.app.banking.BankAccountOmkar;
import com.app.enums.AccountTypeOmkar;

public class LoadedDataOmkar {

	public static ArrayList<BankAccountOmkar> loadedList() {
		
		ArrayList<BankAccountOmkar> bank = new ArrayList<BankAccountOmkar>();
		bank.add(new BankAccountOmkar(1, "Omkar", AccountTypeOmkar.valueOf("SAVING"), 20000, LocalDate.now()));
		bank.add(new BankAccountOmkar(4, "Laxmikant", AccountTypeOmkar.valueOf("CURRENT"), 43000, LocalDate.now()));
		bank.add(new BankAccountOmkar(6, "Atul", AccountTypeOmkar.valueOf("FD"), 27000, LocalDate.now()));
		bank.add(new BankAccountOmkar(3, "Amber", AccountTypeOmkar.valueOf("NRE"), 44000, LocalDate.now()));
		bank.add(new BankAccountOmkar(2, "Sumit", AccountTypeOmkar.valueOf("FD"), 36000, LocalDate.now()));
		return bank;
		
	}

}
