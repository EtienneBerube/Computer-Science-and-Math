package Homework;

import java.util.*;
public class exercise_2_5
{

	public static void main(String[] args) 
	{
		
		Scanner input = new Scanner(System.in);
		double subtotal;
		double taxe; //or gratuity but it looks like the same
		double total;
		
		System.out.print("Please enter the Subtotal ");
		subtotal = input.nextDouble();
		System.out.print("Please enter the taxes ");
		taxe = input.nextDouble();
		total = ((taxe/100 * subtotal) + subtotal);
		System.out.print("Here is the total " + total +"$");

	}

}
