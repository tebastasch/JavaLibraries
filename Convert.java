package com.shadow53.libs;

public class Convert {	
	public static double FahrenheitToCelsius(double fahr){
		return (fahr - 32) * (5/9.0);
	}
	
	public static double CelsiusToFahrenheit(double cels){
		return cels * (9/5.0) + 32;
	}
	
	/**@param "num" number to convert
	 * @param "base" base to convert to
	 * @return "num" in base "base"
	 */

	public static int decimalToBase(int num, int base){
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
		tmp = reverseStr(tmp);
		return (tmp.equals("") ? 0 : Integer.parseInt(tmp));
	}
	
	/**@param str String to be reversed
	 * @return reversed String
	 */

	public static String reverseStr(String str){
		char [] tmp = str.toCharArray();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < tmp.length; i++) {
			sb.append(tmp[tmp.length - 1 - i]);
		}
		return sb.toString();
	}
	
}
