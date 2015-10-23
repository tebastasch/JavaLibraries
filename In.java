package libs;

import java.util.Scanner;

public class In {
private static Scanner scanner = new Scanner(System.in);
	
	/**
	 * Gets a line of input from the user
	 * @return String The line of input provided be the user
	 */
	private static String Input(){
		String str;
		if (scanner.hasNextLine()){
			str = scanner.nextLine();
		}
		else {
			str = "";
		}
		
		return str;
	}
	
	/**
	 * Waits for the user to press enter. This halts the program until the user presses enter.
	 * If anything is typed, it is not saved.
	 */
	public static void GetReady(){
		Input();
	}
	
	public static void GetReady(String prompt){
		Out.Print(prompt);
		Input();
	}
	
	/**
	 * Alias for the private Input method
	 * @return String The line of string input from the user
	 */
	public static String GetString() throws InvalidInputException {
		String str = Input();
		if (str.equals("")){
			throw new InvalidInputException("Did not receive valid input");
		}
		else {
			return str;
		}
	}
	
	/**
	 * @override
	 * Alias for the private Input method
	 * @param prompt A string to prompt the user to give input
	 * @return String The line of string input from the user
	 */
	public static String GetString(String prompt) throws InvalidInputException {
		Out.Print(prompt);
		return GetString();
	}
	
	/**
	 * Get an integer from the user
	 * @return int The integer given by the user (returns Integer.MIN_VALUE if the input could not be converted to an integer)
	 */
	public static int GetInteger() throws InvalidInputException {
		String myInput = GetString();
		
		try {
			return Numbers.toInt(myInput);
		}
		catch (NumberFormatException e){
			throw new InvalidInputException("Could not parse input as an Integer.");
		}
	}
	
	/**
	 * @override
	 * Get an integer from the user
	 * @param prompt A string to prompt the user to give input
	 * @return int The integer given by the user (returns Integer.MIN_VALUE if the input could not be converted to an integer)
	 */
	public static int GetInteger(String prompt) throws InvalidInputException {
		Out.Print(prompt);
		return GetInteger();
	}
	
	/**
	 * Get an integer from the user
	 * @return int The integer given by the user (returns Integer.MIN_VALUE if the input could not be converted to an integer)
	 */
	public static double GetDouble() throws InvalidInputException {
		String myInput = GetString();
		try {
			return Numbers.toDouble(myInput);
		}
		catch (NumberFormatException e){
			throw new InvalidInputException("Could not parse input as double");
		}
	}
	
	/**
	 * @override
	 * Get a double from the user
	 * @param prompt A string to prompt the user to give input
	 * @return int The integer given by the user (returns Integer.MIN_VALUE if the input could not be converted to an integer)
	 */
	public static double GetDouble(String prompt) throws InvalidInputException {
		Out.Print(prompt);
		return GetDouble();
	}
	
	/**
	 * Get a boolean based on input from the user
	 * @return boolean True or False based on the provided input from the user (If invalid entry, returns false)
	 */
	
	public static boolean GetBoolean() throws InvalidInputException {
		String response = GetString().toLowerCase();
		switch (response) {
			case "y":
			case "yes":
			case "t":
			case "true":
				return true;
			case "n":
			case "no":
			case "f":
			case "false":
				return false;
			default:
				throw new InvalidInputException("Could not parse input");	
		}
	}
	
	/**
	 * @override
	 * Get a boolean based on input from the user
	 * @param bool true for a true/false only response or false for yes/no
	 * @return boolean True or False based on the provided input from the user (If invalid entry, returns false)
	 */
	
	public static boolean GetBoolean(boolean bool) throws InvalidInputException {
		String response = GetString().toLowerCase();
		if (bool) {
			switch (response) {
				case "t":
				case "true":
					return true;
				case "f":
				case "false":
					return false;
				default:
					throw new InvalidInputException("Could not parse input");	
			}
		}
		else {
			switch (response) {
				case "y":
				case "yes":
					return true;
				case "n":
				case "no":
					return false;
				default:
					throw new InvalidInputException("Could not parse input");	
			}
		}
	}
	
	/**
	 * @override
	 * Get a boolean based on input from the user
	 * @param prompt Prompt the user for an answer
	 * @return boolean True or False based on the provided input from the user
	 */
	
	public static boolean GetBoolean(String prompt) throws InvalidInputException {
		Out.Print(prompt);
		return GetBoolean();
	}
	
	/**
	 * @override
	 * Get a boolean based on input from the user
	 * @param prompt Prompt the user for an answer
	 * @param bool true for a true/false only response or false for yes/no
	 * @return boolean True or False based on the provided input from the user
	 */
	
	public static boolean GetBoolean(String prompt, boolean bool) throws InvalidInputException {
		Out.Print(prompt);
		return GetBoolean(bool);
	}
	
	public static boolean GetBoolean(String t, String f) throws InvalidInputException {
		String response = GetString().toLowerCase();
		t = t.toLowerCase();
		f = f.toLowerCase();
		if (response.length() < 1){
			response = ".";
		}
		if (response.equals(t) || response.charAt(0) == t.charAt(0)){
			return true;
		}
		else if (response.equals(f)|| response.charAt(0) == f.charAt(0)){
			return false;
		}
		else {
			throw new InvalidInputException("Input did not match provided parameters");	
		}
	}
	
	public static boolean GetBoolean(String prompt, String t, String f) throws InvalidInputException {
		Out.Print(prompt);
		return GetBoolean(t, f);
	}
	
	public static double[] GetDoubleArray() throws InvalidInputException {
		String input = GetString();
		String[] inputArr = input.split(",");
		double[] dblArr = new double[inputArr.length];
		for (int i = 0; i < inputArr.length; i++) {
			try {
				dblArr[i] = Double.parseDouble(inputArr[i].trim());
			}
			catch (Exception e) {
				throw new InvalidInputException("Could not parse item "+i+" as Double");
			}
		}
		return dblArr;
	}
	
	public static double[] GetDoubleArray(String prompt) throws InvalidInputException {
		Out.Print(prompt);
		return GetDoubleArray();
	}
}
