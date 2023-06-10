package test_iterators;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Test4 {

	public static void main(String[] args) {
		// Method rets fixed size list => can not modify the list size
		List<Integer> list = Arrays.asList(10, 1, 2, 3, 45, 80, 50, 60);
		ArrayList<Integer> list2=new ArrayList<>(list);
				// Can you attach an Iterator n display the elems ? YES
		Iterator<Integer> itr = list2.iterator();
		while (itr.hasNext()) {	
			System.out.print(itr.next() + " ");			
		}
		System.out.println(itr.next());//NoSuchElementExc

	}

}
