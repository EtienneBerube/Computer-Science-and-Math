package homework;

import java.util.*;

public class exercise_3_8 
{

	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		int number1;
		int number2;
		int number3;
		
		System.out.print("Enter three intergers: ");
		number1 = input.nextInt();
		number2 = input.nextInt();
		number3 = input.nextInt();
		
		if (number1 < number2)
		{
			if (number2 < number3)
			{
				System.out.print(number1 +" "+ number2 +" "+ number3);
			}
			
			else
				System.out.print(number1 +" "+ number3 +" "+ number2);
		}
		
		else if (number2 < number1)
		{
			if (number1 < number3)
			{
				System.out.print(number2 +" "+ number1 +" "+ number3);
			}
			
			else
				System.out.print(number2 +" "+ number3 +" "+ number1);
		}
		
		else if (number3 < number2)
		{
			if (number2 < number1)
			{
				System.out.print(number3 +" "+ number2 +" "+ number1);
			}
			
			else
				System.out.print(number3 +" "+ number1 +" "+ number2);
		}

	}

}
