package homework;

import java.util.*;

public class exercise_3_6 
{

	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		
		double weight;
		double weightInKilograms;
		double feet;
		double inches;
		double totalInches;
		double heightInMeters;
		double bmi;
		
		final double KILOGRAMS_PER_POUND = 0.45359237;
		final double METERS_PER_INCH = 0.0254;
		
		System.out.print("Enter your weight in pounds: ");
		weight = input.nextDouble();
		
		System.out.print("Enter the quantity of feet you are composed of (eg. 5'10 would be 5): ");
		feet = input.nextDouble();
		
		System.out.print("Enter the quantity of inches that remains to complete your height (eg. 5'10 would be 10): ");
		inches = input.nextDouble();
		
		totalInches = feet * 12 + inches;
		
		heightInMeters = totalInches * METERS_PER_INCH;
		weightInKilograms = weight * KILOGRAMS_PER_POUND;
		
		bmi = weightInKilograms / Math.pow(heightInMeters, 2);
		
		System.out.println("Your BMI is " + bmi);
		
		if (bmi < 18.5)
			System.out.print("You are underweight");
		else if (bmi < 25)
			System.out.print("You are normal");
		else if (bmi < 30)
			System.out.print("You are overweight");
		else 
			System.out.print("You are obese");
			
		
		

	}

}
