package custom_exceptions;

@SuppressWarnings("serial")
public class InvalidInputException extends Exception {
	public InvalidInputException(String mesg) {
		super(mesg);
	}
}
