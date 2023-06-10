package utils;

import java.time.LocalDate;

import static utils.ValidationRules.validateMfgDate;
//import static utils.ValidationRules.validateMfgDate;

import java.util.ArrayList;
import java.util.List;

import com.app.core.Color;
import com.app.core.Vehicle;

import custom_exceptions.InvalidInputException;

public class ShowroomPopulate {
	public static List<Vehicle> populateShowroom() throws InvalidInputException{
//		creating empty arraylist
		List<Vehicle> vehicleAL = new ArrayList<>();
		
		vehicleAL.add(new Vehicle("ak-1141",validateMfgDate("2023-02-03"), 99999, "Honda", true, Color.valueOf("BLUE")));
		vehicleAL.add(new Vehicle("ak-1143",validateMfgDate("2023-01-03"), 554550, "Suzuki", true, Color.valueOf("BLUE")));
		vehicleAL.add(new Vehicle("ak-1142",validateMfgDate("2023-03-03"), 554550, "Honda", true, Color.valueOf("BLUE")));
		vehicleAL.add(new Vehicle("ak-1140",validateMfgDate("2023-03-13"), 554550, "Honda", true, Color.valueOf("RED")));
		vehicleAL.add(new Vehicle("ak-1139",validateMfgDate("2023-04-03"), 554550, "BUG", true, Color.valueOf("WHITE")));
		vehicleAL.add(new Vehicle("ak-1145",validateMfgDate("2023-02-23"), 888, "ASTON", true, Color.valueOf("GREEN")));
		
		
		return vehicleAL;
	}
}