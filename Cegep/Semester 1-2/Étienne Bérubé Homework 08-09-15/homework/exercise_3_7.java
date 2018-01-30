package homework;

import java.util.Scanner;

public class exercise_3_7 
{

	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		
		int remainingAmount;
		double ammount;
		int numberOfDollars;
		int numberOfQuarters;
		int numberOfDimes;
		int numberOfNickels;
		int numberOfPennies;
		
		System.out.print("Enter an ammount: ");
		ammount = input.nextDouble();
		remainingAmount = (int) (ammount*100);
		
		numberOfDollars = remainingAmount / 100;
		remainingAmount = remainingAmount % 100;
		
		numberOfQuarters = remainingAmount / 25;
		remainingAmount = remainingAmount % 25;
		
		numberOfDimes = remainingAmount / 10;
		remainingAmount = remainingAmount % 10;
		
		numberOfNickels = remainingAmount / 5;
		remainingAmount = remainingAmount % 5;
		
		numberOfPennies = remainingAmount;
		
		System.out.println("You have: ");
				
		if (numberOfDollars > 1)
			System.out.println(numberOfDollars + " dollars");
		else
			System.out.println(numberOfDollars + " dollar");
		
		if (numberOfQuarters > 1)
			System.out.println(numberOfQuarters + " quarters");
		else
			System.out.println(numberOfQuarters + " quarter");
		
		if (numberOfDimes > 1)
			System.out.println(numberOfDimes + " dimes");
		else
			System.out.println(numberOfDimes + " dime");
		
		if (numberOfNickels > 1)
			System.out.println(numberOfNickels + " nickels");
		else
			System.out.println(numberOfNickels + " nickel");

		if (numberOfPennies > 1)
			System.out.println(numberOfPennies + " pennies");
		else
			System.out.println(numberOfPennies + " penny");
	}

}
