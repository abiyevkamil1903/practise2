package main;
import tool.DynamicList;

public class Main {
	public static void main(String[] args)
	{
		DynamicList<Integer> list = new DynamicList<>(3);
		list.add(10);
		list.add(20);
		list.add(30);
		list.add(40);
		list.add(50).add(60).add(70).add(80).add(90).add(100).add(110);
		list.print();
		
	}
}
