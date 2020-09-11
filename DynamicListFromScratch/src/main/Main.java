package main;
import tool.DynamicList;

import static java.lang.System.out;
public class Main {
	public static void main(String[] args)
	{
		DynamicList<Integer> list = new DynamicList<>();
		list.add(10);
		list.add(20);
		list.add(30);
		out.println(list);
		list.remove(30);
		out.println(list);
		out.println(list.indexOf(20));
		
	}
}
