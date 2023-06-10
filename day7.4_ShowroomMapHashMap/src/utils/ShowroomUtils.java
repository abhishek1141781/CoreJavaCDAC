package utils;

import static utils.ValidationRules.validateManufactureDate;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.app.core.Color;
import com.app.core.Vehicle;

import custom_exceptions.InvalidInputException;

public class ShowroomUtils {
// Add a static method to return populated list(sample hard coded data) of vehicles
	public static List<Vehicle> populateShowroom() throws InvalidInputException
	{
		List<Vehicle> vehicles=new ArrayList<>();
		//String chasisNo, Color vehicleColor, double basePrice, LocalDate manufactureDate, String company
		vehicles.add(new Vehicle("abc-12322", Color.BLACK ,455,validateManufactureDate("2023-03-20"),"Honda"));
		vehicles.add(new Vehicle("abc-12340", Color.WHITE ,44,validateManufactureDate("2023-03-20"),"Maruti"));
		vehicles.add(new Vehicle("abc-12342", Color.WHITE ,2,validateManufactureDate("2023-03-20"),"Honda"));
		vehicles.add(new Vehicle("abc-12345", Color.SILVER ,4467,validateManufactureDate("2023-01-10"),"Ford"));
		vehicles.add(new Vehicle("abc-12344", Color.WHITE ,49678,validateManufactureDate("2023-02-21"),"Honda"));
		vehicles.add(new Vehicle("abc-12343", Color.RED ,526789,validateManufactureDate("2023-01-10"),"Maruti"));
		return vehicles;
	}

	public static Map<String, Vehicle> populateShowroomMap(List<Vehicle> list){
		Map<String, Vehicle> hashMap = new HashMap<>();
//		hashMap.putAll(list);
		for(Vehicle v : list) {
			hashMap.put(v.getChasisNo(), v);
		}
		return hashMap;
	}

}
	
	
