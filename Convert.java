package com.shadow53.libs;

public class Convert {	
	public static double FahrenheitToCelsius(double fahr){
		return (fahr - 32) * (5/9.0);
	}
	
	public static double CelsiusToFahrenheit(double cels){
		return cels * (9/5.0) + 32;
	}
	
	public static int decimalToBase(int num, int base)
	{
		if (base == 10)
		{
			return num;
		}
		String tmp = "";
		
		while(num != 0)
		{
			int rem = num % base;
			tmp += rem;
			num /= base;
		}
		// TODO: Reverse the string
		return (tmp.equals("") ? 0 : Integer.parseInt(tmp));
	}
}
