package test_iterators;

import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

public class Test6 {

	public static void main(String[] args) {
		// Method rets fixed size list => can not modify the list size
		List<Integer> list = Arrays.asList(10, 1, 2, 3, 45, 80, 50, 60);
		//display elements in reverse order
		ListIterator<Integer> litr=list.listIterator(list.size());
		System.out.println("Printing the list in reverse order : ");
		while(litr.hasPrevious())
			System.out.print(litr.previous()+"  ");
	
		

	}

}
