package libs;

public class Convert {	
	public static double FahrenheitToCelsius(double fahr){
		double cels = (fahr - 32) * (5/9.0);
		return cels;
	}
	
	public static double CelsiusToFahrenheit(double cels){
		double fahr = cels * (9/5.0) + 32;
		return fahr;
	}
}
