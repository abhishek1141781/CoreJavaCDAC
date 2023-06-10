package utils;

import java.util.List;

import com.app.core.AccountTypeCA;
import com.app.core.BankAccountCA;

import custom_exception.InvalidInputException;

public class ValidationRules {
	public static void checkForDupAcc(BankAccountCA accountNumber, List<BankAccountCA> list) throws InvalidInputException{
		if(list.contains(accountNumber))
			throw new InvalidInputException("Duplicate account number");
	}
	
//	public static AccountTypeCA checkEnum(String accType) throws InvalidInputException{
//		return AccountTypeCA.valueOf(accType);
//		
//	}
	public static void checkOpeningMinimumBal(int openBal,AccountTypeCA accType) throws InvalidInputException {
		if(accType.getMinimiumAccountBal()>openBal) {
			throw new InvalidInputException("Opening balance is less than specified for account type"+accType+"("+accType.getMinimiumAccountBal()+")");
		}
	}
	
	
	public static void checkIfAccountExists(BankAccountCA accountNumber, List<BankAccountCA> list) throws InvalidInputException{
		if(!list.contains(accountNumber)) {
			throw new InvalidInputException("Entered Account Number not found in bank database");
		}
	}
	
		public static BankAccountCA objectGetter(List<BankAccountCA> list,BankAccountCA ref) {

			int index=list.indexOf(ref);
		
			BankAccountCA operationRef= list.get(index);
			
			return operationRef;
		}
		
		
		
//		if(AccountTypeCA.valueOf(accType) != null)
//			System.out.println("account type exists");
//		else
//			throw new InvalidInputException(accType.toUpperCase()+" account type doesn't exist");
}
