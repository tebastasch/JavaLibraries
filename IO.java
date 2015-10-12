/**
 * @author Michael Bryant (Shadow53)
 */

package libs;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Scanner;

public class IO {
	public static void NewLine(){
		System.out.println();
	}
	
	/**
	 * Prints a string to the console
	 * @param str The string to print to the console
	 */
	public static void Print(String str){
		System.out.println(str);
	}
	
	/**
	 * Prints an Integer to the console
	 * @param str The string to print to the console
	 */
	public static void Print(int myInt){
		System.out.println(myInt);
	}
	
	/**
	 * Prints a Double to the console
	 * @param dbl The string to print to the console
	 */
	public static void Print(double dbl){
		System.out.println(dbl);
	}
	
	/**
	 * Prints a boolean to the console
	 * @param bool The boolean to print
	 */
	public static void Print(boolean bool){
		System.out.println(bool);
	}
	
	/**
	 * @override
	 * Prints multiple strings to the console on separate lines
	 * @param strArr An array of strings to each be printed on new lines
	 */
	public static void Print(String[] strArr){
		for (int i = 0; i < strArr.length; i++) {
			Print(strArr[i]);
		}
	}
	
	/**
	 * @override
	 * Prints multiple integers to the console on separate lines
	 * @param intArr An array of integers to each be printed on new lines
	 */
	public static void Print(int[] intArr){
		for (int i = 0; i < intArr.length; i++) {
			Print(intArr[i]);
		}
	}
	
	/**
	 * @override
	 * Prints multiple doubles to the console on separate lines
	 * @param dblArr An array of doubles to each be printed on new lines
	 */
	public static void Print(double[] dblArr){
		for (int i = 0; i < dblArr.length; i++) {
			Print(dblArr[i]);
		}
	}
	
	/**
	 * @override
	 * Prints multiple booleans to the console on separate lines
	 * @param boolArr The boolean to print
	 */
	public static void Print(boolean[] boolArr){
		for (int i = 0; i < boolArr.length; i++) {
			Print(boolArr[i]);
		}
	}
	
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
		Print(prompt);
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
		IO.Print(prompt);
		return GetInteger();
	}
	
	/**
	 * Get an integer from the user
	 * @return int The integer given by the user (returns Integer.MIN_VALUE if the input could not be converted to an integer)
	 */
	public static double GetDouble() throws InvalidInputException {
		String myInput = GetString();
		return Numbers.toDouble(myInput);
	}
	
	/**
	 * @override
	 * Get a double from the user
	 * @param prompt A string to prompt the user to give input
	 * @return int The integer given by the user (returns Integer.MIN_VALUE if the input could not be converted to an integer)
	 */
	public static double GetDouble(String prompt) throws InvalidInputException {
		String myInput = GetString(prompt);
		return Numbers.toDouble(myInput);
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
				return false;	
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
					return false;	
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
					return false;
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
		Print(prompt);
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
		Print(prompt);
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
			// TODO: return false?
			return GetBoolean(t, f);
		}
	}
	
	public static boolean GetBoolean(String prompt, String t, String f) throws InvalidInputException {
		Print(prompt);
		return GetBoolean(t, f);
	}
	
	public static double[] GetDoubleArray() throws InvalidInputException {
		String input = GetString();
		String[] inputArr = input.split(",");
		double[] dblArr = new double[inputArr.length];
		for (int i = 0; i < inputArr.length; i++) {
			try {
				dblArr[i] = Double.parseDouble(inputArr[i]);
			}
			catch (Exception e) {
				
			}
			finally {
				
			}
		}
		return dblArr;
	}
	
	public static double[] GetDoubleArray(String prompt) throws InvalidInputException {
		Print(prompt);
		return GetDoubleArray();
	}
	
	public static void AppendToFile(String fileLocation, String data) throws IOException{
		/*try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileLocation), "utf-8"))) {
			writer.write(data);
			return writer;
		}*/
		Print("Untested method");
		Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileLocation), "UTF8"));
		writer.write(data);
		writer.close();
	}
	
	public static void WriteToFile(String fileLocation, String data) throws IOException{
		/*try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileLocation), "utf-8"))) {
			writer.write(data);
			return writer;
		}*/
		Print("Untested method");
		Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileLocation), "UTF8"));
		writer.write(data);
		writer.close();
	}
	
	public static void main(String[] args) {
		try{
			Print(GetInteger("Number"));
		}
		catch (InvalidInputException e){
			Print("Exception");
		}
	}
}
