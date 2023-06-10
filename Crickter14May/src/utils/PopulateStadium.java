package utils;

import java.util.ArrayList;
import java.util.List;

import com.app.stadium.Crickter14May;

public class PopulateStadium {
	public static List<Crickter14May> populateStadium(){
		List<Crickter14May> stadList = new ArrayList<>();
		
		stadList.add(new Crickter14May("Sachin", 40, "sach@gmail.com", "2154789865", 8));
		stadList.add(new Crickter14May("Ganguly", 36, "gang@gmail.com", "2132453265", 9));
		stadList.add(new Crickter14May("Dhoni", 39, "dhoni@gmail.com", "3265458721", 9));
		stadList.add(new Crickter14May("Pant", 29, "pant@gmail.com", "216543232", 6));
		stadList.add(new Crickter14May("Shami", 39, "shami@gmail.com", "989897852", 7));
		return stadList;
	}
}
