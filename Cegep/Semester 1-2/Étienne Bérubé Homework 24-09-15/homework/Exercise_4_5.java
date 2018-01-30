package homework;

import java.util.Scanner;

public class Exercise_4_5 
{

	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		double n; //number of sides
		double s;//lenght of one side
		double area;
		
		System.out.print("Enter the number of sides of a polygon: ");
		n = input.nextDouble();
		
		System.out.print("Enter the lenght of a side of a polygon in cm: ");
		s = input.nextDouble();
		
	
		area = (n * Math.pow(s, 2))/(4 * Math.tan(Math.PI/n));
		
		System.out.printf("The area is: %1.3f cm^2", area);

	}

}
