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
		list.add(10);
		list.add(10);
		list.add(10);
		list.add(20);
		list.add(30);
		list.add(20);
		out.println(list);
		out.println("10: " + list.count(10));
		out.println("20: " + list.count(20));
		out.println("30: " + list.count(30));
	}
}
