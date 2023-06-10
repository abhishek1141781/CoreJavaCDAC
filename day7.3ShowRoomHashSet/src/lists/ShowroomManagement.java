package lists;

import static utils.ShowroomUtils.populateShowroom;
import static utils.ValidationRules.checkForDup;
import static utils.ValidationRules.validateManufactureDate;
import static utils.ValidationRules.validateVehicleColor;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import com.app.core.Color;
import com.app.core.Vehicle;

import custom_exceptions.InvalidInputException;
import custom_ordering.VehiclePriceComparator;

public class ShowroomManagement {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			// create empty AL to hold Vehicle type of refs
			Set<Vehicle> showroom = populateShowroom(); // size=0,init capa=10
			boolean exit = false;

			while (!exit) {
				System.out.println("1. Add a Vehicle 2. Display all 3. Display specific vehicle details"
						+ "4. Apply discount 5. Remove specific vehicle details "
						+ "6. Sort vehicles as per ch no (asc) 7. Sort Vehicles as per desc price "
						+ "8. Sort vehicles as per date 9. Sort vehicle details , as per date n price 0. Exit");
				System.out.println("Choose an option");
				try {
					switch (sc.nextInt()) {
					case 1:

						System.out.println(
								"Enter vehicle details : chasisNo,  vehicleColor,  basePrice,  manufactureDate,  company");
						String chNo = sc.next();
//						checkForDup(showroom, chNo);
						// invoke validation rule : color
						Color clr = validateVehicleColor(sc.next());
						double basePrice = sc.nextDouble() + clr.getAdditionalCost();
						LocalDate date = validateManufactureDate(sc.next());
						String company = sc.next();
						// => validation success --so create vehicle object n add it's ref in the array
						showroom.add(new Vehicle(chNo, clr, basePrice, date, company));
						System.out.println("vehicle added to the showroom!");
						break;
					case 2:
						System.out.println("Showroom details ");
						for (Vehicle v : showroom)
							System.out.println(v);// v.toString()
						break;

					case 3:
						// search(PK based) n then retrieve

						System.out.println("Enter ch  no(PK)");
						chNo = sc.next();
						Vehicle newVehicle = new Vehicle(chNo);
						
						int index = showroom.indexOf(newVehicle);// O(n)
						if (index == -1)
							throw new InvalidInputException("Invalid ch no!!!!!!!!");
						// => vehicle exists
						System.out.println("Details " + showroom.get(index));// O(1)
						break;

					case 4:
						System.out.println("Enter date(yr-mon-day) n discount amount");
						date = validateManufactureDate(sc.next());
						double discount = sc.nextDouble();
						for (Vehicle v : showroom)
							if (v.getManufactureDate().isBefore(date))
								v.setBasePrice(v.getBasePrice() - discount);
						break;
					case 5:
						System.out.println("Enter ch no , to delete vehicle details");
						index = showroom.indexOf(new Vehicle(sc.next()));
						if (index == -1) // => not found!
							throw new InvalidInputException("Invalid ch no , Vehicle details not removed!!!!");
						// vehicle found
						System.out.println("Removed vehicle details " + showroom.remove(index));
						break;
					case 6:
						System.out.println("sorting the vehicle list");
						// API of Collections class
						// public static <T extends Comparable<? super T>> void sort(List<T> list)
						Collections.sort(showroom);
						break;
					case 7:
						System.out.println("soritng the list : desc price");
						Collections.sort(showroom, new VehiclePriceComparator());
						break;
						
//						
					case 8:
						System.out.println("soritng the list : date");
						Collections.sort(showroom, new Comparator<Vehicle>() {
							@Override
							public int compare(Vehicle v1, Vehicle v2) {
//								Local Date has inbuild compareTo Method here we can even do by using >,== and<
//								
								return v1.getManufactureDate().compareTo(v2.getManufactureDate());
							}
						}

						);

						break;
					case 9:
						Collections.sort(showroom, new Comparator<Vehicle>() {

							@Override
							public int compare(Vehicle o1, Vehicle o2) {
								System.out.println("in anonyomous inner class : date n price");
								int ret=o1.getManufactureDate().compareTo(o2.getManufactureDate());
								if(ret == 0)
								{
									//date same --so compare price
									return ((Double)o1.getBasePrice()).compareTo(o2.getBasePrice());
//									return (o1.getBasePrice()).compareTo(o2.getBasePrice());
								}
								return ret;
							}
						});
						break;
					case 0:
						exit = true;
						break;

					}
				} catch (Exception e) {
					e.printStackTrace();
					// read off all pending tokens from the scanner
					sc.nextLine();
				}
			}

		} catch (Exception e) { // outer catch-all
			e.printStackTrace();
		}

	}

}
