package homework;

import java.util.*;

public class exercise_3_10 
{

	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		int number1;
		int number2;
		int temporary;
		int answer;
		
		number1 = (int)(Math.random()*100);
		number2 = (int)(Math.random()*100);
		
		if (number1 < number2)
		{
			temporary = number1;
			number1 = number2;
			number2 = temporary;			
		}
		 
		System.out.println("What is " + number1 + " - " + number2);
		answer = input.nextInt();
		
		if (number1 - number2 == answer)
		{
			System.out.println("You are correct!");
		}
		
		else 
		{
			System.out.print("You are wrong! it should be " + (number1-number2));
		}
	}
	

}
