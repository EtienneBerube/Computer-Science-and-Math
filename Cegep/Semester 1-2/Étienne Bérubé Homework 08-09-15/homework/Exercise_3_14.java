package homework;

import java.util.*;

public class Exercise_3_14 
{

	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		int guess;
		double coin;
		
		coin = Math.random();
		
		if (coin < 0.5)
			coin = 0;
			
		else 
			coin = 1;
		
		System.out.println("Please enter a guess \n0=head \n1=tail");
		guess = input.nextInt();
		
		if (guess == coin)
			System.out.println("Good boyyy [give a treat]");
		
		else
			System.out.println("Bad boy, no! [slap on the nose]");

	}

}
