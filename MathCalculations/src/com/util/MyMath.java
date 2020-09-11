package com.util;

import java.util.*;
import java.math.BigInteger;

public class MyMath 
{
	public static int gcd(int a, int b) 
	{
		if(a == 0) return b;
        if(b == 0) return a;
        
		int min = java.lang.Math.min(a, b);
		int max = (a + b) - min;
		
		while(true)
		{
			if(max % min == 0)
				return min;
			
			int temp = max % min;
			max = min;
			min = temp;
		}
		
	}
	
	
	public static int gcd(int[] elements)
	{
		int result = 0;

        for(int element : elements){
            result = gcd(result, element);

            if(result == 1)
                return 1;
        }
        return result;
	}
	
	public static int lcm(int a, int b)
	{
		return (a * b) / (gcd(a,b));
	}
	
	public static int lcm(int[] elements)
	{
        int result = elements[0];
        
        for(int i = 1; i < elements.length; i++)
            result = lcm(result, elements[i]);

        return result;
    }
	
	
	public static long sum(int[] elements)
	{
		long sum = 0;
		for(int element : elements)
		{
			sum += element;
		}
		return sum;
	}
	
	public static long sum(List<Integer> elements)
	{
		long sum = 0;
		for(Integer  element : elements)
		{
			sum += element;
		}
		return sum;
	}
	
	
	public static int min(int a, int b)
	{
		return (a < b) ? a : b;
	}
	
	public static int max(int a, int b)
	{
		return (a > b) ? a : b;
	}
	
	public static long min(long a, long b)
	{
		return (a < b) ? a : b;
	}
	
	public static long max(long a, long b)
	{	
		return (a > b) ? a : b;
	}
	
	public static int max(int[] elements)
	{
		int max = Integer.MAX_VALUE;
		for(int elementValue : elements)
		{
			if(elementValue > max)
				max = elementValue;
		}
		return max;
	}
	
	
	public static int count(int value, int[] elements)
	{
		int counter = 0;
		for(int element : elements)
		{
			if (element == value)
				counter++;
		}
		return counter;
	}
	
	public static int count(double value, double[] elements)
	{
		int counter = 0;
		for(double element : elements)
		{
			if (element == value)
				counter++;
		}
		return counter;
	}
	
	public static int countMax(int[] elements)
	{
		int counter = 0;
		int max = Integer.MAX_VALUE; // autoboxing
		
		for(int element : elements)
		{
			if(element > max)
			{
				counter = 1;
				max = element;
			}
			else if (element == max)
				counter++;
		}
		return counter;
		
	}
	
	public static int countMin(int[] elements)
	{
		int counter = 0;
		int min = Integer.MAX_VALUE; 
		
		for(int element : elements)
		{
			if(element < min)
			{
				counter = 1;
				min = element;
			}
			else if (element == min)
				counter++;
		}
		return counter;
	}
	
	public static int abs(int value)
	{
		return (value < 0) ? -value : value;
	}
	public static double abs(double value)
	{
		return (value < 0) ? -value : value;
	}
	public static long abs(long value)
	{
		return (value < 0) ? -value : value;
	}
	
	public static boolean isEven(int value)
	{
		return (value % 2 == 0) ? true : false;
	}
	public static boolean isEven(double value)
	{
		return (value % 2 == 0) ? true : false;
	}
	public static boolean isEven(long value)
	{
		return (value % 2 == 0) ? true : false;
	}
	
	public static boolean isPrime(int value)
	{
		for(int i = 2; i <= Math.sqrt((double)value); i++)
		{
			if(value % i == 0)
				return false;
		}
		return true;
	}
	
	public static int randint(int min, int max)
	{
		return (int)((Math.random() * max) + min);
	}
	
	
	
	
	public static int romanToInteger(String s)
	{
		Map<Character, Integer> map = new HashMap<>();
		
		map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        
		int result = 0;
        for(int i = 0; i < s.length(); i++){
            if(i > 0 && map.get(s.charAt(i)) > map.get(s.charAt(i - 1)))
            {
                result += map.get(s.charAt(i)) - 2 * map.get(s.charAt(i - 1));
            }else{
                result += map.get(s.charAt(i));
            }
            
        }
        return result;
	}
	
	
	
	public static String toRomanNumeral(int number){
		Map<Character, Integer> map = new HashMap<>();
		
		map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        
        String result = "";
        while(number > 0){
            if(number >= 1000){
                result = result.concat("M");
                number -= 1000;
            }else if(number < 1000 && number >= 100){
                if(number >= 900)
                {
                    result = result.concat("CM");
                    number -= 900;
                }
                else if(number >= 500 && number < 900)
                {
                    result = result.concat("D");
                    number -= 500;
                }
                else if(number < 500 && number >= 400)
                {
                    result = result.concat("CD");
                    number -= 400;
                }
                else
                {
                    result = result.concat("C");
                    number -= 100;
                }
            }else if (number < 100 && number >= 10){
                if(number >= 90)
                {
                    result = result.concat("XC");
                    number -= 90;
                }
                else if(number >= 50 && number < 90)
                {
                    result = result.concat("L");
                    number -= 50;
                }
                else if(number < 50 && number >= 40)
                {
                    result = result.concat("XL");
                    number -= 40;
                }
                else
                {
                    result = result.concat("X");
                    number -= 10;
                }
            } else{
                if(number == 9)
                {
                    result = result.concat("IX");
                    number -= 9;
                }
                else if(number >= 5 && number < 9)
                {
                    result = result.concat("V");
                    number -= 5;
                }
                else if(number == 4)
                {
                    result = result.concat("IV");
                    number -= 4;
                }
                else
                {
                    result = result.concat("I");
                    number -= 1;
                }
            }
        }
        return result;
    }
	
	public static double nRoot(double number, int degree)
	{
		return Math.pow(number, 1.0 / degree);
	}
	
	static BigInteger factorial(BigInteger bigint){
        if(bigint.equals(BigInteger.ZERO))
            return BigInteger.ONE;
        return bigint.multiply(factorial(bigint.subtract(BigInteger.ONE)));
    }
	
	public static BigInteger factorial(String n)
	{
		return factorial(new BigInteger(n));
	}
	
	
	
	
	
}
