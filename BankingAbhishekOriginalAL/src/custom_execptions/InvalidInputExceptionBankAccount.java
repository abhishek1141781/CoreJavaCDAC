package custom_execptions;

@SuppressWarnings("serial")
public class InvalidInputExceptionBankAccount extends Exception {
		public InvalidInputExceptionBankAccount(String message) {
			super(message);
		}

}
