package utils;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import com.app.core.ColorHM;
import com.app.core.VehicleHM;

import custom_exceptions.InvalidInputExceptionHM;

public class ValidationRulesHM {
//	the below method can't be private
	public static LocalDate validateMfgDate(String date) throws InvalidInputExceptionHM{
//		pass a string of type (yyyy-mm-dd) as a string and parse it and store it as a date
		LocalDate enteredDate=LocalDate.parse(date);
		
//		Get the date for the boundary condition which is the current year
		LocalDate currentYear=LocalDate.of(LocalDate.now().getYear()-5, 1, 1);
		
		
//		check if the entered date is after the date mentioned in the boundary condition
		if(currentYear.isAfter(enteredDate)) {
			throw new InvalidInputExceptionHM("Vehicle manufacured before year"+ currentYear +" are not allowed\n"
					+ currentYear +"is After" +enteredDate);
		}
		return enteredDate;
	}

//	change from List to map
//	change from contains to containsKey
//	change from singleCOnstructor to direct passing String
	public static String checkForDup(Map<String,VehicleHM> map,String chasisNo) throws InvalidInputExceptionHM{
//		search the entered chasisNo in the existing list passed along with the chasisNo
		boolean ifExists=map.containsKey(chasisNo);
		
		
		if(ifExists) {
			throw new InvalidInputExceptionHM("Vehicle already present of the entered chasisNo");
		}
		System.out.println("Vehicle doesn't exist, ADD IT!!!!!!!!");
		return chasisNo;
	}

	public static ColorHM checkColor(String color) {
//		check if the entered color exists in the list of enum constants
//		if correct it returns the entered color, else throws IllegalArgumentException
		return ColorHM.valueOf(color.toUpperCase());
	}
}