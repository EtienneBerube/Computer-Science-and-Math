package Homework;

import java.util.*;
import static java.lang.Math.PI;

public class exercise_2_2 
{

	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		
		float radius;
		float lenght;
		double area;
		double volume;
		
		System.out.print("Please enter the Radius ");
		radius = input.nextFloat();
		
		System.out.print("Now enter the lenght ");
		lenght = input.nextFloat();
		area = (Math.pow(radius, 2) * PI);
		
		System.out.println("Here is the area " + area);
		volume = area * lenght;
		
		System.out.println("Here is the volume " + volume);

	}

}
