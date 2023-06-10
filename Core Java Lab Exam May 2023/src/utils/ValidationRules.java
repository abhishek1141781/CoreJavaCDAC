package utils;

import java.time.LocalDate;
import java.util.List;

import com.app.core.Color;
import com.app.core.Vehicle;

import custom_exceptions.InvalidInputException;

public class ValidationRules {
//	the below method can't be private
	public static LocalDate validateMfgDate(String date) throws InvalidInputException{
//		pass a string of type (yyyy-mm-dd) as a string and parse it and store it as a date
		LocalDate enteredDate=LocalDate.parse(date);
		
//		Get the date for the boundary condition which is the current year
		LocalDate currentYear=LocalDate.of(LocalDate.now().getYear()-5, 1, 1);
		
		
//		check if the entered date is after the date mentioned in the boundary condition
		if(currentYear.isAfter(enteredDate)) {
			throw new InvalidInputException("Vehicle manufacured before year"+ currentYear +" are not allowed\n"
					+ currentYear +"is After" +enteredDate);
		}
		return enteredDate;
	}

	public static String checkForDup(List<Vehicle> list,String chasisNo) throws InvalidInputException{
//		search the entered chasisNo in the existing list passed along with the chasisNo
		boolean ifExists=list.contains(new Vehicle(chasisNo));
		
		
		if(ifExists) {
			throw new InvalidInputException("Vehicle already present of the entered chasisNo");
		}
		System.out.println("Vehicle doesn't exist, ADD IT!!!!!!!!");
		return chasisNo;
	}

	public static Color checkColor(String color) {
//		check if the entered color exists in the list of enum constants
//		if correct it returns the entered color, else throws IllegalArgumentException
		return Color.valueOf(color.toUpperCase());
	}
}