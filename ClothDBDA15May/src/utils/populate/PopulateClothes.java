package utils.populate;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.app.enumsize.Size;
import com.app.shop.Cloth;

public class PopulateClothes {
	public static List<Cloth> populateClothes(){
		List<Cloth> shopList = new ArrayList<Cloth>();
		shopList.add(new Cloth(LocalDate.of (2023,05,05), LocalDate.of(2023, 05, 15),55, Size.valueOf("X"), 5555));
		
		
		return shopList;
		
	}
}
