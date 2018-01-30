package homework;

import java.util.*;

public class Exercise_5_1 
{

	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		
		
		double number;
		double sum;
		int numberOfPositivNumbers;
		int numberOfNegativNumbers;
		int numberOfNumbers;
		double average;
	
		
		sum = 0;
		numberOfNegativNumbers = 0;
		numberOfPositivNumbers = 0;
		numberOfNumbers = 0;
		
		
		System.out.print("Enter the numbers you want to sum, the input ends if it is 0: ");
		number = input.nextInt();
		
		while (number != 0)
		{
			sum += number;
			
		if (number < 0)
			numberOfNegativNumbers++;
		
		else 
			numberOfPositivNumbers++;
		
		number = input.nextInt();
		}
		//

		numberOfNumbers = numberOfPositivNumbers + numberOfNegativNumbers;
		
		System.out.println("There is "  + numberOfPositivNumbers + " positiv numbers that you entered");
		System.out.println("There is "  + numberOfNegativNumbers + " negativ numbers that you entered");
		System.out.println("The sum of the number you entered is: " + sum);
		average = sum/numberOfNumbers;
		System.out.printf("The average is %1.2f", average);
		
		
		
		
		
		
		

	}

}
