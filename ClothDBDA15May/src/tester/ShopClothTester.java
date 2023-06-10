package tester;

import java.util.List;
import java.util.Scanner;

import com.app.shop.Cloth;

import utils.populate.PopulateClothes;

public class ShopClothTester {
	public static void main(String[] args) {
//		opening try with resources block
		try(Scanner sc = new Scanner(System.in)){
//			populating an empty AL using the populate utils method
			List<Cloth> clothList = PopulateClothes.populateClothes(); //size 0; init capacity=10
			boolean exit=false;
			
			while(!exit) {
				System.out.println("0. Display all Clothes\n"
											   + "1. Add new Cloth\n"
											   + "2. Update stock of cloth\n"
											   + "3. Display clothes having size Z\n"
											   + "4. Display clothes which are out of stock\n"
											   + "5. Remove clothes which are out of stock for 3 months");
				System.out.println("Choose an option");
//				enclosing switch case in a try catch block
				try {
					switch (sc.nextInt()) {
					case 0:
						System.out.println("Displaying all clothes: ");
						clothList.forEach(i->System.out.println(i));
						break;
					
					case 1:
						System.out.println("");

					default:
						break;
					}
					
					
					
					
					
					
					
					
					
					
					
					
					
				} catch (Exception e) {
					e.printStackTrace();
//					read off all pending tokens from the scanner
					sc.nextLine();
				}
				
			}
		}
	}
}
