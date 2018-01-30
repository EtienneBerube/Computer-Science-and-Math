package homework;

import java.util.*;

public class exercise_3_3 //working weird...
{

	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		double a;
		double b;
		double c;
		double d;
		double e;
		double f;
		double divider;
		double x;
		double y;
		
		System.out.print("Please enter the a parameter: ");
		a = input.nextDouble();
		
		System.out.print("Please enter the b parameter: ");
		b = input.nextDouble();
		
		System.out.print("Please enter the c parameter: ");
		c = input.nextDouble();
		
		System.out.print("Please enter the d parameter: ");
		d = input.nextDouble();
		
		System.out.print("Please enter the e parameter: ");
		e = input.nextDouble(); 
		
		System.out.print("Please enter the f parameter: ");
		f = input.nextDouble();
		
		divider = (a * d) - (b * c);
		
		System.out.print(divider);
		
		if (divider <= 0) 
		{
			System.out.println("there is no solution");
		}
		
		else 
		{
			x = (e * d - b * f)/divider;
			y = (a * f - e * c)/divider;
			
			System.out.print("The solution is: x = " + x + " and y is " + y);
		}

	}

}
