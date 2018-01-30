package Homework;

import java.util.*;

public class exercise_2_13 
{

	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		double  Amount;
		double Value;
		double AnnualRate;
		
		System.out.print("Please enter a starting amount ");
		Amount = input.nextDouble();
		System.out.println("Please enter the annual interest rate ");
		System.out.println("Please take note that the interests are compiled monthly: ");
		AnnualRate = input.nextDouble();
		
		//after one month
		Value = Amount * (1 + (AnnualRate/100)/12);
		
		//after two months
		Value = (Amount + Value) * (1 + (AnnualRate/100)/12);
				
		//after three months		
		Value = (Amount + Value) * (1 + (AnnualRate/100)/12);
		
		//after four months
		Value = (Amount + Value) * (1 + (AnnualRate/100)/12);
		
		//after five months
		Value = (Amount + Value) * (1 + (AnnualRate/100)/12);
		
		//after six months
		Value = (Amount + Value) * (1 + (AnnualRate/100)/12);
		
		System.out.println("here is the value after the end of the sixth month: " +(float) Value +"$");

	}

}
