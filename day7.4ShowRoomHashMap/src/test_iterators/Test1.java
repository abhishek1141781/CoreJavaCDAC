package test_iterators;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Test1 {

	public static void main(String[] args) {
		//Method rets fixed size list => can not modify the list size
		List<Integer> list=Arrays.asList(10,1,2,3,45,80,50);
		System.out.println("list contents "+list);
	//list.add(100);
	//	list.remove(0);
		list.set(0,9999);
		System.out.println(list);
		LinkedList<Integer> list2=new LinkedList<>(list);
		list2.addLast(111);
		System.out.println(list2);
		//Can you attach an Iterator n display the elems ? YES
		Iterator<Integer> itr=list2.iterator();
		while(itr.hasNext())
			System.out.print(itr.next()+"<==>");

	}

}
