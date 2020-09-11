package main;
import tool.DynamicList;

import static java.lang.System.out;

import java.awt.List;
import java.util.ArrayList;
public class Main {
	public static void main(String[] args)
	{
		DynamicList<Integer> list = new DynamicList<>();
		list.add(10);
		list.add(20);
		list.add(30);
		out.println(list);
		list.remove(50);
		out.println(list);
		DynamicList<Integer> tempList = list;
		list.clear();
		out.println(list.equals(tempList));
		out.println(list);
		list.add(5);
		out.println(list);
		ArrayList l = new ArrayList();
		list.clear();
		out.println(list.isEmpty());
		
	}
}
