package validation;

import java.util.ArrayList;

import com.app.banking.BankAccountOmkar;
import com.app.enums.AccountTypeOmkar;

import exception.CustomExceptionOmkar;

public class ValidationRulesOmkar {
	public static void validateAccNo(int accNo, ArrayList<BankAccountOmkar> bank) throws CustomExceptionOmkar {
		if (bank.contains(new BankAccountOmkar(accNo))) {
			throw new CustomExceptionOmkar("Account Already Exist");
		}
	}

	public static void validateMinimumAmount(AccountTypeOmkar acctype, double balance) throws CustomExceptionOmkar {
		if (acctype.getMinimunAmount() > balance) {
			throw new CustomExceptionOmkar("The balance is less than the Minimum balance");
		}

	}
}
