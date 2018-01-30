package Homework;

//Program that converts celsius in farenheit

import java.util.*;

public class exercise_2_1 
{

	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		double TemperatureInCelsius;
		double TemperatureInFarenheit;
		
		System.out.print("Enter the temperature in Celsius ");
		
		TemperatureInCelsius = input.nextDouble();
		TemperatureInFarenheit = (9.0/5) * TemperatureInCelsius + 32;
		
		System.out.println(TemperatureInFarenheit);

	}

}
