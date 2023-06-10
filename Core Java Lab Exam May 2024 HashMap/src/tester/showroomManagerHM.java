package tester;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import com.app.core.ColorHM;
import com.app.core.VehicleHM;

import custom_exceptions.InvalidInputExceptionHM;

import utils.ShowroomPopulateHM;
//import static utils.ShowroomPopulateHM.*;
//import utils.ShowroomPopulate.populateShowroom;
import utils.ValidationRulesHM;

public class showroomManagerHM {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		try {
			Map<String,VehicleHM> showroomVehicleMap = ShowroomPopulateHM.populateShowroomHM(ShowroomPopulateHM.populateShowroom());
			for (Object obj : showroomVehicleMap.keySet()) {
				System.out.println(showroomVehicleMap.get(obj));
			}
			boolean exit = false;
			

			while (!exit) {
				System.out.println("1. Display all Vehicles\n" + "2. Add new Vehicle\n" + "3. Remove Vehicle\n"
						+ "4. Apply discount if before a certain date\n" + "5. Display specific vehicle details\n"
						+ "6. Sort as per chasisNo\n" + "7. Sort as per base Price\n"
						+ "8. Sort as per date and Price\n" + "9. Sort as per Date\n" + "10. Sort as per Date using Legacy\n"+"0. Exit"+"\n80. CPT Sort as per date and Price");

				System.out.println("Choose an option");
				try {
					switch (sc.nextInt()) {
					case 1:
//						System.out.println("Displaying list of all vehicles: ");
//						for (VehicleHM v : showroomVehicleMap.values()) {
//							System.out.println(v);
//						}
//						break;
						System.out.println("Displaying list of all vehicles: ");
						for (Object obj : showroomVehicleMap.keySet()) {
							System.out.println(showroomVehicleMap.get(obj));
						}
						break;

					case 2:
						System.out.println("Enter the new vehicle details: ");
						System.out.println("Enter the chasisNo: ");
						String mapChasisNO=sc.next();
//						String chasisNo = ValidationRulesHM.checkForDup(showroomVehicleMap, sc.next());
//						validating mfg date
						System.out.println("Enter Mfg Date: ");
						LocalDate mfgDate = ValidationRulesHM.validateMfgDate(sc.next());

//						validate color if it exists in showroom
						System.out.println("Enter the color that you want: ");
						ColorHM color = ValidationRulesHM.checkColor(sc.next());

//						calculating final price=base price + additional cost based on the color from the enum
						System.out.println("Enter the base price: ");
						double finalPrice = sc.nextDouble() + color.getAdditionalCost();

//						Enter company name
						System.out.println("Enter comapany name: ");
						String company = sc.next();

						showroomVehicleMap.putIfAbsent(mapChasisNO, new VehicleHM(mapChasisNO, mfgDate, finalPrice, company, exit, color));
						System.out.println("New Vehicle Added!!!!!");
						
//						for map no validations required for chasisNo
						
						
						break;

					case 3:
						System.out.println("Enter the chasisNo of the vehicle to be removed:");
//						remove vehicle with entered chasisNo in our showroom

						String chNO = sc.next();
						if (showroomVehicleMap.remove(chNO) != null) {
							System.out.println("Entered vehicle with chasisNo " + chNO + " is removed");
						}
						else
							System.out.println("Entered Vehicle with the chasis No doesn't exist");
						break;

					case 4:// Apply discount if before a certain date
						System.out.println(
								"Enter the date(yyyy-mm-dd) and discount before which all vehicles will get a discount: ");
						LocalDate discountDate = LocalDate.parse(sc.next());
						double discountAmt = sc.nextDouble();
//						for all vehicles whose mfg date comes before the discountDate, discount is to be applied
//						get mfg date of vehicles
						for (VehicleHM v : showroomVehicleMap.values()) {
							if (v.getManufacturingDate().isBefore(discountDate)) {
								v.setBasePrice(v.getBasePrice() - discountAmt);
							}
						}
						break;

					case 5:// Display specific vehicle details
						System.out.println("Enter the chasis No to get specific details: ");
//						String detailChNo=sc.next();

//						check if the vehicle exists in the list using the chasisNO
//						int detailIndex = showroomVehicleList.indexOf(new VehicleHM(sc.next()));
						
//						becomes this
//						showroomVehicleMap.get(sc.next())

						if (showroomVehicleMap.get(sc.next()) != null) {
							System.out.println(showroomVehicleMap.get(sc.next()));
						}
						break;

					case 6://Sort as per chasisNo
//						Collections.sort(showroomVehicleMap.values());
//						Create a empty treemap, store the date from hasmap to it and then print it
						Map<String,VehicleHM> sortedMap=new TreeMap<>(showroomVehicleMap);
						for(VehicleHM sm:sortedMap.values()) {
							System.out.println(sm);
						}
						break;

					case 7:// Sort as per base Price
						System.out.println("Custom Sort as per base price:\n");

//						Comparator<Vehicle> lambCustPrice=(p1,p2)->((Double)p1.getBasePrice()).compareTo(p2.getBasePrice());
//						Collections.sort(showroomVehicleList, lambCustPrice);

//						direct lambda
//						Collections.sort(showroomVehicleList, (p1,p2)->((Double)p1.getBasePrice()).compareTo(p2.getBasePrice()));
						List<VehicleHM> listBasePrice = new ArrayList<>(showroomVehicleMap.values());
						Collections.sort(listBasePrice, (p1,p2)->((Double)p1.getBasePrice()).compareTo(p2.getBasePrice()));
						
						for(VehicleHM v: listBasePrice) {
							System.out.println(v);
						}
//						showroomVehicleList.forEach(System.out::println);
//						Collections.sort(showroomVehicleList,new Comparator<Vehicle>() {
//						});

						break;
						
					case 8://Sort as per date and Price
						System.out.println("Compound sorting as per date and price:\n");
						
						List<VehicleHM> listDatePrice = new ArrayList<>(showroomVehicleMap.values());
						Collections.sort(listDatePrice, (p1,p2)->{
						
							if(((Double)p1.getBasePrice()).compareTo(p2.getBasePrice())==0)
								return p1.getManufacturingDate().compareTo(p2.getManufacturingDate());
							else {
								return ((Double)p1.getBasePrice()).compareTo(p2.getBasePrice());
							}
						});
						
						for(VehicleHM v: listDatePrice) {
							System.out.println(v);
						}
						break;
//=================================================
					case 80:

						TreeMap<String, VehicleHM> sortedShowroomVehicleMap = new TreeMap<>((vehicleId1, vehicleId2) -> {
						    VehicleHM vehicle1 = showroomVehicleMap.get(vehicleId1);
						    VehicleHM vehicle2 = showroomVehicleMap.get(vehicleId2);
						    if (vehicle1.getBasePrice() == vehicle2.getBasePrice()) {
						        return vehicle1.getManufacturingDate().compareTo(vehicle2.getManufacturingDate());
						    } else {
						        return Double.compare(vehicle1.getBasePrice(), vehicle2.getBasePrice());
						    }
						});
						sortedShowroomVehicleMap.putAll(showroomVehicleMap);
						break;

//=================================================

					case 9: //Sort as per Date
						System.out.println("Sorted as per Date: Using Lambda\n");
						
						List<VehicleHM> listDatePointer = new ArrayList<>(showroomVehicleMap.values());
						Comparator<VehicleHM> lambCustDate=(p1,p2) -> p1.getManufacturingDate().compareTo(p2.getManufacturingDate());
						Collections.sort(listDatePointer, lambCustDate);

						for(VehicleHM v: listDatePointer) {
							System.out.println(v);
						}
						break;
						
					case 10: //Sort as per Date
						System.out.println("Sorted as per Date: Using Legacy method\n");
//						Comparator<Vehicle> lambCustDate=(p1,p2) ->p1.getManufacturingDate().compareTo(p2.getManufacturingDate());
						List<VehicleHM> listDateLegacyPointer = new ArrayList<>(showroomVehicleMap.values());

						Collections.sort(listDateLegacyPointer, new Comparator<VehicleHM>(){
							@Override
							public int compare(VehicleHM v1,VehicleHM v2) {
//								not compulsory to use compareTo here, we can write manually to handle the three cases
//								but since date is comparable we can directly use compareTo
								return v1.getManufacturingDate().compareTo(v2.getManufacturingDate());
							}
						});
						
						for(VehicleHM v: listDateLegacyPointer) {
							System.out.println(v);
						}
						
						break;
					
						
						
						
					default:
						break;
					}

				} catch (Exception e) {
					e.printStackTrace();
					// read off all pending tokens from the scanner
//					The catch block prints the stack trace of the exception and reads off any remaining tokens from the scanner to prevent any possible errors in future input, if an exception occurs while reading a line mid way, some tokens are not read by that scanner instance and thus those tokens would remain on the screen that would be read off by the next scanner instance unintentionally and thus cause undefined and unwanted behavior
					sc.nextLine();
				}

			}
		} catch (InvalidInputExceptionHM e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}