package libs;

public class Numbers {
	/**
	 * Converts a string to an integer
	 * @param str A string representation of an integer
	 * @return int The integer representation of the string. Returns Integer.MIN_VALUE if the string could not be converted to an integer.
	 */
	public static int toInt(String str){
		try {
			int myInt;
			if (str == "") {
				myInt = 0;
			}
			else {
				myInt = Integer.parseInt(str);
			}
			return myInt;
		}
		catch (NumberFormatException e) {
			IO.Print("Error: Could not parse string as an Integer");
		}
		return Integer.MIN_VALUE;
	}
	
	/**
	 * Converts a string to an integer
	 * @param dbl A double to convert to an integer
	 * @return int The integer representation of the string. Returns Integer.MIN_VALUE if the string could not be converted to an integer.
	 */
	public static int toInt(double dbl){
		try {
			int myInt = (int)dbl;
			return myInt;
		}
		catch (NumberFormatException e) {
			IO.Print("Error: Could not parse double as an Integer");
		}
		return Integer.MIN_VALUE;
	}
	
	public static double toDouble(String str){
		try {
			double dbl = Double.parseDouble(str);
			return dbl;
		}
		catch (NumberFormatException e) {
			IO.Print("Error: Could not parse string as a Double");
		}
		return Double.NEGATIVE_INFINITY;
	}
}
