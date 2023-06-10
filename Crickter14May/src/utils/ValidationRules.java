package utils;

import java.util.List;

import com.app.stadium.Crickter14May;

import custom_exception.InvalidInputException;

public class ValidationRules {
	public static void checkPhone(String phone) throws InvalidInputException {
		if(phone.length()!=10) {
			throw new InvalidInputException("Entered phone number is not of length 10");
		}
	}
	
	public static Crickter14May objectGetter(List<Crickter14May> list, String name) {
		Crickter14May nameRef= list.get(list.indexOf(new Crickter14May(name)));
		return nameRef;
	}
	
	public static void verifyRating(int rating) throws InvalidInputException {
		if(rating<0 || rating>10) {
			throw new InvalidInputException("Rating should be within 1 to 10");
		}
	}
	
	
	
//	public static void
//	public static void
//	public static void
//	public static void
//	public static void
}
