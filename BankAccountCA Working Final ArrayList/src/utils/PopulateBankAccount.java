package utils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.app.core.AccountTypeCA;
import com.app.core.BankAccountCA;

public class PopulateBankAccount {
	public static List<BankAccountCA> populateBankAccount(){
		
		List<BankAccountCA> bankList = new ArrayList<>();
		
		bankList.add(new BankAccountCA(782, 999999, AccountTypeCA.valueOf("FD"), LocalDate.of(2023, 1, 1), "Henry"));
		bankList.add(new BankAccountCA(783, 999998, AccountTypeCA.valueOf("SAVINGS"), LocalDate.of(2023, 1, 1), "Drogba"));
		bankList.add(new BankAccountCA(784, 888888, AccountTypeCA.valueOf("SAVINGS"), LocalDate.of(2021, 8, 17), "Messi"));
		bankList.add(new BankAccountCA(789, 888888, AccountTypeCA.valueOf("SAVINGS"), LocalDate.of(2022, 1, 1), "Saka"));
		bankList.add(new BankAccountCA(788, 888888, AccountTypeCA.valueOf("SAVINGS"), LocalDate.of(2020, 1, 21), "Ronaldo"));
		bankList.add(new BankAccountCA(787, 666666, AccountTypeCA.valueOf("SAVINGS"), LocalDate.of(2023, 10, 19), "Benzema"));
		bankList.add(new BankAccountCA(786, 333333, AccountTypeCA.valueOf("SAVINGS"), LocalDate.of(2023, 1, 1), "Neymar"));

		return bankList;
	}
}
