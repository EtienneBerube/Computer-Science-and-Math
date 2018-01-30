package Homework;

import java.util.*;

public class exercise_2_3 
{

	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		double feet;
		double meter;
		
		System.out.print("Enter the mesure in feet ");
		feet = input.nextDouble();
		meter = feet * 0.305;
		System.out.println("Here is your mesure in meters " + meter);
		

	}

}
