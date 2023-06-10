package utils;

import java.time.LocalDate;

import static utils.ValidationRulesHM.validateMfgDate;
//import static utils.ValidationRules.validateMfgDate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.app.core.ColorHM;
import com.app.core.VehicleHM;

import custom_exceptions.InvalidInputExceptionHM;

public class ShowroomPopulateHM {
	public static List<VehicleHM> populateShowroom() throws InvalidInputExceptionHM{
//		creating empty arraylist
		List<VehicleHM> vehicleAL = new ArrayList<>();
		
		vehicleAL.add(new VehicleHM("ak-1141",validateMfgDate("2023-02-03"), 754550, "Honda", true, ColorHM.valueOf("BLUE")));
		vehicleAL.add(new VehicleHM("ak-1143",validateMfgDate("2023-01-03"), 854550, "Suzuki", true, ColorHM.valueOf("BLUE")));
		vehicleAL.add(new VehicleHM("ak-1142",validateMfgDate("2023-01-03"), 754550, "Honda", true, ColorHM.valueOf("BLUE")));
		vehicleAL.add(new VehicleHM("ak-1140",validateMfgDate("2023-03-13"), 454550, "Honda", true, ColorHM.valueOf("RED")));
		vehicleAL.add(new VehicleHM("ak-1139",validateMfgDate("2023-04-03"), 654550, "BUG", true, ColorHM.valueOf("WHITE")));
		vehicleAL.add(new VehicleHM("ak-1145",validateMfgDate("2023-02-23"), 888, "ASTON", true, ColorHM.valueOf("GREEN")));
		
		return vehicleAL;
	}
//	don't define new object `new HashMap<>()`. This is a method
//	public static Map<String, VehicleHM> populateShowroomHM=new HashMap<>() {
	public static Map<String, VehicleHM> populateShowroomHM(List<VehicleHM> list){
//		Create empty Map
		Map<String,VehicleHM> showroomHM= new HashMap<>();
//		iterate over the list and put all values of list in reference of Map type
		for(VehicleHM v:list) {
			showroomHM.put(v.getChasisNo(), v);
		}
		return showroomHM;
	}
}