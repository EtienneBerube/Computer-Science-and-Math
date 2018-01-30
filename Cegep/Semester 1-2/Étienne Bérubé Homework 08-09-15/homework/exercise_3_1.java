package homework;

import java.util.*;

public class exercise_3_1 
{

	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		double a;
		double b;
		double c;
		double discriminent;
		double r1;
		double r2;
		
		
		System.out.print("enter parameter a: ");
		a = input.nextDouble();
		
		System.out.print("enter parameter b: ");
		b = input.nextDouble();
		
		System.out.print("enter parameter c: ");
		c = input.nextDouble();
		
		
		discriminent = (Math.pow(b, 2)) - 4 * a * c;
		
		if (discriminent > 0)
		{
			r1 = (-b + ((Math.pow(discriminent, 0.5))))/(2*a);
			r2 = (-b - ((Math.pow(discriminent, 0.5))))/(2*a);
			
			System.out.print("The rs for the given parameters: " + a + " and " + b + " and " + c + " are " + r1 + " and " + r2);
		}
		
		
		else if (discriminent == 0) 
		{
			r1 = (-b + ((Math.pow(discriminent, 0.5))))/(2*a);
			
			System.out.print("There's only one value of r with the parameters " + a + " and " + b + " and " + c +" and it is " + r1);
		}
		
		else if (discriminent < 0)
		{
			System.out.print("There's no r values");
		}
		
		
	}

}
