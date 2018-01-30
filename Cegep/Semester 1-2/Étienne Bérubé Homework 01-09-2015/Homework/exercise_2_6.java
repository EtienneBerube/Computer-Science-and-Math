package Homework;

import java.util.*;

public class exercise_2_6 
{

	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		int  number;
		int  sum;
		
		System.out.print("Enter a number from 0 to 1000 ");
		number = input.nextInt();
		
		if (number > 1000) 
		{
			System.out.print("I said between 0 and 1000... Now restart the program...");
		}
		
		else 
		{
			
			sum = ((number % 10) + ((number / 10) % 10) + ((number / 100) %10) + ((number / 1000) %10));
 			System.out.println(sum);
		}
	}

}
