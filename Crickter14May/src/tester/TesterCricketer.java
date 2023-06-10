package tester;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import com.app.stadium.Crickter14May;

import utils.PopulateStadium;
import utils.ValidationRules;

public class TesterCricketer {
	public TesterCricketer() {
		try(Scanner sc = new Scanner(System.in)){
			List<Crickter14May> cricketerList = PopulateStadium.populateStadium();
			boolean exit=false;
			
			while(!exit) {
				try {
					System.out.println("1.Accept minimum 5 Cricketers in the collection\n"
							+ "2.Modify Cricketer's rating\n"
							+ "3.Search Cricketer by name\n"
							+ "4.Display all Cricketers added in collection\n"
							+ "5.Display All Cricketers in sorted form by rating\n");
					switch (sc.nextInt()) {
//					case 1:
//						
//						break;

					case 2://Modify Cricketer's rating
						System.out.println("Modifying rating of cricketer: ");
						
//						getting record from list
						System.out.println("Enter cricketer's name: ");
						String cricName=sc.next();
						Crickter14May cricRef = ValidationRules.objectGetter(cricketerList,cricName);
						
						int changeRating = sc.nextInt();
						ValidationRules.verifyRating(changeRating);
						cricRef.setRating(changeRating);
						break;
						
					case 3://Search Cricketer by name
						System.out.println("Search Cricketer by name: ");
						System.out.println("Enter cricketer's name: ");
						String cricNameSearch=sc.next();
						Crickter14May cricNameRef = ValidationRules.objectGetter(cricketerList,cricNameSearch);
						System.out.println(cricNameRef);
						break;
						
					case 4://Display all
						System.out.println("Display all cricketers: ");
						for(Crickter14May c: cricketerList) {
							System.out.println(c);
						}
						
						break;
						
					case 5://Display All Cricketers in sorted form by rating
						System.out.println("Display All Cricketers in sorted form by rating: ");
						Collections.sort(cricketerList, new Comparator<Crickter14May>() {

							@Override
							public int compare(Crickter14May o1, Crickter14May o2) {
								return ((Integer)(o1.getRating())).compareTo(o2.getRating());
							}
							
						});
						
//						for(Crickter14May c : cricketerList) {
//							System.out.println(c);
//						}
						break;
						
					default:
						break;
					}
				
				}catch (Exception e) {
					e.printStackTrace();
					sc.nextLine();
				}
			} 
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
		
		
	}
}
