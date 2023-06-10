package utils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.app.core.AccountTypeCA;
import com.app.core.BankAccountCA;

public class PopulateBankAccount {
	public static List<BankAccountCA> populateBankAccount(){
		
		List<BankAccountCA> bankList = new ArrayList<>();
		
		bankList.add(new BankAccountCA(782, 955454, AccountTypeCA.valueOf("FD"), LocalDate.of(2023, 1, 1), "Henry"));
		bankList.add(new BankAccountCA(783, 755454, AccountTypeCA.valueOf("SAVINGS"), LocalDate.of(2023, 1, 1), "Drogba"));
		bankList.add(new BankAccountCA(784, 75454, AccountTypeCA.valueOf("SAVINGS"), LocalDate.of(2021, 8, 17), "Messi"));
		bankList.add(new BankAccountCA(789, 75544, AccountTypeCA.valueOf("SAVINGS"), LocalDate.of(2022, 1, 1), "Saka"));
		bankList.add(new BankAccountCA(788, 755454, AccountTypeCA.valueOf("SAVINGS"), LocalDate.of(2020, 1, 21), "Ronaldo"));
		bankList.add(new BankAccountCA(787, 75544, AccountTypeCA.valueOf("SAVINGS"), LocalDate.of(2023, 10, 19), "Benzema"));
		bankList.add(new BankAccountCA(786, 75454, AccountTypeCA.valueOf("SAVINGS"), LocalDate.of(2023, 1, 1), "Neymar"));
		
		return bankList;
	}
}
