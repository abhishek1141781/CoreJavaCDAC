package tester;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import com.app.core.Color;
import com.app.core.Vehicle;

import custom_exceptions.InvalidInputException;
import utils.ShowroomPopulate;
//import utils.ShowroomPopulate.populateShowroom;
//import utils.ShowroomPopulate.populateShowroom;
import utils.ValidationRules;

public class showroomManager {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		try {
			List<Vehicle> showroomVehicleList = ShowroomPopulate.populateShowroom();
			boolean exit = false;

			while (!exit) {
				System.out.println("1. Display all Vehicles\n" + "2. Add new Vehicle\n" + "3. Remove Vehicle\n"
						+ "4. Apply discount if before a certain date\n" + "5. Display specific vehicle details\n"
						+ "6. Sort as per chasisNo\n" + "7. Sort as per base Price\n"
						+ "8. Sort as per date and Price\n" + "9. Sort as per Date\n" + "10. Sort as per Date using Legacy\n"+"0. Exit");

				System.out.println("Choose an option");
				try {
					switch (sc.nextInt()) {
					case 1:
						System.out.println("Displaying list of all vehicles: ");
						for (Vehicle v : showroomVehicleList) {
							System.out.println(v);
						}
						break;

					case 2:
						System.out.println("Enter the new vehicle details: ");
						System.out.println("Enter the chasisNo: ");
						String chasisNo = ValidationRules.checkForDup(showroomVehicleList, sc.next());
//						validating mfg date
						System.out.println("Enter Mfg Date: ");
						LocalDate mfgDate = ValidationRules.validateMfgDate(sc.next());

//						validate color if it exists in showroom
						System.out.println("Enter the color that you want: ");
						Color color = ValidationRules.checkColor(sc.next());

//						calculating final price=base price + additional cost based on the color from the enum
						System.out.println("Enter the base price: ");
						double finalPrice = sc.nextDouble() + color.getAdditionalCost();

//						Enter company name
						System.out.println("Enter comapany name: ");
						String company = sc.next();

						showroomVehicleList.add(new Vehicle(chasisNo, mfgDate, finalPrice, company, exit, color));
						System.out.println("New Vehicle Added!!!!!");
						break;

					case 3:
						System.out.println("Enter the chasisNo of the vehicle to be removed:");
//						remove vehicle with entered chasisNo in our showroom

						String chNO = sc.next();
						if (showroomVehicleList.remove(new Vehicle(chNO))) {
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
						for (Vehicle v : showroomVehicleList) {
							if (v.getManufacturingDate().isBefore(discountDate)) {
								v.setBasePrice(v.getBasePrice() - discountAmt);
							}
						}
						break;

					case 5:// Display specific vehicle details
						System.out.println("Enter the chasis No to get specific details: ");
//						String detailChNo=sc.next();

//						check if the vehicle exists in the list using the chasisNO
						int detailIndex = showroomVehicleList.indexOf(new Vehicle(sc.next()));

						if (detailIndex >= 0) {
							System.out.println(showroomVehicleList.get(detailIndex));
						}
						break;

					case 6://Sort as per chasisNo
						Collections.sort(showroomVehicleList);
						break;

					case 7:// Sort as per base Price
						System.out.println("Custom Sort as per base price:\n");

//						Comparator<Vehicle> lambCustPrice=(p1,p2)->((Double)p1.getBasePrice()).compareTo(p2.getBasePrice());
//						Collections.sort(showroomVehicleList, lambCustPrice);

//						direct lambda
						Collections.sort(showroomVehicleList, (p1,p2)->((Double)p1.getBasePrice()).compareTo(p2.getBasePrice()));
						for(Vehicle v: showroomVehicleList) {
							System.out.println(v);
						}
//						showroomVehicleList.forEach(System.out::println);
//						Collections.sort(showroomVehicleList,new Comparator<Vehicle>() {
//						});

						break;
						
					case 8://Sort as per date and Price
						System.out.println("Compound sorting as per date and price:\n");

						Collections.sort(showroomVehicleList, (p1,p2)->{
						
							if(((Double)p1.getBasePrice()).compareTo(p2.getBasePrice())==0)
								return p1.getManufacturingDate().compareTo(p2.getManufacturingDate());
							else {
								return ((Double)p1.getBasePrice()).compareTo(p2.getBasePrice());
							}
						});
						break;
						
					case 9: //Sort as per Date
						System.out.println("Sorted as per Date: Using Lambda\n");
						Comparator<Vehicle> lambCustDate=(p1,p2) ->p1.getManufacturingDate().compareTo(p2.getManufacturingDate());
						Collections.sort(showroomVehicleList, lambCustDate);
						
						for(Vehicle v: showroomVehicleList) {
							System.out.println(v);
						}
						break;
						
					case 10: //Sort as per Date
						System.out.println("Sorted as per Date: Using Legacy method\n");
//						Comparator<Vehicle> lambCustDate=(p1,p2) ->p1.getManufacturingDate().compareTo(p2.getManufacturingDate());
						Collections.sort(showroomVehicleList, new Comparator<Vehicle>(){
							@Override
							public int compare(Vehicle v1,Vehicle v2) {
//								not compulsory to use compareTo here, we can write manually to handle the three cases
//								but since date is comparable we can directly use compareTo
								return v1.getManufacturingDate().compareTo(v2.getManufacturingDate());
							}
						});
						
						for(Vehicle v: showroomVehicleList) {
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
		} catch (InvalidInputException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}