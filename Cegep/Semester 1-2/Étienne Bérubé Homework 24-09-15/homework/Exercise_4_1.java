package homework;

import java.util.*;

public class Exercise_4_1 
{

	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		double s;
		double area;
		
		System.out.print("Enter the lenght of on side of an hexagon in cm: ");
		s = input.nextDouble();
		
		area = (6 * Math.pow(s, 2))/(4 * Math.tan(Math.PI/6));
		
		System.out.printf("The area is: %1.3f cm^2", area);

	}

}
