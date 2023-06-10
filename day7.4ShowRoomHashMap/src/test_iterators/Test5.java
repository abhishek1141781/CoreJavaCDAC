package test_iterators;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Test5 {

	public static void main(String[] args) {
		// Method rets fixed size list => can not modify the list size
		List<Integer> list = Arrays.asList(10, 1, 2, 3, 45, 80, 50, 60);
		ArrayList<Integer> list2 = new ArrayList<>(list);
		// Can you attach an Iterator n display the elems ? YES
		Iterator<Integer> itr = list2.iterator();
		list2.add(345);// size modified => structural modification
//		list2.remove(8);

		/*
		 * if structure is kept same even after adding one and deleting back and thus
		 * keep keeping the structure effectively same, still contrary to intuition
		 * there would be a ConcurrentModificationException
		 */
//		list2.add(345);//size modified => structural modification
//		list2.remove(8);

//		list2.set(0,1234);
//		itr = list2.iterator();
		while (itr.hasNext()) {
			System.out.print(itr.next() + " ");
		}

		System.out.println(list2);

	}

}
