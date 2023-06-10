package lists;

//Static has to be used to import the static members, normal import doesn't import static methods
import static utils.ShowroomUtils.populateShowroom;
import static utils.ShowroomUtils.populateShowroomMap;
import static utils.ValidationRules.checkForDup;
import static utils.ValidationRules.validateManufactureDate;
import static utils.ValidationRules.validateVehicleColor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import com.app.core.Color;
import com.app.core.Vehicle;

public class ShowroomManagement {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			// create empty AL to hold Vehicle type of refs
			Map<String,Vehicle> showroom = populateShowroomMap(populateShowroom()); // size=0,init capa=10
			boolean exit = false;

			while (!exit) {
				System.out.println("1. Add a Vehicle\n 2. Display all\n 3. Display specific vehicle details\n"
						+ "4. Apply discount\n 5. Remove specific vehicle details\n "
						+ "6. Sort vehicles as per ch no (asc)\n 7. Sort Vehicles as per desc price\n "
						+ "8. Sort vehicles as per date\n 9. Sort vehicle details , as per date n price\n 0. Exit");
				System.out.println("Choose an option");
				try {
					switch (sc.nextInt()) {
					case 1:

						System.out.println(
								"Enter vehicle details : chasisNo,  vehicleColor,  basePrice,  manufactureDate,  company");
						String chNo = sc.next();
						checkForDup(showroom, chNo);
						// invoke validation rule : color
						Color clr = validateVehicleColor(sc.next());
						double basePrice = sc.nextDouble() + clr.getAdditionalCost();
						LocalDate date = validateManufactureDate(sc.next());
						String company = sc.next();
						// => validation success --so create vehicle object n add it's ref in the array
						showroom.put( chNo, new Vehicle(chNo, clr, basePrice, date, company));
						System.out.println("vehicle added to the showroom!");
						break;
					case 2:
						System.out.println("Showroom details ");
						for (Vehicle v : showroom.values())
							System.out.println(v);// v.toString()
						break;

					case 3:
						// search(PK based) n then retrieve

						System.out.println("Enter ch  no(PK)");
						chNo = sc.next();
//						showroom.get(chNo);
//						Vehicle newVehicle = new Vehicle(chNo);
//						int index = showroom.indexOf(newVehicle);// O(n)
//						if (index == -1)
//							throw new InvalidInputException("Invalid ch no!!!!!!!!");
//						// => vehicle exists
						System.out.println("Details " + showroom.get(chNo));// O(1)
						break;

					case 4:
						System.out.println("Enter date(yr-mon-day) n discount amount");
						date = validateManufactureDate(sc.next());
						double discount = sc.nextDouble();
						for (Vehicle v : showroom.values())
							if (v.getManufactureDate().isBefore(date))
								v.setBasePrice(v.getBasePrice() - discount);
						break;
					case 5:
						System.out.println("Enter ch no , to delete vehicle details");
						String chNo1 = sc.next();
//						index = showroom.indexOf(new Vehicle(sc.next()));
//						if (index == -1) // => not found!
//							throw new InvalidInputException("Invalid ch no , Vehicle details not removed!!!!");
						// vehicle found
						System.out.println("Removed vehicle details " + showroom.remove(chNo1));
						break;
					case 6:
						System.out.println("sorting the vehicle list");
						// API of Collections class
						// public static <T extends Comparable<? super T>> void sort(List<T> list)
//						Collections.sort(showroom.values());
						TreeMap<String,Vehicle> treeMap = new TreeMap<>(showroom);
//						TreeMap<String,Vehicle> treeMap = 
						for(Vehicle v : treeMap.values()) {
							System.out.println(v);
						}
						
						break;
					case 7:
//						System.out.println("soritng the list : desc price");
						System.out.println("soritng the list : desc primary key");
//						ArrayList<Vehicle> al= new ArrayList<Vehicle>(showroom.values());
//						Collections.sort()
//						Collections.sort(al, new Comparator<Vehicle>() {
//							public int Compare(Vehicle o1, Vehicle o2) {
//								return ((Double)o1.getBasePrice()).compareTo(o2.getBasePrice());
//							
//							}});
						
						
//						///////////////////////////////////////////////////
//						System.out.println("sorting the vehicle list in descending order");
//						Comparator<String> descendingComparator = Collections.reverseOrder();
//						TreeMap<String,Vehicle> descendingTreeMap = new TreeMap<>(descendingComparator);
//						descendingTreeMap.putAll(showroom);
//						for(Vehicle v : descendingTreeMap.values()) {
//						    System.out.println(v);
//						}
//						///////////////////////////////////////////////////
						
//						System.out.println("sorting the vehicle list in descending order");
//						Comparator<String> descendingComparator = new Comparator<String>() {
//						    public int compare(String s1, String s2) {
//						        return s2.compareTo(s1);
//						    }
//						};
//						TreeMap<String,Vehicle> descendingTreeMap = new TreeMap<>(descendingComparator);
//						TreeMap<String , Vehicle> treeMap2 = new TreeMap<String, Vehicle>(showroom);
						TreeMap<String , Vehicle> treeMap1 = new TreeMap<String, Vehicle>(new Comparator<String>() {
							public int compare(String s1,String s2)
							{
								return s2.compareTo(s1);
							}
						});
						treeMap1.putAll(showroom);
						for(Vehicle v: treeMap1.values()) {
							System.out.println(v);							
						}
						
//						TreeMap<String, Vehicle> tm = new TreeMap<String, Vehicle>(new Comparator<Vehicle>() {
//
//							@Override
//							public int compare(Vehicle o1, Vehicle o2) {
//
//								return 0;
//							}
//						});

						
//						TreeMap<String, Vehicle> treeMap1 = new TreeMap<>(new Comparator<Vehicle>() {
//						    @Override
//						    public int compare(Vehicle v1, Vehicle v2) {
//						        return v2.getChasisNo().compareTo(v1.getChasisNo());
//						    }
//						});
//
//						treeMap1.putAll(showroom);
//
//						for (Vehicle v : treeMap1.values()) {
//						    System.out.println(v);							
//						}

						
						
						
						
//						TreeMap<String , Vehicle> treeMap1 = new TreeMap<String, Vehicle>(new Comparator<>() {
//							public int compare(Vehicle s1,Vehicle s2)
//							{
//								return s2.getChasisNo().compareTo(s1.getChasisNo());
//							}
//						});
//						treeMap1.putAll(showroom);
//						for(Vehicle v: treeMap1.values()) {
//							System.out.println(v);							
//						}
//}
						break;
						
//						
					case 8:
						System.out.println("soritng the list : date");
						Collections.sort(new ArrayList<Vehicle>(showroom.values()) , new Comparator<Vehicle>() {
							@Override
							public int compare(Vehicle v1, Vehicle v2) {
								System.out.println("inside the compare of date sort");
//								Local Date has inbuild compareTo Method here we can even do by using >,== and<
								return v1.getManufactureDate().compareTo(v2.getManufactureDate());
							}	
						}
						);
						System.out.println("End of case 8");
						break;
					case 9:
						Collections.sort(new ArrayList<Vehicle>(showroom.values()) , new Comparator<Vehicle>() {

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
						System.out.println("\nPrinting the sorted list\n");
						showroom.values();
						for(Vehicle v: showroom.values()) {
							System.out.println(v);		
						}
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
