package main;
import tool.DynamicList;

import static java.lang.System.out;
public class Main {
	public static int[] returnArray() {
		return new int[] {1,2,3,4,5};
	}
	public static void main(String[] args)
	{	
		DynamicList<Integer> list = new DynamicList<>();
		list.add(10);
		list.add(20);
		list.add(30);
		list.add(40);
		list.add(10);
		list.add(50);
		list.add(60);
		out.println(list);
//		out.println(list.indexOf(10));
//		out.println(list.lastIndexOf(10));
//		out.println(list.last());
//		list.removeLast();
//		out.println(list);
//		out.println(list.count(10));
//		out.println(list.reversed());
//		//list.clear();
//		out.println(list.isNotEmpty());
		list.insert(1, 5);
		out.println("5 added to 1st index " + list);
		list.insert(0, 90);
		out.println("90 added to index 0 " + list);
		DynamicList<Integer> list2 = new DynamicList<>();
		list2.add(90);
		list2.add(10);
		list2.add(5);
		list2.add(20);
		list2.add(30);
		list2.add(40);
		list2.add(10);
		list2.add(50);
		list2.add(60);
		
		boolean isEqual = list.equals(list2);
		out.println(isEqual);
		list.removeAt(4);
		out.println(list.equals(list2));
	}
}
