package homework;

import java.util.*;

public class exercise_3_2
{

	public static void main(String[] args) 
	{
		Scanner input= new Scanner(System.in);
		int number1;
		int number2;
		int number3;
		int answer;
		
		number1 = (int)(Math.random() * 10);
		number2 = (int)(Math.random() * 10);
		number3 = (int)(Math.random() * 10);
		
		System.out.println("Enter the sum of these three digits: " + number1 + " and " + number2 + " and " + number3);
		
		 
		System.out.print("Enter your answer ");
		answer = input.nextInt();
		
		System.out.println("the sum of " + number1 +" and " + number2 + " and " + number3 + " is " + answer);
		System.out.println("this is " + ( number1 + number2 + number3 == answer));

	}

}
